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

/**
 * Purpose: The AnimationHandler class' purpose is what the title says, it handles the animation of
 * the TurtleView/ImageView object. Contains methods that are used to create the animation based off
 * changes in the passed TurtleRecord object.
 * <p>
 * Assumptions: I assume that this is correctly created and set up in the slogoGUI class; Moreover,
 * I assume that it's correctly notified by the Controller class and slogoGUI class on when to
 * create animations for a new command.
 * <p>
 * Dependencies: Depends on the main slogoGUI class where it's created, partially on the Controller
 * class which notifies it, and multiple JavaFX scene imports in order to create the animation
 * <p>
 * Example: When there's a list of animations, the Controller class notifies the slogoGUI class
 * through the API, which then calls this AnimationHandler methods that create the different
 * animations for each command. Once all the commands are run through, plays through the entire
 * animation.
 *
 * @author Eric Xie
 **/

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

  /**
   * Purpose: AnimationHandler object constructor, sets up the elements needed to create the
   * animation and run it
   * <p>
   * Assumptions: Assumed that its correctly created in the slogoGUI and its methods are called when
   * necessary
   *
   * @param panelInput, the CanvasPanel of the Turtle image that we're going to be working with
   */


  public AnimationHandler(CanvasPanel panelInput) {

    penColor = Color.BLACK;
    canvasPanel = panelInput;
    turtleView = canvasPanel.getTurtleView();
    canvasView = canvasPanel.getCanvasView();
    turtleCanvas = canvasView.getTurtleCanvas();
    gc = canvasView.getContext();
    sq = new SequentialTransition();

  }

  private boolean isNotSame(double a, double b) {
    return Math.abs(a - b) > 0.01;
  }

  /**
   * Purpose: Creates the animation for one command in an iteration
   * <p>
   * Assumption: Called correctly when we're working with a command and implements said animation
   * correctly, adding it to a sequential transition
   *
   * @param turtleInput the TurtleRecord holding information of the turtle's position, angle, etc.
   */

  public void createAnimation(TurtleRecord turtleInput) {

    turtleRecord = turtleInput;

    double oldX = turtleRecord.oldX();
    double oldY = turtleRecord.oldY();
    double newX = turtleRecord.xCord();
    double newY = turtleRecord.yCord();

    double CANVAS_OFFSET = (turtleCanvas.getHeight() - TURTLE_OFFSET) / 2;

    if (turtleRecord.penDown()) {
      // create a line to the same location code here
      gc.setStroke(penColor);
      gc.strokeLine(oldX + CANVAS_OFFSET, oldY + CANVAS_OFFSET, newX + CANVAS_OFFSET,
          newY + CANVAS_OFFSET);
    }

    if (isNotSame(turtleRecord.oldAngle(), turtleRecord.angle())) {
      RotateTransition rt = new RotateTransition(Duration.seconds(ANIMATION_DURATION),
          turtleView.getTurtleImage());
      rt.setByAngle(turtleRecord.angle());
      sq.getChildren().add(rt);
    }
    if (isNotSame(oldX, newX) || isNotSame(oldY, newY)) {
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
    System.out.println(
        turtleView.getTurtleImage().getX() + " " + turtleView.getTurtleImage().getY());

  }

  /**
   * Purpose: Plays the entire animation string of the command list after the iteration of the
   * command list is completed
   * <p>
   * Assumption: Called by the slogoGUI after being correctly notified by the Controller that it has
   * run through all the commands in the list
   */

  public void playEntireAnimation() {

    sq.play();
    sq.getChildren().clear();
  }

  // not used in this class

  @Override
  public void updateCanvas(Color colorInput) {

  }

  /**
   * Purpose: Update the pen color when the ColorPicker color has been chosen
   * <p>
   * Assumptions: Assumed to be correctly called after the observer has observed that the color has
   * changed and notifies the listeners
   *
   * @param colorInput color that we want the pen to be
   */

  @Override
  public void updatePen(Color colorInput) {

    penColor = colorInput;

  }
}
