package slogo.ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import slogo.Model.VariableManager;

class VariableManagerTest {

  VariableManager testVariableManager = new VariableManager();

  @Test
  void setOrMakeVariable() {
    testVariableManager.setOrMakeVariable("testvar", "50.0");
    assertEquals(testVariableManager.getVariableValue("testvar"), 50.0);
  }
}