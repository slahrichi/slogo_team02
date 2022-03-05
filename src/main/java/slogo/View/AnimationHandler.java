package slogo.View;

import static slogo.View.Panels.Canvas.TurtleView.TURTLE_OFFSET;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import slogo.Model.TurtleRecord;
import slogo.View.Observer.ViewListener;
import slogo.View.Panels.Canvas.CanvasView;
import slogo.View.Panels.Canvas.TurtleView;
import slogo.View.Panels.CanvasPanel;

public class AnimationHandler implements ViewListener {

  private CanvasPanel canvasPanel;
  private TurtleRecord turtleRecord;
  private TurtleView turtleView;
  private CanvasView canvasView;
  private GraphicsContext gc;
  private Canvas turtleCanvas;
  private Color penColor;

  private SequentialTransition sq;

  private static final double ANIMATION_DURATION = 1.5;


  public AnimationHandler(CanvasPanel panelInput){

    penColor = Color.BLACK;
    canvasPanel = panelInput;
    turtleView = canvasPanel.getTurtleView();
    canvasView = canvasPanel.getCanvasView();
    turtleCanvas = canvasView.getTurtleCanvas();
    gc = canvasView.getContext();
    sq = new SequentialTransition();

  }
  private boolean isNotSame(double a, double b){
    return Math.abs(a - b) > 0.01;
  }

  public void createAnimation(TurtleRecord turtleInput){

    turtleRecord = turtleInput;

    double oldX = turtleRecord.oldX();
    double oldY = turtleRecord.oldY();
    double newX = turtleRecord.xCord();
    double newY = turtleRecord.yCord();

    double CANVAS_OFFSET =  (turtleCanvas.getHeight() - TURTLE_OFFSET)/ 2;



    if(turtleRecord.penDown()){
      // create a line to the same location code here
      gc.setStroke(penColor);
      gc.strokeLine(oldX + CANVAS_OFFSET, oldY + CANVAS_OFFSET, newX + CANVAS_OFFSET, newY + CANVAS_OFFSET);
    }


    if(isNotSame(turtleRecord.oldAngle(),turtleRecord.angle())){
      RotateTransition rt = new RotateTransition(Duration.seconds(ANIMATION_DURATION), turtleView.getTurtleImage());
      rt.setByAngle(turtleRecord.angle());
      sq.getChildren().add(rt);
    }
    if(isNotSame(oldX, newX) || isNotSame(oldY,newY)){
      // create something to follow
      Path path = new Path();
      path.getElements().addAll(new MoveTo(oldX, oldY),
          new LineTo(newX, newY));
      // create an animation where the shape follows a path
      PathTransition pt = new PathTransition(
          Duration.seconds(ANIMATION_DURATION),
          path, turtleView.getTurtleImage());
          sq.getChildren().add(pt);
      System.out.println("pth trans");

    }
    System.out.println(turtleView.getTurtleImage().getX() + " " + turtleView.getTurtleImage().getY());



  }

  public void playEntireAnimation(){

    sq.play();
    sq.getChildren().clear();
  }


  @Override
  public void updateCanvas(Color colorInput) {

  }

  @Override
  public void updatePen(Color colorInput) {

    penColor = colorInput;

  }
}
