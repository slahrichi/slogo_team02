package slogo.Controller.commands;

import slogo.Controller.Command;
import slogo.Controller.TurtleManager;

public class BackwardCommand extends Command {
  public BackwardCommand(double value, TurtleManager manager){
    super(value, manager);
  }

  @Override
  public double execute(){
    double angle = getManager().getCurrentTurtle().getAngle();
    double newXpos = getManager().getCurrentTurtle().getTurtleX() - getParam() * Math.cos(Math.toRadians(angle));
    double newYpos = getManager().getCurrentTurtle().getTurtleY() - getParam() * Math.sin(Math.toRadians(angle));
    getManager().getCurrentTurtle().changeTurtleLocation(newXpos, newYpos);
    return getParam();
  }
}
