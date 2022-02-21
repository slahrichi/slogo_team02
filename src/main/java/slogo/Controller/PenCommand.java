package slogo.Controller;

import slogo.Model.Pen;
import slogo.Model.Turtle;

public class PenCommand extends Command{
  private Pen commandPen;
  public PenCommand(String command, int value) {
    super(command, value);
  }

  @Override
  public void createCommand(String command, int value, Pen pen) {
    commandPen = pen;

  }

  private void penUp(){
    commandPen.setPenUpOrDown(true);
  }
  private void penDown(){
    commandPen.setPenUpOrDown(false);
  }
}
