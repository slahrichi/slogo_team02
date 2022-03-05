package slogo.View;

// internal view observer

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class ViewPublisher {

  private Color colorInput;
  private List<ViewListener> listeners = new ArrayList<>();

  public void addObserver(ViewListener listen){
    this.listeners.add(listen);
  }

  public void updateColor(Color color){
    this.colorInput = color;
    for(ViewListener listenerObj : this.listeners){
      listenerObj.updateCanvas(this.colorInput);
    }
  }

  public void updatePen(Color color){
    this.colorInput = color;
    for(ViewListener listenerObj : this.listeners){
      listenerObj.updatePen(this.colorInput);
    }
  }



}
