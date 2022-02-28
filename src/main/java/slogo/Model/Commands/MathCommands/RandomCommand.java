package slogo.Model.Commands.MathCommands;

import java.util.Random;
import slogo.Model.Commands.Command;

public class RandomCommand extends Command {
  public RandomCommand(double[] params) {
    super(params);
  }


  @Override
  public double getValue(){
    return generateRandomNumer(getParams()[0]);
  }

  @Override
  public String toString(){
    return ("Random " + getValue());
  }

  private double generateRandomNumer(double max){
    Random rand = new Random();
    return rand.nextInt((int) max);
  }
}
