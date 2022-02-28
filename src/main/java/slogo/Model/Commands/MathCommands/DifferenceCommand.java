package slogo.Model.Commands.MathCommands;

import slogo.Model.Commands.Command;

public class DifferenceCommand extends Command {
  public DifferenceCommand(double[] params){
    super(params);
  }


  @Override
  public double getValue(){
    return getParams()[0] - getParams()[1];
  }

  @Override
  public String toString(){
    return ("Difference " + getValue());
  }
}
