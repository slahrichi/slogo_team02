package slogo.Model.commands;

import slogo.Model.Command;
import slogo.Controller.TurtleManager;

public class ForwardCommand extends Command {
  public ForwardCommand(double[] values, TurtleManager manager){
    super(values, manager);
  }

  @Override
  public double execute(){
    double angle = getManager().getCurrentTurtle().getAngle();
    double newXpos = getManager().getCurrentTurtle().getTurtleX() + getParams()[0] * Math.cos(Math.toRadians(angle));
    double newYpos = getManager().getCurrentTurtle().getTurtleY() + getParams()[0] * Math.sin(Math.toRadians(angle));
    getManager().getCurrentTurtle().changeTurtleLocation(newXpos, newYpos);
    return getParams()[0];
  }
}
