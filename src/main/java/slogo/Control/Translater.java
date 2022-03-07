package slogo.Control;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class Translater {

  public static final String WHITESPACE = "\\s+";
  public static final char HASHTAG = '#';
  private static boolean openBracket;
  public static final String NO_MATCH = "NO MATCH";
  public static final String SYNTAX = "Syntax";
  public static final String PARAMS = "Params";
  public static final String TYPES = "Types";
  public static final String RESOURCES_PACKAGE = "slogo.languages.";
  public static final String EXCEPTIONS = "ParserExceptions";
  public static final String EVALUATE_COMMAND = "getValue";
  public static final String SPACE = " ";
  public List<Object> validCommands = new ArrayList<>();
  List<Entry<String, Pattern>> mySymbols;

  private static final String DEFAULT_LANG = "English";
  private final CommandParser syntaxParser;
  private final CommandParser commandParser;
  private static final Stack<Argument> constantStack = new Stack<>();
  private static final Stack<String> commandStack = new Stack<>();

  /**
   * this is the main class that's responsible for parsing
   * it initializes a syntaxParser, a commandParser, and a parameterParser
   */
  public Translater() {
    syntaxParser = new CommandParser();
    commandParser = new CommandParser();
    syntaxParser.addPatterns(SYNTAX);
    commandParser.addPatterns(DEFAULT_LANG);
    commandParser.addPatterns(SYNTAX);

  }


  /**
   * @param language String name of the language we want to parse in
   */
  public void setLanguage(String language){
    commandParser.reset();
    commandParser.addPatterns(language);
    commandParser.addPatterns(SYNTAX);
  }
  /**
   * @param userCommands a String of the commands the user passes
   * @return a comment-free version of the same String
   */
  private String removeComments(String userCommands) {
    StringBuilder commentFreeCommands = new StringBuilder();
    Scanner input = new Scanner(userCommands);
    while (input.hasNextLine()) {
      String line = input.nextLine();
      Scanner nextLine = new Scanner(line);
      if (!line.isEmpty() && line.charAt(0) == HASHTAG) {
        continue;
      }
      while (nextLine.hasNext()) {
        String token = nextLine.next();
        commentFreeCommands.append(token).append(SPACE);
      }
    }
    return commentFreeCommands.toString();
  }


  /**
   * @param token String in the user-passed string
   * @return the type of the token (List Start, Constant, ...)
   */
  private String getTokenType(String token){
    return syntaxParser.getSymbol(token);
  }

  /**
   * main parsing algorithm
   * @param program String of the commands the user passes
   * @throws CommandException depdening on the situation (wrong token, too many constants)
   */
  void parseText(String program) throws Exception {
    resetCommands();
    program = removeComments(program);
    LinkedList group = null;
    for (String token : program.split(WHITESPACE)) {
      if (syntaxParser.getSymbol(token).equals(NO_MATCH)){
        throw new CommandException(getCommandException("wrongToken").formatted(token));
      }
      if (syntaxParser.getSymbol(token).equals("UserCommand")) {
        handleUserCommand(token);
      }
      else if (syntaxParser.getSymbol(token).equals("Constant")) {
        handleConstant(openBracket, group, token);
      }
      else if (syntaxParser.getSymbol(token).equals("ListStart")){
        openBracket = true;
        constantStack.add(new Argument(token, 0.0));
        group = new LinkedList();
      }

      else if (syntaxParser.getSymbol(token).equals("ListEnd")) {
        handleListEnd(group, token);
      }
    }
    // reached the end of the String, checks if commands are waiting
    while (commandStack.size() > 0) {
      String currentCommand = commandStack.peek();
      makeCommandAndPopFromStack(currentCommand, getNumParams(currentCommand), openBracket, group);
    }
    // no commands are waiting but there are constants left: error!
    if (constantStack.size() > 0) {
      throw new CommandException(getCommandException("tooManyConstants"));
      }
    }

  private void handleListEnd(LinkedList group, String token) throws Exception {
    constantStack.add(new Argument(token, 0.0));
    popList(constantStack);
    //constantStack now should only have number of repeats
    String repeatCommand = commandStack.peek();
    assert group != null;
    Argument arg = (Argument) group.getLast();
    constantStack.add(new RepeatArgument(group, arg.getValue()));
    makeCommandAndPopFromStack(repeatCommand, getNumParams(repeatCommand), false, group);
  }

  private void handleConstant(boolean openBracket, LinkedList group, String token) throws Exception {
    constantStack.add(new Argument(token, Double.parseDouble(token)));
    if (!commandStack.isEmpty()) {
      String previousCommand = commandStack.peek();
      int numParams = getNumParams(previousCommand);
      if (numParams <= constantStack.size()) {
        makeCommandAndPopFromStack(previousCommand, numParams, openBracket, group);
      }
    }
  }

  private void handleUserCommand(String token) throws Exception {
    String currentCommand = commandParser.getSymbol(token);
    if (getNumParams(currentCommand) == 0){
      validCommands.add(currentCommand);
    }
    else{
    commandStack.add(currentCommand);
    }
  }

  private void popList(Stack constantStack) {
      Argument currentArgument = (Argument) constantStack.peek();
      while (!currentArgument.getName().equals("[")) {
        constantStack.pop();
        currentArgument = (Argument) constantStack.peek();
      }
      constantStack.pop(); // the LIST_LEFT that remains
    }
  /**
   * @param command the name of the command we are trying to create
   * @param args the double[] passed to create the command
   * @param openBracket tells if a bracket is open (making a list of repeating commands)
   * @param group the group of commands inside the bracket
   * @throws CommandException generic error thrown if the reflection makes and exception
   */
  private void addToValidCommandsAndConstantStack(String command, double[] args, boolean openBracket, Queue group)
      throws CommandException {
    try {
      String commandType = getCommandType(command);
      Class<?> clazz = Class.forName(
          "slogo.Model.Commands." + commandType + "." + command + "Command");
      Class<?>[] type = {double[].class};
      Constructor<?> cons = clazz.getConstructor(type);
      Object[] obj = {args};
      Object newInstance = cons.newInstance(obj); //this Object could instead be a Command object
      if (!openBracket) {
        validCommands.add(newInstance);
      }
      if (commandStack.size() > 0) {
        Method execute = clazz.getMethod(EVALUATE_COMMAND);
        double value = (double) execute.invoke(newInstance);
        Argument argument = new Argument(command, value);
        constantStack.add(argument);
        if (openBracket){
          group.add(argument);
        }

      }
    }
    catch (Exception e){
      // this catches any error while trying to use reflection to make the Command class and adding it to the list of validCommands
      throw new CommandException(getCommandException("reflectionError").formatted(command));
    }

  }


  /**
   * this method is used during the parsing, it creates a valid command and pops it from the commandStack
   * @param currentCommand the currentCommand we are trying to make
   * @param numParams the number of Parameters the command expects
   * @param openBracket tells if a bracket is open (making a list of repeating commands)
   * @param group the group of commands inside the bracket
   * @throws CommandException if there are not enough constants to make the command
   */
  void makeCommandAndPopFromStack(String currentCommand, int numParams, boolean openBracket, Queue group)
      throws CommandException {
    double[] args;
    args = new double[numParams];
    try {
      for (int i = 0; i < numParams; i++) {
        args[numParams-i-1] = constantStack.pop().getValue();
      }
      commandStack.pop();
      addToValidCommandsAndConstantStack(currentCommand, args, openBracket, group);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      throw new CommandException(getCommandException("notEnoughConstants").formatted(currentCommand));
    }
  }

  /**
   * @param text the string we are trying to match
   * @param regex the pattern against which we are matching
   * @return true if the text matches the pattern
   */
  public boolean match(String text, Pattern regex){
    return text != null && regex.matcher(text.trim()).matches();
  }

  /**
   * @param command String name of the command
   * @return fetches the type of the command (TurtleCommand, Query, ...)
   * used by Parser to decide what to do depending on command type
   */
  private String getCommandType(String command){
    return ResourceBundle.getBundle(RESOURCES_PACKAGE+TYPES).getString(command);
  }

  /**
   * @param command String of the name of the command we want to find the number of parameters it expects
   * @return the number of parameters command expects
   * @throws Exception if the command cannot be found in the resource file
   */
  private int getNumParams(String command) throws Exception {
    try{
      return Integer.parseInt(ResourceBundle.getBundle(RESOURCES_PACKAGE+PARAMS).getString(command));
    }
    catch(Exception e){
      throw new CommandException(getCommandException("numParamsError").formatted(command));
    }
  }

  /**
   * @param exceptionName String of the name of the exception to fetch from the Resource file
   * @return the corresponding String to the passed name, an Exception message to display
   */
  public static String getCommandException(String exceptionName){
    return ResourceBundle.getBundle(RESOURCES_PACKAGE+ EXCEPTIONS).getString(exceptionName);
  }

  /**
   * @param filePath the path of the File we want to load commands from
   * @return a String of the same file that can be used by ParseText
   * @throws CommandException if there are issues with the File
   */
  public static String readFile(String filePath) throws CommandException {
    try {
      return Files.readString(Path.of(filePath));
    }
    catch(IOException e){
      throw new CommandException(getCommandException("fileIssue").formatted(filePath));
    }
    }

  /**
   * @return the List of all Commands after being parsed. The Model calls this function on the turtle
   * making the parser completely independent from the Turtle.
   * The only assumption is that the Model expects a List.
   */
  public List getCommands(){
    return validCommands;
  }

  public void resetCommands(){
    validCommands = new ArrayList<>();
  }

  public static void main(String[] args)
      throws Exception {
    Translater t = new Translater();
    //t.parseText("pu");
//    System.out.println(t.validCommands);
//    t.parseText("fd 200 rt 20");
    t.parseText(readFile("data/examples/simple/square_centered.slogo"));
    System.out.println(t.validCommands);
  }
}
