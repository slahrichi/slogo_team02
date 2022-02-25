package slogo.Controller;

import java.awt.SystemTray;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import slogo.Control.TurtleManager;

public class Translater {

  public static final String WHITESPACE = "\\s+";
  public static final char HASHTAG = '#';
  public static final String NO_MATCH = "NO MATCH";
  public static final String SYNTAX = "Syntax";
  public static final String PARAMS = "Params";

  public static final String RESOURCES_PACKAGE = "slogo.languages.";
  public List<Object> validCommands = new ArrayList<>();
  List<Entry<String, Pattern>> mySymbols;

  private static final String DEFAULT_LANG = "English";
  private CommandParser syntaxParser;
  private CommandParser commandParser;
  private ParamParser paramParser;
//  private static Stack<Double> constantStack = new Stack<>();
//  private static Stack<String> commandStack = new Stack<>();

  private static Queue<Double> constantStack = new LinkedList<Double>();
  private static Queue<String> commandStack = new LinkedList<>();

  public Translater(){
    syntaxParser = new CommandParser();
    commandParser = new CommandParser();
    paramParser = new ParamParser();
    syntaxParser.addPatterns(SYNTAX);
    commandParser.addPatterns(DEFAULT_LANG);
    commandParser.addPatterns(SYNTAX);
    paramParser.addPatterns(PARAMS);
  }


  //this has to be private, made public to test
  private void parseText(String program)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CommandException {
    Scanner input = new Scanner(program);
//    Stack<Double> constantStack = new Stack<>();
//    Stack<String> commandStack = new Stack<>();
    while (input.hasNextLine()) {
      String line = input.nextLine();
      Scanner nextLine = new Scanner(line);
      if (!line.isEmpty() && line.charAt(0) == HASHTAG) {
        continue;
      }
      while (nextLine.hasNext()) {
        String token = nextLine.next();
        //later use reflection to do this too
        if (syntaxParser.getSymbol(token).equals("UserCommand")) {
          // add to command stack
          commandStack.add(commandParser.getSymbol(token));
          //  int expectedParameters/reflection
        }
        else if (syntaxParser.getSymbol(token).equals("Constant")){
          // add to constant stack
          constantStack.add(Double.parseDouble(token));
        }
        //System.out.printf("%s : %s%n", token, getSymbol(token));
      }
      nextLine.close();
    }
    System.out.println();
    input.close();
    makeValidCommands(constantStack, commandStack);
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

  private void makeValidCommands(Queue constantStack, Queue commandStack)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, CommandException {
    while (!commandStack.isEmpty()) {
      double [] args;
        String command = (String) commandStack.poll();
        int numParams = Integer.parseInt(ResourceBundle.getBundle(RESOURCES_PACKAGE+PARAMS).getString(command));
        args = new double[numParams];
        try {
          for (int i = 0; i < numParams; i++) {
            args[i] = (double) constantStack.poll();
          }
          //System.out.println(args[0]);
          Class<?> clazz = Class.forName("slogo.Model.Commands." + command + "Command");
          Class<?>[] type = {double[].class};
          Constructor<?> cons = clazz.getConstructor(type);
          Object[] obj = {args};
          Object newInstance = cons.newInstance(obj);
          validCommands.add(newInstance);
        }
        catch(Exception e){
          throw new CommandException("Not enough constants for the given command: "+ command);
        }
    }
  }

  public static String readFile(String filePath) throws IOException {
    return Files.readString(Path.of(filePath));
  }

  public static void main(String[] args)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, CommandException {
    Translater t = new Translater();
    t.parseText(readFile("data/examples/simple/square.slogo"));
    System.out.println(t.validCommands);
  }

}
