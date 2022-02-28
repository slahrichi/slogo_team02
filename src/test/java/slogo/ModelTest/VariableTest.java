package slogo.ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import slogo.Model.Variable;

class VariableTest {

  @Test
  void getName() {
    Variable testVariable = new Variable("test", 50.0);
    assertEquals("test", testVariable.getName());
  }

  @Test
  void setName() {
    Variable testVariable = new Variable("test", 50.0);
    testVariable.setName("newtest");
    assertEquals("newtest", testVariable.getName());
  }

  @Test
  void getValue() {
    Variable testVariable = new Variable("test", 50.0);
    assertEquals("60.0", testVariable.getValue());
  }

  @Test
  void setValue() {
    Variable testVariable = new Variable("test", 50.0);
    testVariable.setValue(String.valueOf(60.0));
    assertEquals("60.0", testVariable.getValue());

  }
}