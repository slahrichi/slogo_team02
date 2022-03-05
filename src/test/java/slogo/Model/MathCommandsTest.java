package slogo.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.MathCommands.ArcTangentCommand;
import slogo.Model.Commands.MathCommands.CosineCommand;

public class MathCommandsTest {
  TurtleManager turtleManager = new TurtleManager();
  private TurtleManager manager;
  private double[] input;
  private void setupTest(double[] params){
    manager = new TurtleManager();
    input = params;
  }


  @Test
  void ArcTangentCommandTest(){
    setupTest(new double[] {100});
    ArcTangentCommand arcTanCommand = new ArcTangentCommand(input);
    assertEquals(arcTanCommand.getValue(), Math.toDegrees(Math.atan(input[0])));
  }
  @Test
  void CosineCommand(){
    setupTest(new double[] {2});
    CosineCommand cosineCommand = new CosineCommand(input);
    assertEquals(cosineCommand.getValue(), Math.cos(Math.toRadians(input[0])));
  }



}
