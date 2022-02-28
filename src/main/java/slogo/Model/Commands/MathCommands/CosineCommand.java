package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;

public class CosineCommand extends Command {
  public CosineCommand(double[] params){
    super(params);
  }

  @Override
  public double getValue(){
    return Math.cos(Math.toRadians(getParams()[0]));
  }
}
