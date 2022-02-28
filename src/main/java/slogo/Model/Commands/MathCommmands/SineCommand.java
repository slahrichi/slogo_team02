package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;

public class SineCommand extends Command {
  public SineCommand(double[] params){
    super(params);
  }

  @Override
  public double getValue(){
    return Math.sin(Math.toRadians(getParams()[0]));
  }
}
