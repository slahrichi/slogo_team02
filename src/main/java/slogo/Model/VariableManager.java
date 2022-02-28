package slogo.Model;


import java.util.List;
import java.util.Map;
import slogo.Control.ControllerExceptions.VariableExceptions;

public class VariableManager {
  private Map<String, Double> variableMap;
  private List<Variable> variableList;

  public VariableManager(){
  }
//  public void makeVariable(String name, String value) throws VariableExceptions {
//    if (!variableMap.containsKey(name)){
//      variableMap.put(name, Double.parseDouble(value));
//      Variable newVar = new Variable(name, Double.parseDouble(value));
//      variableList.add(newVar);
//    }
//    else{
//      throw new VariableExceptions("This variable name already exists. Use the Set expression instead.");
//    }
//  }
  public void setOrMakeVariable(String name, String value) {
    //check if variable exists
    if (!variableMap.containsKey(name)) {
      variableMap.put(name, Double.parseDouble(value));
      Variable thisVariable = new Variable(name, Double.parseDouble(value));
      variableList.add(thisVariable);
//      return Double.parseDouble(value);
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
  public double getVariableValue(String variableName){
    double variableVal = Double.parseDouble(String.valueOf(variableMap.get(variableName)));
    return variableVal;
  }
  public Variable makeVariableForNoValue(String variableNameUsedByUser){
    Variable variable = new Variable(variableNameUsedByUser, 0);
    return variable;
  }

}
