package slogo.Model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import slogo.Control.ControllerExceptions.VariableExceptions;

/**
 *
 * the class that manages and holds all the variables, has method to set the value of a variable and make a new one.
 * Has function to get the value of a variable.
 * @author Haris Adnan
 */
public class VariableManager {
  private Map<String, Double> variableMap;
  private List<Variable> variableList;

  public VariableManager(){
    variableMap = new HashMap<>();
    variableList = new ArrayList<>();
  }

  /**
   * makes new variable if it doesnt exist or sets the value of a variable if it does.
   * @param name : variable name
   * @param value : value of variable to be set
   */
  public void setOrMakeVariable(String name, String value) {
    //check if variable exists
    if (!variableMap.containsKey(name)) {
      variableMap.put(name, Double.parseDouble(value));
      Variable thisVariable = new Variable(name, Double.parseDouble(value));
      variableList.add(thisVariable);
    }
    //update variable
    else{
      Variable thisVariable = null;
      for (Variable variable: variableList){
        if(variable.getName().equals(name)){
          thisVariable = variable;
        }
      }
      // update List
      variableList.remove(thisVariable);
      thisVariable.setValue(value);
      variableList.add(thisVariable);
      //update Map
      variableMap.put(name, Double.valueOf(value));
//      return Double.parseDouble(value);
    }

  }

  /**
   * gets value of variable with the name provided
   * @param variableName : name of variable
   * @return return the value of the variable
   */
  public double getVariableValue(String variableName){
    double variableVal = Double.parseDouble(String.valueOf(variableMap.get(variableName)));
    return variableVal;
  }

  /**
   * creates dummy variable with the value as 0.
   * @param variableNameUsedByUser
   * @return
   */
  public Variable makeVariableForNoValue(String variableNameUsedByUser){
    Variable variable = new Variable(variableNameUsedByUser, 0);
    return variable;
  }

}
