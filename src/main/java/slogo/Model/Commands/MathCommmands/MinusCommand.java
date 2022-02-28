package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class MinusCommand extends Command {
  public MinusCommand(double[] parameters){
    super(parameters);
  }

  @Override
  public double getValue(){
    return -1 * getParams()[0];
  }

  @Override
  public String toString(){
    return ("Minus " + getValue());
  }
}
