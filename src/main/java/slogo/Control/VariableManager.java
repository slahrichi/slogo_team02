package slogo.Control;


import java.util.List;
import java.util.Map;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import slogo.Model.Variable;

public class VariableManager {
  private Map<String, Double> variableMap;
  private List<Variable> variableList ;

  public VariableManager(){

  }
  public void makeVariable(String name, String value){
    if (!variableMap.containsKey(name)){
      variableMap.put(name, Double.parseDouble(value));
      Variable newVar = new Variable(name, Double.parseDouble(value));
      variableList.add(newVar);
    }
    else{
      throw new ExceptionVariableAlreadyInUse("This variable name already exists. Use the Set expression instead.");
    }
  }
  public void setVariable(String name, String value){
    Variable thisVariable = null;
    if (variableMap.containsKey(name)){
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
    }
    
    else{
      throw new ExceptionVariableNonexistent("This variable does not exist");
    }
  }
  public double getVariableValue(String variableName){
    double variableVal = Double.parseDouble(String.valueOf(variableMap.get(variableName)));
    return variableVal;
  }

}

