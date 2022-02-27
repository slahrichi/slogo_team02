package slogo.View;

import slogo.Control.TurtleRecord;

public class AnimationHandler {
  public AnimationHandler(){
    doNothingYet();
  }
  private void doNothingYet(){
  }

  public void createAnimation(TurtleRecord turtleRecord){
    double x = turtleRecord.xCord();
    double y = turtleRecord.yCord();
    double angle = turtleRecord.angle();
    boolean penDown = turtleRecord.penDown();
  }


}
