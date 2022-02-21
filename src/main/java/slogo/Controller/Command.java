package slogo.Controller;


import slogo.Model.Pen;
import slogo.Model.Turtle;

public abstract class Command {
  public Command(String command, int value) {
    createCommand(command, value);
  }

  abstract void createCommand(String command, int value, Turtle turtle);

 // abstract void createCommand(String command, int value, Pen pen);

  abstract void createCommand(String command, int value);
}
