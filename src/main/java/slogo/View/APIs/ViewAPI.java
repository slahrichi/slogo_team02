package slogo.View.APIs;

import java.lang.reflect.InvocationTargetException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 *
 * ViewAPI for the front end to connect with the controller in sending file contents after typing in the editor
 * or the shell input boxes. It also offers a clearHistory option for the controller to use whenever we reset the program.
 *
 *
 * @author: Eric Xie
 */
public interface ViewAPI {

  // clears history in the command history panel text area
  void clearHistory();

  // takes file content string argument and sends it to the controller for parsing
  void sendFileContents(String fileContent)
      throws Exception;
}


