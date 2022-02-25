package slogo.Controller;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
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
  private static Stack<Double> constantStack = new Stack<>();
  private static Stack<String> commandStack = new Stack<>();

  public Translater(){
    syntaxParser = new CommandParser();
    commandParser = new CommandParser();
    paramParser = new ParamParser();
    syntaxParser.addPatterns("Syntax");
    commandParser.addPatterns("Command");
    paramParser.addPatterns("Params");
  }


  //this has to be private, made public to test
  private void parseText(String program)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Scanner input = new Scanner(program);
    Stack<Double > constantStack = new Stack<>();
    Stack<String> commandStack = new Stack<>();
    while (input.hasNextLine()) {
      String line = input.nextLine();
      Scanner nextLine = new Scanner(line);
      if (!line.isEmpty() && line.charAt(0) == HASHTAG) {
        continue;
      }
      while (nextLine.hasNext()) {
        String token = nextLine.next();
        //later use reflection to do this too
        if (syntaxParser.getSymbol(token) == "UserCommand") {
          // add to command stack
          commandStack.push(commandParser.getSymbol(token));
          //  int expectedParameters/reflection
        }
        else if (syntaxParser.getSymbol(token) == "Constant"){
          // add to constant stack
          constantStack.push(Double.parseDouble(token));
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

  private void makeValidCommands(Stack constantStack, Stack commandStack)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    while (!commandStack.isEmpty()){
      String command = (String) commandStack.peek();
      ResourceBundle paramsResources = ResourceBundle.getBundle("src/main/resources/Commands/Params.properties");
      int numParams = Integer.parseInt(paramsResources.getString(command));
      double[] args = new double[numParams];
      for (int i=0; i<numParams; i++){
        args[i]=(Double.parseDouble((String) constantStack.peek()));
      }
      Class<?> clazz = Class.forName("slogo.Model.commands."+command+"Command");
      Class<?>[] type = {Array.class, TurtleManager.class};
      Constructor<?> cons = clazz.getConstructor(type);
      Object[] obj = {args};
      Object newInstance = cons.newInstance(obj);
      validCommands.add(newInstance);
    }

  }

}
