package slogo.Controller;


import slogo.Model.Turtle;

public abstract class Command {
  public Command(String command, int value) {
    nothingForNow(command, value);
  }

  abstract void createCommand(String command, int value, Turtle turtle);

  abstract void createCommand(String command, int value, Pen pen);

  protected void nothingForNow(String command, int value){
  }
}
