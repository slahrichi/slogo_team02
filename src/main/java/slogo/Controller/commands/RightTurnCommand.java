package slogo.Controller.commands;

import slogo.Controller.Command;
import slogo.Controller.TurtleManager;

public class RightTurnCommand extends Command {

  public RightTurnCommand(double value, TurtleManager manager){
    super(value, manager);
  }

  public double execute(){
    getManager().getCurrentTurtle().setAngle(getManager().getCurrentTurtle().getAngle() + getParam());
    return getParam();
  }
}
