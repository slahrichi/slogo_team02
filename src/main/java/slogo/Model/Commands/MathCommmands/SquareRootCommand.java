package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;

public class SquareRootCommand extends Command {
  public SquareRootCommand(double[] params){
    super(params);
  }

  @Override
  public double getValue(){
    return Math.sqrt(getParams()[0]);
  }
}