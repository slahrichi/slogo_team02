package slogo.Control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
import java.lang.reflect.*;
import slogo.Model.TurtleManager;

/**
 * this class parses the input received from the user through typing or from an uploaded file
 */
public class InputParser {
  public static final String WHITESPACE = "\\s+";
  public static final Character HASHTAG = '#';
  public static final String NO_MATCH = "NO MATCH";
  public static final String SYNTAX = "Syntax";
  private static final String RESOURCES_PACKAGE = "slogo.languages.";
  List<Entry<String, Pattern>> mySymbols;
  List<Entry<String, Pattern>> mySyntaxSymbols;
  private static Stack<Integer> constantStack = new Stack<>();
  private static Stack<String> commandStack = new Stack<>();
  public List<Object> validCommands = new ArrayList<>();



  public InputParser() {
    reset();
  }

  //this has to be private, made public to test
  public void parseText(String program)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Scanner input = new Scanner(program);
    while (input.hasNextLine()) {
      String line = input.nextLine();
      Scanner nextLine = new Scanner(line);
      if (!line.isEmpty() && line.charAt(0) == HASHTAG) {
        continue;
      }
      while (nextLine.hasNext()) {
        String token = nextLine.next();
        //later use reflection to do this too
        if (getSyntaxSymbol(token) == "UserCommand") {
          // add to command stack
          commandStack.push(getSymbol(token));
          //  int expectedParameters/reflection
        }
         else if (getSyntaxSymbol(token) == "Constant"){
          // add to constant stack
          constantStack.push(Integer.parseInt(token));
          }
          System.out.printf("%s : %s%n", token, getSymbol(token));
        }
        nextLine.close();
      }
      System.out.println();
      input.close();
      makeValidCommands(constantStack, commandStack);
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

    public List getCommands(){
      return validCommands;
    }

  public void addPatterns(String syntax){
    ResourceBundle resources = ResourceBundle.getBundle(RESOURCES_PACKAGE+syntax);
    for (String key: Collections.list(resources.getKeys())){
      mySymbols.add(new SimpleEntry<>(key,
          Pattern.compile(resources.getString(key), Pattern.CASE_INSENSITIVE)));
    }
  }

  public void addSyntaxPatterns(String syntax){
    ResourceBundle resources = ResourceBundle.getBundle(RESOURCES_PACKAGE+syntax);
    for (String key: Collections.list(resources.getKeys())){
      mySyntaxSymbols.add(new SimpleEntry<>(key,
          Pattern.compile(resources.getString(key), Pattern.CASE_INSENSITIVE)));
    }


  }
  public void setLanguage(String language){
    reset();
    addPatterns(language);
    addPatterns(SYNTAX);
  }

  public String getSymbol(String text){
    for (Entry<String, Pattern> e: mySymbols){
      if (match(text, e.getValue())){
        return e.getKey();
      }
    }
    return NO_MATCH;
  }

  public String getSyntaxSymbol(String text){
    for (Entry<String, Pattern> e: mySyntaxSymbols){
      if (match(text, e.getValue())){
        return e.getKey();
      }
    }
    return NO_MATCH;
  }
  public boolean match(String text, Pattern regex){
    return text != null && regex.matcher(text.trim()).matches();
  }

  public void reset(){
    mySymbols = new ArrayList<>();
    mySyntaxSymbols = new ArrayList<>();
  }

  public static String readFile(String filePath) throws IOException {
    return Files.readString(Path.of(filePath));
  }

  public static void main (String[] args)
      throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    // NO static methods needed!
    InputParser m = new InputParser();
    m.addSyntaxPatterns("Syntax");
    // set up the parser, which checks for matches in order given
    //ProgramParser parser = new ProgramParser();
    m.setLanguage("English");
    // try against an example program
    m.parseText("fd \n 50 \nrt 90 BACK :distance Left :angle");

  }
}
