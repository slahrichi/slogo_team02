package slogo.Control;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.View.AnimationHandler;

public class Controller {
  private InputParser parser;
  private TurtleManager manager;
  private AnimationHandler animation;
  public Controller(){
    parser = new InputParser();
    manager = new TurtleManager();
  }


  public void parseAndRunCommands(String contents)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ModelExceptions {
    parser.reset();
    parser.parseText(contents);

    List<Command> commands = parser.getCommands();

    for (Command command : commands){
      manager.stepTurtle(command);
      animation.createAnimation(manager.getRecordTurtle());
    }
  }

//  private void updateStep(Command command) throws ModelExceptions {
//    manager.stepTurtle(command);
//    turtleView.updatePosition(manager.getRecordTurtle());
//
//  }

}
