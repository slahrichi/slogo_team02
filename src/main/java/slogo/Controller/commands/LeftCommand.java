package slogo.Controller.commands;


import slogo.Controller.Command;
import slogo.Controller.TurtleManager;

public class LeftCommand extends Command {

  public LeftCommand(double[] value, TurtleManager manager){
    super(value, manager);
  }

  @Override
  public double execute(){
    getManager().getCurrentTurtle().setAngle(getManager().getCurrentTurtle().getAngle() - getParams()[0]);
    return getParams()[0];
  }
}

