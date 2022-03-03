package slogo.Control;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CommandHistory {

  private ObservableList history;

  private CommandHistory(){
    history = FXCollections.observableList(new ArrayList<String>());
  }

  private ObservableList<String> getHistory(){
    return history;
  }

  private void addToHistory(String s){
    history.add(0,s);
  }

}
