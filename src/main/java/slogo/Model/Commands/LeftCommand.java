package slogo.Model.commands;


import slogo.Model.Command;
import slogo.Control.TurtleManager;

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

