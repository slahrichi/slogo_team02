package slogo.Control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import slogo.Model.Commands.CommandAPI;
import slogo.Model.ModelExceptions;
import slogo.Model.Turtle;
import slogo.View.ViewAPI;


public class Controller implements ControllerViewAPI {
  private Translater myParser;
  private TurtleManagerAPI myManager;
  private ViewAPI myView;
  private List<String> myHistory;
  public Controller(ViewAPI gui){
//    myParser = new Translater();
    myParser = new Translater();
    List<Turtle> turtleList = new ArrayList<Turtle>();
    myManager = new TurtleManager(turtleList);
    resetHistory();
    myView = gui;
  }

  public void parseAndRunCommands(String contents)
      throws Exception {
    updateHistory(contents);
    myParser.parseText(contents);
    List<CommandAPI> commands = myParser.getCommands();
    runCommands(commands);

  }

  public List<String> getHistory(){
    return myHistory;
  }
  public void resetHistory(){
    myHistory = new ArrayList<>();
  }


  private void updateHistory(String contents){
    myHistory.addAll(Arrays.asList(contents.split("\n")));
    myView.notifyHistory();
  }

  public TurtleRecord getRecordTurtle(int turtleID){
    return myManager.getTurtleRecord(turtleID);
  }
  //the commands themselves contain information aout whether to change the active turtle or not and to actualluy
  //chnge the active turtle
  private void runCommands(List<CommandAPI> commands) throws ModelExceptions {
    for (CommandAPI command : commands){
      myManager.stepTurtle(command);
      myView.notifyAnimation();
    }
    myView.animationComplete();
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
