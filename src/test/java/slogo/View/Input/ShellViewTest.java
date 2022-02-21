package slogo.View.Input;

import static org.junit.jupiter.api.Assertions.*;


import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import slogo.View.TurtleGUI;

class ShellViewTest {


  private ShellView myShell;

  @BeforeEach
  void setUp(Stage stage) {

    TurtleGUI myGUI = new TurtleGUI(stage, "English");


  }
}