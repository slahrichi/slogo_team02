package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;

public class TangentCommand extends Command {
  public TangentCommand(double[] params){
    super(params);
  }

  @Override
  public double getValue(){
    return Math.tan(Math.toRadians(getParams()[0]));
  }
}
