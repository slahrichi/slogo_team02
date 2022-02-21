package slogo.Controller;

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
import java.util.regex.Pattern;
import java.lang.reflect.*;

/**
 * this class parses the input received from the user through typing or from an uploaded file
 */
public class InputParser {
  public static final String WHITESPACE = "\\s+";
  public static final Character HASHTAG = '#';
  public static final String NO_MATCH = "NO MATCH";
  public static final String SYNTAX = "Syntax";
  private static final String RESOURCES_PACKAGE = "slogo.languages.";
  private List<Entry<String, Pattern>> mySymbols;


  public InputParser() {
    reset();
  }

  private void parseText(String program) {
    Scanner input = new Scanner(program);
    while (input.hasNextLine()) {
      String line = input.nextLine();
      Scanner nextLine = new Scanner(line);
      if (!line.isEmpty() && line.charAt(0) == HASHTAG) {
        continue;
      }
      while (nextLine.hasNext()) {
        String token = nextLine.next();
        // use reflection to do this too
        //if (getSymbol(token) == "UserCommand"){
          // add to command stack
        //  int expectedParameters
          //reflection
//        }
//        else if (getSymbol(token) == "Constant"){
//          // add to constant stack
//        }
        System.out.printf("%s : %s%n", token, getSymbol(token));
      }
      nextLine.close();
    }
    System.out.println();
    input.close();
  }

  public void addPatterns(String syntax){
    ResourceBundle resources = ResourceBundle.getBundle(RESOURCES_PACKAGE+syntax);
    for (String key: Collections.list(resources.getKeys())){
      mySymbols.add(new SimpleEntry<>(key,
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

  public boolean match(String text, Pattern regex){
    return text != null && regex.matcher(text.trim()).matches();
  }

  public void reset(){
    mySymbols = new ArrayList<>();
  }

  public static String readFile(String filePath) throws IOException {
    return Files.readString(Path.of(filePath));
  }

  public static void main (String[] args) throws IOException {
    // NO static methods needed!
    InputParser m = new InputParser();
    // set up the parser, which checks for matches in order given
    //ProgramParser parser = new ProgramParser();
    m.setLanguage("English");
    m.parseText(readFile("data/examples/simple/square.slogo"));
    // try against an example program
    //m.parseText(parser, "fd \n 50 \nrt 90 BACK :distance Left :angle");

//    m.parseText("# draw a square\n"
//        + "fd 100\n"
//        + "rt 90\n"
//        + "fd 100\n"
//        + "rt 90\n"
//        + "fd 100\n"
//        + "rt 90\n"
//        + "fd 100\n"
//        + "rt 90");
//    m.setLanguage("French");
//    m.parseText("Devant 50 droite 90 DERRIERE :distance Gauche :angle");
  }
}
