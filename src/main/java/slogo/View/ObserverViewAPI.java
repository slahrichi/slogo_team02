package slogo.View;

import slogo.Model.TurtleManagerException;

public interface ObserverViewAPI {
  void notifyHistory();
  void notifyAnimation();

  void animationComplete();
}
