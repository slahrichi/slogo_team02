package slogo.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Variable Test class that tests the public methods in the Variable class.
 * @author Haris Adnan
 */
class VariableTest {

  /**
   * tests the getter for the name of the Variable
   */
  @Test
  void getName() {
    Variable testVariable = new Variable("test", 50.0);
    assertEquals("test", testVariable.getName());
  }

  /**
   * tests the method that sets name of variable
   */
  @Test
  void setName() {
    Variable testVariable = new Variable("test", 50.0);
    testVariable.setName("newtest");
    assertEquals("newtest", testVariable.getName());
  }

  /**
   * tests getter for the Value of the variable
   */
  @Test
  void getValue() {
    Variable testVariable = new Variable("test", 50.0);
    assertEquals("60.0", testVariable.getValue());
  }

  /**
   * test that checks of the setting of the value of the variable works correctly.
   */
  @Test
  void setValue() {
    Variable testVariable = new Variable("test", 50.0);
    testVariable.setValue(String.valueOf(60.0));
    assertEquals("60.0", testVariable.getValue());
  }

}