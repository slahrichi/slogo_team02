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
   * Class that defines a variable that can be defined by the user
   * @param name : name of a variable
   * @param value : value to be assigned to a variable
   * @author Haris Adnan
   */
  public Variable(String name, double value) {
    this.name = new SimpleStringProperty(name);
    this.value = new SimpleDoubleProperty(value);
  }

  /**
   * gets name of the variable
   * @return String output, name of the variable
   */
  public String getName() {
    return name.get();
  }

  /**
   * sets name of the variable
   * @param name: String to be used as the name of the variable
   */
  public void setName(String name) {
    this.name.set(name);
  }

  /**
   * Gets the value of the variable
   * @return: value of the variable as a double
   */
  public String getValue() {
    return Double.toString(value.get());
  }

  /**
   * sets value of the variable
   * @param : value to be set as a string
   */
  public void setValue(String string) {
    this.value.set(Double.parseDouble(string));
  }


}
