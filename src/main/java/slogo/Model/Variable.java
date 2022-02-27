package slogo.Model;
import java.util.List;
import java.util.Map;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import slogo.Control.ControllerExceptions.VariableExceptions;

public class Variable {
  private SimpleStringProperty name;
  private SimpleDoubleProperty value;

  public Variable(String name, double value) {
    this.name = new SimpleStringProperty(name);
    this.value = new SimpleDoubleProperty(value);
  }
  public String getName() {
    return name.get();
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public String getValue() {
    return Double.toString(value.get());
  }

  public void setValue(String string) {
    this.value.set(Double.parseDouble(string));
  }

  public static class VariableManager {
    private Map<String, Double> variableMap;
    private List<Variable> variableList ;

    public VariableManager(){

    }
    public void makeVariable(String name, String value) throws VariableExceptions {
      if (!variableMap.containsKey(name)){
        variableMap.put(name, Double.parseDouble(value));
        Variable newVar = new Variable(name, Double.parseDouble(value));
        variableList.add(newVar);
      }
      else{
        throw new VariableExceptions("This variable name already exists. Use the Set expression instead.");
      }
    }
    public void setVariable(String name, String value) throws VariableExceptions {
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
        throw new VariableExceptions("This variable does not exist");
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
}
