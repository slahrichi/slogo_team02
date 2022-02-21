package slogo.View;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import slogo.Controller.TurtleManager;

public class AnimationHandler {
  public final static double ANIMATION_DELAY = 1;


  Timeline animation;
  TurtleManager manager;
  public AnimationHandler(){
//    manager = TurtleManager(this);
//    animation = new Timeline();
//    animation.getKeyFrames().add(new KeyFrame(Duration.seconds(ANIMATION_DELAY), e -> manager.step()));
  }

  public void pause(){
    animation.pause();
  }

  public void play(){
    animation.play();
  }


}
