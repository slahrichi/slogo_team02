package slogo.Control;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
import slogo.Model.Commands.Command;

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

//  void parseParamsTest(Object [] args)
//      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//    for (int i = 0; i < args.length; i++) {
//      Object[] params;
//      String token = (String) args[i];
//      if (syntaxParser.getSymbol(token).equals("UserCommand")) {
//        String commandType = getCommandType(token);
//        int numParams = getNumParams(token);
//        params = new Object[numParams];
//        for (int j = 0; j < numParams; j++) {
//          params[j] = (double) args[i + j + 1];
//          Class<?> clazz = Class.forName(
//              "slogo.Model.Commands." + commandType + "." + token + "Command");
//          Class<?>[] type = {double[].class};
//          Constructor<?> cons = clazz.getConstructor(type);
//          Object[] obj = {args[i + 1]};
//          Object newInstance = cons.newInstance(obj);
//          Method execute = clazz.getMethod("getValue");
//          double value = (double) execute.invoke(newInstance);
//          if (args[i + 1]
//              != null) { //if there is no other command coming up, replace the command with its return for the next one to consume
//            args[i] = value;
//          }
//
//        }
//      }
//      else if (syntaxParser.getSymbol(token).equals("Constant")) {
//        continue;
//      }
//      }
//    }


//  void makeValidCommandsTest(List<String> allCommands) {
//    for (String token : allCommands) {
//      if (syntaxParser.getSymbol(token).equals("UserCommand")) {
//        double[] args;
//        int numParams = getNumParams(token);
//        args = new double[numParams];
//        try {
//          for (int i = 0; i < numParams; i++) {
//            args[i] = allCommands.next//next
//            parseParams(args);
//          }
//          String commandType = getCommandType(command);
//          Class<?> clazz = Class.forName(
//              "slogo.Model.Commands." + commandType + "." + command + "Command");
//          Class<?>[] type = {double[].class};
//          Constructor<?> cons = clazz.getConstructor(type);
//          Object[] obj = {args};
//          Object newInstance = cons.newInstance(obj);
//          validCommands.add(newInstance);
//          // add return of the command to the constant stack
//          // for nested calls (e.g. fd fd 50)
//          if (commandStack.size() == 1) {
//            continue;
//          } else {
//            Method execute = clazz.getMethod("getValue");
//            double value = (double) execute.invoke(newInstance);
//            constantStack.add(value);
//          }
//
//        } else if (syntaxParser.getSymbol(token).equals("Constant")) {
//          // add to constant stack
//          constantStack.add(Double.parseDouble(token));
//        }
//      }
//    }
//  }


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
      //later use reflection to do this too
      if (syntaxParser.getSymbol(token).equals("UserCommand")) {
        // add to command stack
        String currentCommand = commandParser.getSymbol(token);
        int numParams = getNumParams(currentCommand);
        if (constantStack.peek() == null) { // no parameters in stack waiting
          continue;
        }
        double[] args = new double[numParams];
        try {
          for (int i = 0; i < numParams; i++) {
            args[i] = constantStack.pop().getValue();
          }
        } catch (Exception e) {
          continue; // didnt find enough constants in the constantStack
        }
        commandStack.add(currentCommand);
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
          continue;
        }
        else {
          String previousCommand = commandStack.peek();
          Argument currentConstant = constantStack.peek();
          int numParams = getNumParams(previousCommand);
          if (numParams == 1) {
            double[] args;
            args = new double[numParams];
            try {
              for (int i = 0; i < numParams; i++) {
                args[i] = constantStack.pop().getValue();
              }
              addToCommandStack(previousCommand, args);
            }
            catch (Exception e) {
              System.out.println(e.getMessage());
              // throw new CommandException("Not enough constants for the given command: "+ command);
            }
          }
          // add to constant stack
          constantStack.add(new Argument(previousCommand, currentConstant.getValue()));
        }
      }
    }
  }

  private void addToCommandStack(String previousCommand, double[] args)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    String commandType = getCommandType(previousCommand);
    Class<?> clazz = Class.forName(
        "slogo.Model.Commands." + commandType + "." + previousCommand + "Command");
    Class<?>[] type = {double[].class};
    Constructor<?> cons = clazz.getConstructor(type);
    Object[] obj = {args};
    Object newInstance = cons.newInstance(obj);
    validCommands.add(newInstance);
    // add return of the command to the constant stack
    // for nested calls (e.g. fd fd 50)
    Method execute = clazz.getMethod("getValue");
    double value = (double) execute.invoke(newInstance);
    constantStack.add(new Argument(previousCommand, value));
  }


  private void makeCommand(String command){

  }

  /**
   * using the Decorator pattern to hide the instanceOf from the main code and improve readability
   */
  private class CommandMaker {

    private String currentCommand;

    public CommandMaker(String currentCommand) {
      this.currentCommand = currentCommand;
    }
    private void makeCommand(List<Argument> validCommands) {

    }
  }

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

  private void makeValidCommands(Stack constantStack, Stack commandStack)
      throws Exception {
    while (!commandStack.isEmpty()) {
      double [] args;
        String command = (String) commandStack.pop();
        int numParams = getNumParams(command);
        args = new double[numParams];
        try {
          for (int i = 0; i <numParams ; i++) {
            args[i] = (double) constantStack.pop();
          }
          String commandType = getCommandType(command);
          Class<?> clazz = Class.forName("slogo.Model.Commands." + commandType + "." + command + "Command");
          Class<?>[] type = {double[].class};
          Constructor<?> cons = clazz.getConstructor(type);
          Object[] obj = {args};
          Object newInstance = cons.newInstance(obj);
          validCommands.add(newInstance);
          // add return of the command to the constant stack
          // for nested calls (e.g. fd fd 50)
            Method execute = clazz.getMethod("getValue");
            double value = (double) execute.invoke(newInstance);
            constantStack.add(value);
        }
        catch(Exception e){
          System.out.println(e.getMessage());
          // throw new CommandException("Not enough constants for the given command: "+ command);
        }
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
