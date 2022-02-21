package slogo.Controller;

import slogo.Model.Turtle;

public class TurtleCommands extends Command {

  private Turtle commandTurtle;
  private TurtleHelper turtleHelper;
  private OverarchingController controller = new OverarchingController();
  public TurtleCommands() {
    turtleHelper = controller.getTurtleHelper();
    commandTurtle = turtleHelper.getCurrentTurtle();
  }

//  @Override
//  public void createCommand(String command, int value) {
//    return;
//  }

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
