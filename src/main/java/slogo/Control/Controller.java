package slogo.Control;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javafx.stage.Stage;
import slogo.Model.Commands.Command;
import slogo.Model.ModelExceptions;
import slogo.View.AnimationHandler;
import slogo.View.Panels.Canvas.CanvasView;
import slogo.View.Panels.Canvas.TurtleView;
import slogo.View.Panels.CanvasPanel;
import slogo.View.ViewAPI;
import slogo.View.slogoGUI;

public class Controller implements ControllerAPI{
  private Translater parser;
  private TurtleManager manager;
  private AnimationHandler animation;
  private ViewAPI view;
  public Controller(ViewAPI gui){
    parser = new Translater();
    parser = new Translater();
    manager = new TurtleManager();
    //animation = new AnimationHandler();
    view = gui;
  }

  public void parseAndRunCommands(String contents)
      throws ModelExceptions, CommandException {
    parser.parseText(contents);

    List<Command> commands = parser.getCommands();


    for (Command command : commands){
      manager.stepTurtle(command);
      view.createAnimation(manager.getRecordTurtle());
    }
  }

  public TurtleManager getTurtleManager(){
    return manager;
  }

//  private void updateStep(Command command) throws ModelExceptions {
//    manager.stepTurtle(command);
//    turtleView.updatePosition(manager.getRecordTurtle());
//
//  }

}
