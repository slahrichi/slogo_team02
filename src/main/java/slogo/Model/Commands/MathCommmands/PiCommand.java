package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;

public class PiCommand extends Command {
  public PiCommand(double[] params){
    super(params);
  }

  @Override
  public double getValue(){
    return Math.PI;
  }
}