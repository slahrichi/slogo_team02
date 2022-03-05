package slogo.Model;

/**
 * @author mike keohane
 * Record object with all the values from turtle that the view needs for
 * animation
 */
public record TurtleRecord(double xCord, double yCord, double angle, boolean penDown, double oldX,
                           double oldY, double oldAngle, int turtleId) {

}
