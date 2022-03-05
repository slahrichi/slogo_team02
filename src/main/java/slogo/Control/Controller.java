package slogo.Control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import slogo.Model.Commands.CommandAPI;
import slogo.Model.ModelExceptions;
import slogo.Model.TurtleManager;
import slogo.Model.TurtleManagerAPI;
import slogo.Model.TurtleManagerException;
import slogo.Model.TurtleRecord;
import slogo.View.ObserverViewAPI;


public class Controller implements ControllerViewAPI {
  private Translater parser;
  private TurtleManagerAPI manager;
  private ObserverViewAPI view;
  private List<String> history;
  private int currentTurtleID;
  public Controller(ObserverViewAPI gui) {
    parser = new Translater();
    parser = new Translater();
    manager = new TurtleManager();
    resetHistory();
    view = gui;
    currentTurtleID = 0;
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

  public void changeActiveTurtle(int turtleId) throws TurtleManagerException {
    currentTurtleID = turtleId;
    manager.changeActiveTurtle(turtleId);
  }
  public TurtleRecord getRecordTurtle() throws TurtleManagerException {
    return manager.getRecordTurtle(currentTurtleID);
  }

  private void runCommands(List<CommandAPI> commands) throws ModelExceptions, TurtleManagerException {
    for (CommandAPI command : commands){
      manager.stepTurtle(command);
      view.notifyAnimation();
    }
    view.animationComplete();
  }


}
