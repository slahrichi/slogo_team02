package slogo.Control;

import slogo.Model.ModelExceptions;
import slogo.View.AnimationHandler;

public class Controller {
  private InputParser parser;
  private TurtleManager manager;
  private AnimationHandler animationControl;
  public Controller(){
    parser = new InputParser();
    manager = new TurtleManager();
    animationControl = new AnimationHandler();
  }

  //Need to add ability to pull text and only call step when running a set of commands
  private void updateStep() throws ModelExceptions {
    manager.step();
  }
}
