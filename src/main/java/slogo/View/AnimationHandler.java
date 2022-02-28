package slogo.View;

import static slogo.View.Panels.Canvas.TurtleView.turtleSize;

import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import slogo.Control.TurtleRecord;
import slogo.View.Panels.Canvas.TurtleView;

public class AnimationHandler {

  private TurtleView turtleImage;
  private TurtleRecord turtleRecord;


  public AnimationHandler(){

  }


  public void createAnimation(TurtleRecord turtleInput){

    //boolean penDown = turtleRecord.penDown();
    turtleRecord = turtleInput;

    // create something to follow
    Path path = new Path();
    path.getElements().addAll(new MoveTo(turtleImage.getOldX(), turtleImage.getOldY()),
        new LineTo(turtleRecord.xCord() + turtleSize, turtleRecord.yCord() + turtleSize));
    // create an animation where the shape follows a path
    PathTransition pt = new PathTransition(
        Duration.seconds(3),
        path, turtleImage.getTurtleImage());

    if(turtleRecord.penDown()){
      // create a line to the same location code here

    }

    updateOldValues();

    pt.play();


  }


  private void updateOldValues(){

    turtleImage.setOldX(turtleRecord.xCord());
    turtleImage.setOldY(turtleRecord.yCord());
    turtleImage.setAngle(turtleRecord.angle());

  }


}
