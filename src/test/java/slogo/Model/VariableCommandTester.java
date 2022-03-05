package slogo.Model;

import org.junit.jupiter.api.Test;
import slogo.Model.Commands.VariableCommands.MakeVariableCommand;

import static org.junit.jupiter.api.Assertions.*;

public class VariableCommandTester {
  VariableManager variableManager = new VariableManager();
  MakeVariableCommand variableCommand = new MakeVariableCommand("testVar", new double[]{50.0}, variableManager);


  @Test
  void getValueTest(){
    assertEquals(50.0, variableCommand.getValue());
  }

  @Test
  void executeTest(){

  }

}
