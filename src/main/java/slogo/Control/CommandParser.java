package slogo.Control;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class CommandParser {
  private static final String RESOURCES_PACKAGE = "slogo.languages.";
  public static final String NO_MATCH = "NO MATCH";
  List<Entry<String, Pattern>> mySymbols;



  public CommandParser() {
    reset();
  }

  public void addPatterns(String syntax){
    ResourceBundle resources = ResourceBundle.getBundle(RESOURCES_PACKAGE+syntax);
    for (String key: Collections.list(resources.getKeys())){
      mySymbols.add(new SimpleEntry<>(key,
          Pattern.compile(resources.getString(key), Pattern.CASE_INSENSITIVE)));
    }
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
}
