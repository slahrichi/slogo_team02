package slogo.Control;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import slogo.Model.ModelExceptions;
import slogo.Model.Commands.BackwardCommand;
import slogo.Model.Commands.Command;
import slogo.Model.Commands.ForwardCommand;
import slogo.View.AnimationHandler;
import slogo.View.Objects.TurtleView;

public class Controller {
  private InputParser parser;
  private TurtleManager manager;
  private AnimationHandler animationControl;
  private TurtleView turtleView;
  public Controller(){
    parser = new InputParser();
    manager = new TurtleManager();
    animationControl = new AnimationHandler();
    animationControl.setupAnimation(e -> {
      try {
        updateStep();
      } catch (ModelExceptions ex) {
        ex.printStackTrace();
      }
    });
  }

  public AnimationHandler getAnimation(){
    return animationControl;
  }

  public void parseAndSetCommands(String contents)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    parser.reset();
    parser.parseText(contents);
//    List<Command> tempCommandList = new ArrayList<>();
//    double[] fifty = {50};
//    double[] hundo = {100};
//    tempCommandList.add(new ForwardCommand(fifty));
//    tempCommandList.add(new BackwardCommand(fifty));
//    tempCommandList.add(new ForwardCommand(fifty));
//    tempCommandList.add(new ForwardCommand(fifty));
//    tempCommandList.add(new BackwardCommand(hundo));
    manager.setCommands(parser.getCommands());
  }

  //Need to add ability to pull text and only call step when running a set of commands
  //manager.addCommands(parser.getCommands())
  private void updateStep() throws ModelExceptions {
    manager.step();
   //turtleView.updatePosition(manager.getCurrentTurtle());

  }
}
