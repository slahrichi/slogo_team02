package slogo.Control;

import java.util.LinkedList;

public class RepeatArgument extends Argument {

  private LinkedList repeatCommands;
  private Double value;

  public RepeatArgument(LinkedList repeatCommands, Double value){
    super(repeatCommands.toString(), value);
    this.repeatCommands = repeatCommands;
    this.value = value;
  }

  public String getName(){
    return repeatCommands.toString();
  }

  public Double getValue(){
    return value;
  }

  public String toString(){
    return getName() + " " + getValue();
  }

}
