package slogo.Model;


import slogo.Controller.TurtleManager;

public abstract class Command {
  private TurtleManager turtleManager;
  private double[] parameters;

  public Command(double[] values, TurtleManager manager){
    turtleManager = manager;
    parameters = values;
  }

  protected double[] getParams(){
    return parameters;
  }
  protected TurtleManager getManager(){
    return turtleManager;
  }

  public abstract double execute() throws ModelExceptions;

}
