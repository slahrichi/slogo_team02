package slogo.View;

/**
 * @author Mike Keohane
 * <p>
 * Interface that lets the controller send notify signals to the view in order to make it update
 * accordingly.
 */
public interface ObserverViewInterface {

  void notifyHistory();

  void notifyAnimation();

  void animationComplete();
}
