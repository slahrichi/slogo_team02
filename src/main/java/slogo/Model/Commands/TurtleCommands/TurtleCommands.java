package slogo.Model.Commands.TurtleCommands;

import slogo.Model.Commands.Command;

public abstract class TurtleCommands extends Command {
  public TurtleCommands(double[] params){
    super(params);
  }
  public double getValue(){
    return getParams()[0];
  }
}
