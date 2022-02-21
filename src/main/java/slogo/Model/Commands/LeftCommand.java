package slogo.Model.Commands;


import slogo.Model.Command;
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
