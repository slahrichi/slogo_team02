package slogo.View;

import static slogo.View.Panels.Canvas.TurtleView.TURTLE_OFFSET;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import slogo.Model.TurtleRecord;
import slogo.View.Panels.Canvas.CanvasView;
import slogo.View.Panels.Canvas.TurtleView;
import slogo.View.Panels.CanvasPanel;

public class AnimationHandler {

  private CanvasPanel canvasPanel;
  private TurtleRecord turtleRecord;
  private TurtleView turtleView;
  private CanvasView canvasView;
  private GraphicsContext gc;
  private Canvas turtleCanvas;

  private SequentialTransition sq;

  private static final int ANIMATION_DURATION = 3;


  public AnimationHandler(CanvasPanel panelInput){
    canvasPanel = panelInput;
    turtleView = canvasPanel.getTurtleView();
    canvasView = canvasPanel.getCanvasView();
    turtleCanvas = canvasView.getTurtleCanvas();
    gc = canvasView.getContext();
    sq = new SequentialTransition();

  }


  public void createAnimation(TurtleRecord turtleInput){

    turtleRecord = turtleInput;
    double oldX = turtleRecord.oldX() + TURTLE_OFFSET;
    double oldY = turtleRecord.oldY() + TURTLE_OFFSET;
    double newX = turtleRecord.xCord() + TURTLE_OFFSET;
    double newY = turtleRecord.yCord() + TURTLE_OFFSET;

    double CANVAS_OFFSET =  (turtleCanvas.getHeight() - TURTLE_OFFSET)/ 2;



    if(turtleRecord.penDown()){
      // create a line to the same location code here
      gc.strokeLine(oldX + CANVAS_OFFSET, oldY + CANVAS_OFFSET, newX + CANVAS_OFFSET, newY + CANVAS_OFFSET);
    }

    RotateTransition rt = new RotateTransition(Duration.seconds(ANIMATION_DURATION), turtleView.getTurtleImage());
    if(turtleRecord.oldAngle() != turtleRecord.angle()){
      rt.setByAngle(turtleRecord.angle() + 90);
      sq.getChildren().add(rt);
    }
    if(oldX != newX || oldY != newY){
      // create something to follow
      Path path = new Path();
      path.getElements().addAll(new MoveTo(oldX, oldY),
          new LineTo(newX, newY));
      // create an animation where the shape follows a path
      PathTransition pt = new PathTransition(
          Duration.seconds(ANIMATION_DURATION),
          path, turtleView.getTurtleImage());
          sq.getChildren().add(pt);

    }
    System.out.println(turtleView.getTurtleImage().getX() + " " + turtleView.getTurtleImage().getY());



  }

  public void playEntireAnimation(){

    sq.play();
    sq.getChildren().clear();
  }







}
