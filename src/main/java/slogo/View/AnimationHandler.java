package slogo.View;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;


public class AnimationHandler {
  public final static double ANIMATION_DELAY = 1;

  private Timeline animation;

  public AnimationHandler(){
    animation = new Timeline();
    animation.setCycleCount(Timeline.INDEFINITE);
  }

  public void setupAnimation(EventHandler<ActionEvent> updateStep){
    animation.getKeyFrames().add(new KeyFrame(Duration.seconds(ANIMATION_DELAY), updateStep));
  }

  public void pause(){
    animation.pause();
  }

  public void play(){
    animation.play();
  }


}
