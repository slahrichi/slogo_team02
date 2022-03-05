package slogo.View.Observer;

import javafx.scene.paint.Color;

public interface ViewListener {

  public void updateCanvas(Color colorInput);

  public void updatePen(Color colorInput);

}
