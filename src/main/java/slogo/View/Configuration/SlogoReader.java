package slogo.View.Configuration;

import static slogo.View.slogoGUI.showMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import slogo.View.Exceptions.SlogoException;

public class SlogoReader {

  private String fileContents;
  private Path fileName;

  public SlogoReader(String file) throws IOException {

    try {
      fileName = Path.of(file);
      parseFile();
    }
    catch (SlogoException e){
      showMessage(AlertType.ERROR, e.getMessage());
    }
  }

  private void parseFile() throws IOException {

    try {
      fileContents = Files.readString(fileName);
    }
    catch (SlogoException e){
      showMessage(AlertType.ERROR, e.getMessage());
    }


  }

  public String getString(){
    return fileContents;
  }


}
