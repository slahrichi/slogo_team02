package slogo.Model.Commands.MathCommands;

import slogo.Model.Commands.Command;

public class ProductCommand extends Command {
  public ProductCommand(double[] params){
    super(params);
  }

  @Override
  public double getValue(){
    return getParams()[0] * getParams()[1];
  }

  @Override
  public String toString(){
    return ("Product " + getValue());
  }
}

