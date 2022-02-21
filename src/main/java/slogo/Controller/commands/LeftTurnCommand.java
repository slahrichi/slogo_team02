package slogo.Controller.commands;


import slogo.Controller.Command;
import slogo.Controller.TurtleManager;

public class LeftTurnCommand extends Command {

  public LeftTurnCommand(double value, TurtleManager manager){
    super(value, manager);
  }

  @Override
  public double execute(){
    getManager().getCurrentTurtle().setAngle(getManager().getCurrentTurtle().getAngle() - getParam());
    return getParam();
  }
}

