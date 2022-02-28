package slogo.Model.Commands.MathCommmands;

import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public class RemainderCommand extends Command {
  public RemainderCommand(double[] params){
    super(params);
  }


  @Override
  public double getValue(){
    return getParams()[0] % getParams()[1];
  }

  @Override
  public String toString(){
    return ("Remainder " + getValue());
  }
}

