package slogo.Model.Commands;


import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;

public abstract class Command {
  private double[] parameters;

  public Command(double[] values){
    parameters = values;
  }

  protected double[] getParams(){
    return parameters;
  }

  public double execute(Turtle turtle) throws ModelExceptions{
    return getValue();
  }

  public double getValue(){
    return parameters[0];
  }
}
