package slogo.Control;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ParamParser {
  private static final String RESOURCES_PACKAGE = "slogo.languages.";
  public static final String SYNTAX = "Syntax";
  Map<String, Double> myParams;

  public ParamParser() {
    reset();
  }

  public void addPatterns(String syntax){
    ResourceBundle resources = ResourceBundle.getBundle(RESOURCES_PACKAGE+syntax);
    for (String key: Collections.list(resources.getKeys())){
      myParams.put(key, Double.parseDouble(resources.getString(key)));
    }
  }

  public Double getNumParams(String key){
    return myParams.get(key);
  }


  public void reset(){
    myParams = new HashMap<String, Double>();
  }
}
