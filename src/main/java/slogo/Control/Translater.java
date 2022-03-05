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

  public Translater() {
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
    for (int i = 0; i < numParams; i++) {
      params[i] = allCommands.get(allCommands.indexOf(command) + i + 1);
      if (syntaxParser.getSymbol((String) params[i]).equals("UserCommand")) {
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
        commentFreeCommands.append(token + " ");
      }
    }
    return commentFreeCommands.toString();
  }

  private boolean checkIfParamExists(String currentCommand) {

    return false;
  }


  // only add results of commands to constant stack if command stack . size > 0
  // commands dont look t the constnay stack
  // constants look at the command stakc and comapre numParams to comstant stac ,size

  /**
   * @param program String of the commands
   * @throws CommandException
   */
  void parseText(String program) throws Exception {
    program = removeComments(program);
    for (String token : program.split(WHITESPACE)) {
      if (syntaxParser.getSymbol(token).equals("UserCommand")) {
        String currentCommand = commandParser.getSymbol(token);

          commandStack.add(currentCommand);
          continue;

      } else if (syntaxParser.getSymbol(token).equals("Constant")) {
        constantStack.add(new Argument(token, Double.parseDouble(token)));

        if (commandStack.isEmpty()) {
          continue;
        }
        else {
          String previousCommand = commandStack.peek();
          int numParams = getNumParams(previousCommand);
          if (numParams > constantStack.size()) {
            continue;
          }
          else {
            makeCommandAndPopFromStack(previousCommand, numParams);
          }
        }
      }
    }

    while (commandStack.size() > 0) {
      String currentCommand = commandStack.peek();
      makeCommandAndPopFromStack(currentCommand, getNumParams(currentCommand));
    }
    if (constantStack.size() > 0) {
      throw new CommandException("there are more constants than needed!");
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
  private void addToValidCommandsAndConstantStack(String command, double[] args)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    String commandType = getCommandType(command);
    Class<?> clazz = Class.forName(
        "slogo.Model.Commands." + commandType + "." + command + "Command");
    Class<?>[] type = {double[].class};
    Constructor<?> cons = clazz.getConstructor(type);
    Object[] obj = {args};
    Object newInstance = cons.newInstance(obj);
    validCommands.add(newInstance);

    if (commandStack.size() > 0) {
      Method execute = clazz.getMethod("getValue");
      double value = (double) execute.invoke(newInstance);
      constantStack.add(new Argument(command, value));
    }
  }


  private void makeCommandAndPopFromStack(String currentCommand, int numParams)
      throws CommandException {
    double[] args;
    args = new double[numParams];
    try {
      for (int i = 0; i < numParams; i++) {
        args[i] = constantStack.pop().getValue();
      }
      commandStack.pop();
      addToValidCommandsAndConstantStack(currentCommand, args);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      throw new CommandException("Not enough constants for the given command: "+ currentCommand);
    }
  }

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
    t.parseText("fd rt 20 ");
    System.out.println(t.validCommands);
  }
}
