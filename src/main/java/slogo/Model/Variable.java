package slogo.Model;
import java.util.List;
import java.util.Map;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import slogo.Control.ControllerExceptions.VariableExceptions;

public class Variable {
  private SimpleStringProperty name;
  private SimpleDoubleProperty value;

  /**
   * Class that defines a variable
   * @param name : name of a variable
   * @param value : value to be assigned to a variable
   */
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


}
