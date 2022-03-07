package slogo.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.MathCommands.ArcTangentCommand;
import slogo.Model.Commands.MathCommands.CosineCommand;
import slogo.Model.Commands.MathCommands.DifferenceCommand;
import slogo.Model.Commands.MathCommands.MinusCommand;
import slogo.Model.Commands.MathCommands.NaturalLogCommand;
import slogo.Model.Commands.MathCommands.PiCommand;
import slogo.Model.Commands.MathCommands.PowerCommand;
import slogo.Model.Commands.MathCommands.ProductCommand;
import slogo.Model.Commands.MathCommands.QuotientCommand;
import slogo.Model.Commands.MathCommands.RemainderCommand;
import slogo.Model.Commands.MathCommands.SineCommand;
import slogo.Model.Commands.MathCommands.SquareRootCommand;
import slogo.Model.Commands.MathCommands.SumCommand;
import slogo.Model.Commands.MathCommands.TangentCommand;

/**
 * Class that tests each of the Math Commands
 * @author Haris Adnan
 */
public class MathCommandsTest {
  TurtleManager turtleManager = new TurtleManager();
  private TurtleManager manager;
  private double[] input;
  private void setupTest(double[] params){
    manager = new TurtleManager();
    input = params;
  }

  /**
   * tests ArcTangent Command
   */
  @Test
  void ArcTangentCommandTest(){
    setupTest(new double[] {100});
    ArcTangentCommand arcTanCommand = new ArcTangentCommand(input);
    assertEquals(arcTanCommand.getValue(), Math.toDegrees(Math.atan(input[0])));
  }
  /**
   * tests Cosine Command
   */
  @Test
  void CosineCommand(){
    setupTest(new double[] {2});
    CosineCommand cosineCommand = new CosineCommand(input);
    assertEquals(cosineCommand.getValue(), Math.cos(Math.toRadians(input[0])));
  }
  /**
   * tests Difference Command
   */
  @Test
  void DifferenceCommand(){
    setupTest(new double[] {5, 3});
    DifferenceCommand differenceCommand = new DifferenceCommand(input);
    assertEquals(differenceCommand.getValue(), 2);
  }

  /**
   * tests Minus Command
   */
  @Test
  void MinusCommand(){
    setupTest(new double[] {5});
    MinusCommand minusCommand = new MinusCommand(input);
    assertEquals(-1 * 5, minusCommand.getValue());

  }
  /**
   * tests Natural Log Command
   */
  @Test
  void NaturalLogCommand(){
    setupTest(new double[] {4});
    NaturalLogCommand naturalCommand = new NaturalLogCommand(input);
    assertEquals(naturalCommand.getValue(), Math.log(4));
  }
  /**
   * tests Pi Command
   */
  @Test
  void PiCommandTest(){
    setupTest(new double[] {2});
    PiCommand picommand = new PiCommand(input);
    assertEquals(Math.PI, picommand.getValue());
  }
  /**
   * tests Power Command
   */
  @Test
  void PowerCommandTest(){
    setupTest(new double[] {5, 3});
    PowerCommand powerCommand = new PowerCommand(input);
    assertEquals(powerCommand.getValue(), Math.pow(5, 3));
  }
  /**
   * tests Product Command
   */
  @Test
  void ProductCommand(){
    setupTest(new double[]{4, 6});
    ProductCommand productCommand = new ProductCommand(input);
    assertEquals(productCommand.getValue(), 24);
  }
  /**
   * tests Quotient Command
   */
  @Test
  void QuotientCommand(){
    setupTest(new double[]{10, 5});
    QuotientCommand quotientCommand = new QuotientCommand(input);
    assertEquals(2, quotientCommand.getValue());
  }
  /**
   * tests Remainder Command
   */
  @Test
  void RemainderCommand(){
    setupTest(new double[]{10 , 8});
    RemainderCommand remainderCommand = new RemainderCommand(input);
    assertEquals(2, remainderCommand.getValue());
  }
  /**
   * tests Sine Command
   */
  @Test
  void SineCommands(){
    setupTest(new double[]{30.0});
    SineCommand sineCommand = new SineCommand(input);
    assertEquals(Math.sin(Math.toRadians(30.0)), sineCommand.getValue());

  }
  /**
   * tests Square root Command
   */
  @Test
  void SquareRootCommand(){
    setupTest(new double[]{4});
    SquareRootCommand squareRootCommand = new SquareRootCommand(input);
    assertEquals(2, squareRootCommand.getValue());
  }
  /**
   * tests Sum Command
   */
  @Test
  void SumCommand(){
    setupTest(new double[]{4, 5});
    SumCommand sumCommand = new SumCommand(input);
    assertEquals(9, sumCommand.getValue());
  }
  /**
   * tests Tangent Command
   */
  @Test
  void TangentCommand(){
    setupTest(new double[]{32.0});
    TangentCommand tangentCommand = new TangentCommand(input);
    assertEquals(Math.tan(Math.toRadians(32.0)), tangentCommand.getValue());

  }











}
