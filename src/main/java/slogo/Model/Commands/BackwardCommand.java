package slogo.Model.commands;

import slogo.Model.Command;
import slogo.Controller.TurtleManager;
import slogo.Model.ModelExceptions;

public class BackwardCommand extends Command {
  public BackwardCommand(double[] values, TurtleManager manager){
    super(values, manager);
  }

  @Override
  public double execute() throws ModelExceptions {
    double angle = getManager().getCurrentTurtle().getAngle();
    double newXpos = getManager().getCurrentTurtle().getTurtleX() - getParams()[0] * Math.cos(Math.toRadians(angle));
    double newYpos = getManager().getCurrentTurtle().getTurtleY() - getParams()[0] * Math.sin(Math.toRadians(angle));
    getManager().getCurrentTurtle().changeTurtleLocation(newXpos, newYpos);
    return getParams()[0];
  }
}
