package slogo.Controller.commands;

import slogo.Controller.Command;
import slogo.Controller.TurtleManager;

public class RightTurnCommand extends Command {

  public RightTurnCommand(double[] values, TurtleManager manager){
    super(values, manager);
  }

  public double execute(){
    getManager().getCurrentTurtle().setAngle(getManager().getCurrentTurtle().getAngle() + getParams()[0]);
    return getParams()[0];
  }
}
