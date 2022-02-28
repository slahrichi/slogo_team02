package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;

public class NaturalLogCommand extends Command {
  public NaturalLogCommand(double[] params){
    super(params);
  }

  @Override
  public double getValue(){
    return Math.log(getParams()[0]);
  }
}
