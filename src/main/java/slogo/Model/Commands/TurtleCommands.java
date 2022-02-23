//package slogo.Model.commands;
//
//import slogo.Model.commands.Command;
//import slogo.Controller.OverarchingController;
//import slogo.Controller.TurtleManager;
//import slogo.Model.Turtle;
//
//public class TurtleCommands extends Command {
//
//  private Turtle commandTurtle;
//  private TurtleManager turtleManager;
//
//  public TurtleCommands() {
//    commandTurtle = turtleManager.getCurrentTurtle();
//  }
//
////  @Override
////  public void createCommand(String command, int value) {
////    return;
////  }
//
//  private void moveCommand(String command, int value){
//
//  }
//
//  private void moveForward(int value){
//    double angle = commandTurtle.getAngle();
//    double newXpos = commandTurtle.getTurtleX() + value * Math.cos(Math.toRadians(angle));
//    double newYpos = commandTurtle.getTurtleY() + value * Math.sin(Math.toRadians(angle));
//    commandTurtle.changeTurtleLocation(newXpos, newYpos);
//  }
//
//  private void moveBackwards(int value){
//    double angle = commandTurtle.getAngle();
//    double newXpos = commandTurtle.getTurtleX() - value * Math.cos(Math.toRadians(angle));
//    double newYpos = commandTurtle.getTurtleY() - value * Math.sin(Math.toRadians(angle));
//    commandTurtle.changeTurtleLocation(newXpos, newYpos);
//  }
//
//  private void rotateRight(int value){
//    commandTurtle.setAngle(commandTurtle.getAngle() + value);
//  }
//
//  private void rotateLeft(int value){
//    commandTurtle.setAngle(commandTurtle.getAngle() - value);
//  }
//
//}
