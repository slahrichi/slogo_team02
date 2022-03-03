package slogo.Control;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class Translater {

  public static final String WHITESPACE = "\\s+";
  public static final char HASHTAG = '#';
  public static final String NO_MATCH = "NO MATCH";
  public static final String SYNTAX = "Syntax";
  public static final String PARAMS = "Params";
  public static final String TYPES = "Types";
  public static final String RESOURCES_PACKAGE = "slogo.languages.";
  public List<Object> validCommands = new ArrayList<>();
  List<Entry<String, Pattern>> mySymbols;

  private static final String DEFAULT_LANG = "English";
  private CommandParser syntaxParser;
  private CommandParser commandParser;
  private ParamParser paramParser;
  private static Stack<Argument> constantStack = new Stack<>();
  private static Stack<String> commandStack = new Stack<>();

  public Translater(){
    syntaxParser = new CommandParser();
    commandParser = new CommandParser();
    paramParser = new ParamParser();
    syntaxParser.addPatterns(SYNTAX);
    commandParser.addPatterns(DEFAULT_LANG);
    commandParser.addPatterns(SYNTAX);
    paramParser.addPatterns(PARAMS);
  }


  void parseTextTest(String program) throws Exception {
    Scanner input = new Scanner(program);
    List<String> allCommands = new ArrayList<>();
    while (input.hasNextLine()) {
      String line = input.nextLine();
      Scanner nextLine = new Scanner(line);
      if (!line.isEmpty() && line.charAt(0) == HASHTAG) {
        continue;
      }
      while (nextLine.hasNext()) {
        String token = nextLine.next();
        allCommands.add(token);
      }
      nextLine.close();
    }
    input.close();
    handle(allCommands);
  }

  void handle(List<String> allCommands) throws Exception {
    for (String command : allCommands) {
      if (syntaxParser.getSymbol(command).equals("UserCommand")) {
        handleCommand(allCommands, command);
      }
    }
  }

  void handleCommand(List<String> allCommands, String command) throws Exception {
    Object[] params;
    String commandType = getCommandType(command);
    int numParams = getNumParams(command);
    params = new Object[numParams];
    for (int i = 0; i<numParams; i++){
      params[i] = allCommands.get(allCommands.indexOf(command)+i+1);
      if (syntaxParser.getSymbol((String)params[i]).equals("UserCommand")){
        handleCommand(allCommands.subList(i, allCommands.size()), (String) params[i]);
      }
    }
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
        commentFreeCommands.append(token);
      }
    }
    return commentFreeCommands.toString();
    }

    private boolean checkIfParamExists(String currentCommand) {

    return false;
    }
  /**
   * @param program String of the commands
   * @throws CommandException
   */
  void parseText(String program) throws Exception {
    program = removeComments(program);
    for (String token : program.split(WHITESPACE)) {
      if (syntaxParser.getSymbol(token).equals("UserCommand")) {
        String currentCommand = commandParser.getSymbol(token);
        int numParams = getNumParams(currentCommand);
        if (constantStack.peek() == null || constantStack.size() < numParams) { // no/not enough parameters in stack waiting
          commandStack.add(currentCommand);
          continue; //does this go out of everything and advance the for String token loop?
        }
        else if (constantStack.size() == numParams){
          makeCommandAndPopFromStack(currentCommand, numParams);
        }
        //new CommandMaker(currentCommand).makeCommand(validCommands);
      }
      // if there are constants, what do I do?
      // say there is one, and I only need one, then I can pop it
      // what if I need two, and can only find one
      // or need two, but find commands instead, how do I go and parse them (the commands)
      // current logic: if you peek numArgs times and find all constants, create command, pop
      // it off commandStack, put it in constantStack
      // if you dont find all constants ???
      else if (syntaxParser.getSymbol(token).equals("Constant")) {
        // check if command waiting
        if (commandStack.isEmpty()) {
          constantStack.add(new Argument(token, Double.parseDouble(token)));
        }
        else {
          String previousCommand = commandStack.peek();
          Argument currentConstant = constantStack.peek();
          int numParams = getNumParams(previousCommand);
          if (numParams == 1) {
            makeCommandAndPopFromStack(previousCommand, numParams);
          }
          else{
            constantStack.add(new Argument(previousCommand, currentConstant.getValue()));
          }
        }
      }
    }
  }

  /**
   * creates command object using the double[] args
   * adds it to validCommands list and constantStack
   * @param command command that hasn't been created
   * @param args
   * @throws ClassNotFoundException
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  private void addToConstantStack(String command, double[] args)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    double value = addToValidCommandsListAndReturnValue(command, args);
    constantStack.add(new Argument(command, value));
  }

  private double addToValidCommandsListAndReturnValue(String command, double[] args)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException{
    String commandType = getCommandType(command);
    Class<?> clazz = Class.forName(
        "slogo.Model.Commands." + commandType + "." + command + "Command");
    Class<?>[] type = {double[].class};
    Constructor<?> cons = clazz.getConstructor(type);
    Object[] obj = {args};
    Object newInstance = cons.newInstance(obj);
    validCommands.add(newInstance);
    Method execute = clazz.getMethod("getValue");
    double value = (double) execute.invoke(newInstance);
    return value;
  }

  private void makeCommandAndPopFromStack(String currentCommand, int numParams)
      throws CommandException {
    double[] args;
    args = new double[numParams];
    try {
      for (int i = 0; i < numParams; i++) {
        args[i] = constantStack.pop().getValue();
      }
      addToConstantStack(currentCommand, args);
      commandStack.pop();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      throw new CommandException("Not enough constants for the given command: "+ currentCommand);
    }
  }

//
//  /**
//   * using the Decorator pattern to hide the instanceOf from the main code and improve readability
//   */
//  private class CommandMaker {
//
//    private String currentCommand;
//
//    public CommandMaker(String currentCommand) {
//      this.currentCommand = currentCommand;
//    }
//    private void makeCommand(List<Argument> validCommands) {
//      if (currentCommand instanceof MathCommands){
//
//      }
//      elif (currentCommand instanceof TurtleCommands){
//
//      }
//    }
//  }

//    public String getSymbol(String text){
//      for (Entry<String, Pattern> e: syntaxParser.mySymbols){
//        if (match(text, e.getValue())){
//          return e.getKey();
//        }
//      }
//      return NO_MATCH;
//    }

  public boolean match(String text, Pattern regex){
    return text != null && regex.matcher(text.trim()).matches();
  }

  private String getCommandType(String command){
    return ResourceBundle.getBundle(RESOURCES_PACKAGE+TYPES).getString(command);
  }

  private int getNumParams(String command) throws Exception {
    try{
      return Integer.parseInt(ResourceBundle.getBundle(RESOURCES_PACKAGE+PARAMS).getString(command));
    }
    catch(Exception e){
      throw new CommandException("Something went wrong while getting the expected number of parameters of command: "+command);
    }
  }

  public static String readFile(String filePath) throws IOException {
    return Files.readString(Path.of(filePath));
  }

  public List getCommands(){
    return validCommands;
  }

  public static void main(String[] args)
      throws Exception {
    Translater t = new Translater();
    //t.parseText("fd rt 20 ");
    t.parseText(readFile("data/examples/simple/square.slogo"));
    System.out.println(t.validCommands);
  }
}
