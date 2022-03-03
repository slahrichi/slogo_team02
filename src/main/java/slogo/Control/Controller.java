package slogo.Control;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import slogo.Model.Commands.CommandAPI;
import slogo.Model.ModelExceptions;
import slogo.View.AnimationHandler;
import slogo.View.ViewAPI;


public class Controller implements ControllerAPI{
  private Translater parser;
  private TurtleManagerAPI manager;
  private AnimationHandler animation;
  private ViewAPI view;
  private List<String> history;
  public Controller(ViewAPI gui){
    parser = new Translater();
    parser = new Translater();
    manager = new TurtleManager();
    //animation = new AnimationHandler();
    view = gui;
  }

  public void parseAndRunCommands(String contents)
      throws ModelExceptions, CommandException {

    updateHistory(contents);
    parser.parseText(contents);

    List<CommandAPI> commands = parser.getCommands();

    runCommands(commands);

  }

  public List<String> getHistory(){
    return history;
  }


  private void updateHistory(String contents){
    history.addAll(Arrays.asList(contents.split("\n")));
    view.notifyHistory();
  }

  public TurtleRecord getRecordTurtle(){
    return manager.getRecordTurtle();
  }

  private void runCommands(List<CommandAPI> commands) throws ModelExceptions {
    for (CommandAPI command : commands){
      manager.stepTurtle(command);
     // view.notifyTurtle();
//      view.createAnimation(manager.getRecordTurtle());

    }
  }


//  public TurtleManager getTurtleManager(){
//    return manager;
//  }

//  private void updateStep(Command command) throws ModelExceptions {
//    manager.stepTurtle(command);
//    turtleView.updatePosition(manager.getRecordTurtle());
//
//  }

}
