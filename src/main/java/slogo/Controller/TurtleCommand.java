package slogo.Controller;

import slogo.Model.Turtle;
import slogo.Model.Pen;

public class TurtleCommand extends Command {

  private Turtle commandTurtle;
  public TurtleCommand(String command, int value) {
    super(command, value);
  }

  @Override
  public void createCommand(String command, int value, Turtle turtle) {
      commandTurtle = turtle;

  }

  private void moveCommand(String command, int value){

  }

  private void moveForward(int value){
    double angle = commandTurtle.getAngle();
    double newXpos = commandTurtle.getTurtleX() + value * Math.cos(angle);
    double newYpos = commandTurtle.getTurtleY() + value * Math.sin(angle);
    commandTurtle.changeTurtleLocation(newXpos, newYpos);
  }

  private void moveBackwards(int value){
    double angle = commandTurtle.getAngle();
    double newXpos = commandTurtle.getTurtleX() - value * Math.cos(angle);
    double newYpos = commandTurtle.getTurtleY() - value * Math.sin(angle);
    commandTurtle.changeTurtleLocation(newXpos, newYpos);
  }

  private void rotateRight(int value){
    commandTurtle.setAngle((int) commandTurtle.getAngle() + value);
  }

  private void rotateLeft(int value){
    commandTurtle.setAngle((int) commandTurtle.getAngle() + value);
  }

}
