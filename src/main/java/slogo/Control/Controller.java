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
import slogo.View.APIs.ObserverViewInterface;

/**
 * @author Mike Keohane
 * <p>
 * Controller class which is initialized and called by the view. It updates the model and then
 * nortifies the view that it needs to updated
 */
public class Controller implements ControllerAPI {

  private Translater parser;
  private TurtleManagerAPI manager;
  private ObserverViewInterface view;
  private List<String> history;
  private int currentTurtleID;

  /**
   * Initializes the controller by passing in an object of the GUI and saving it as
   * ObserverViewInterface
   *
   * @param gui the instance of slogoGUI
   */
  public Controller(ObserverViewInterface gui) {
    parser = new Translater();
    manager = new TurtleManager();
    resetHistory();
    view = gui;
    currentTurtleID = 0;
  }

  /**
   * Given a string input calls the parser and runs the commands it creates.
   *
   * @param contents String of contents to parse and run
   * @throws Exception
   */
  public void parseAndRunCommands(String contents)
      throws Exception {
    updateHistory(contents);
    parser.resetCommands();
    parser.parseText(contents);
    List<CommandAPI> commands = parser.getCommands();

    runCommands(commands);

  }

  /**
   * Gets the command history in strings sperated by line
   *
   * @return List<String> history
   */
  public List<String> getHistory() {
    return history;
  }

  /**
   * Resets the history to a blank arrayList
   */
  public void resetHistory() {
    history = new ArrayList<>();
  }


  private void updateHistory(String contents) {
    history.addAll(Arrays.asList(contents.split("\n")));
    view.notifyHistory();
  }

  /**
   * Changes the active turtle. Not used because we didn't finish implementing multiple turtles.
   *
   * @param turtleId id of the turtle to set as active
   * @throws TurtleManagerException
   */
  public void changeActiveTurtle(int turtleId) throws TurtleManagerException {
    currentTurtleID = turtleId;
    manager.changeActiveTurtle(turtleId);
  }

  /**
   * Returns the record of the active turtle
   *
   * @return TurtleRecord of the active turtle
   * @throws TurtleManagerException
   */
  public TurtleRecord getRecordTurtle() throws TurtleManagerException {
    return manager.getRecordTurtle(currentTurtleID);
  }

  private void runCommands(List<CommandAPI> commands)
      throws ModelExceptions {
    for (CommandAPI command : commands) {
      manager.stepTurtle(command);
      view.notifyAnimation();
    }
    view.animationComplete();
  }


}
