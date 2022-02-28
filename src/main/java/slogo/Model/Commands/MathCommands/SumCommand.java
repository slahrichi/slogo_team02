package slogo.Model.Commands.MathCommands;

import slogo.Model.Commands.Command;

public class SumCommand extends Command {
  public SumCommand(double[] params){
    super(params);
  }

  @Override
  public double getValue(){
    return getParams()[0] + getParams()[1];
  }

  @Override
  public String toString(){
    return ("Sum " + getValue());
  }
}
