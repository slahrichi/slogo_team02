package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;

public class PowerCommand extends Command {
  public PowerCommand(double[] params){
    super(params);
  }

  @Override
  public double getValue(){
    return Math.pow(getParams()[0], getParams()[1]);
  }
}