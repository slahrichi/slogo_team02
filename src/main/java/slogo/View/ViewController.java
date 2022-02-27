package slogo.View;

import slogo.Control.Controller;

// SINGLETON DESIGN PATTERN CLASS TO GIVE CONTROLLER INSTANCE TO MULTIPLE CLASSES

public class ViewController {

  private static Controller turtleController = new Controller();

  private ViewController(){
  }

  public static Controller getController(){
    return turtleController;
  }

}
