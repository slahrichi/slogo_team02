package slogo.View;

import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import slogo.Control.TurtleRecord;
import slogo.View.Panels.Canvas.TurtleView;

public class AnimationHandler {

  private TurtleRecord turtleRecord;
  private TurtleView turtleView;


  public AnimationHandler(TurtleView turtleInput){
    turtleView = turtleInput;

  }


  private void createAnimation(){

    // create something to follow
    Path path = new Path();
    path.getElements().addAll(new MoveTo(turtleRecord.oldX(), turtleImage.oldY()),
        new LineTo(turtleRecord.xCord() + TURTLE_SIZE, turtleRecord.yCord() + TURTLE_SIZE));
    // create an animation where the shape follows a path
    PathTransition pt = new PathTransition(
        Duration.seconds(3),
        path);

    if(turtleRecord.penDown()){
      // create a line to the same location code here

    }

    pt.play();
  }







}
