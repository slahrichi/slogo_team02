package slogo.Model.Commands.MathCommands;

import slogo.Model.Commands.Command;

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

