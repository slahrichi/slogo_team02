package slogo.Control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import slogo.Model.Commands.CommandAPI;
import slogo.Model.ModelExceptions;
import slogo.Model.TurtleManager;
import slogo.Model.TurtleManagerAPI;
import slogo.View.ViewAPI;


public class Controller implements ControllerViewAPI {
  private Translater parser;
  private TurtleManagerAPI manager;
  private ViewAPI view;
  private List<String> history;
  public Controller(ViewAPI gui){
    parser = new Translater();
    parser = new Translater();
    manager = new TurtleManager();
    resetHistory();
    view = gui;
  }

  public void parseAndRunCommands(String contents)
      throws Exception {

    updateHistory(contents);
    parser.parseText(contents);

    List<CommandAPI> commands = parser.getCommands();

    runCommands(commands);

  }

  public List<String> getHistory(){
    return history;
  }
  public void resetHistory(){
    history = new ArrayList<>();
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
      view.notifyAnimation();
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
