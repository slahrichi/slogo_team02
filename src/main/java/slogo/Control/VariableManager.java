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
  public void setVariable(Variable variable, String value){
    if(variableList.contains(variable)){
      variableList.remove(variable);
      variable.setValue(value);
      variableList.add(variable);
    }
    else{
      throw new ExceptionVariableNonexistent("This variable does not exist");
    }
  }

}

