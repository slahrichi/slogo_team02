package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;

public class ArcTangentCommand extends Command {
  public ArcTangentCommand(double[] params){
    super(params);
  }

  @Override
  public double getValue(){
    return Math.toDegrees(Math.atan(getParams()[0]));
  }
}