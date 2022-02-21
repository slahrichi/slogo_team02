package slogo.Controller;


public abstract class Command {
  private TurtleManager turtleManager;
  private double parameter;

  public Command(double value, TurtleManager manager){
    turtleManager = manager;
    parameter = value;
  }

  protected double getParam(){
    return parameter;
  }
  protected TurtleManager getManager(){
    return turtleManager;
  }

  public abstract double execute();

}
