package slogo.Model.Commands.MathCommands;

import java.util.Random;
public class RandomCommand extends MathCommands {

  public RandomCommand(double[] params) {
    super(params);
  }


  @Override
  public double getValue() {
    return generateRandomNumber(getParams()[0]);
  }

  @Override
  public String toString() {
    return ("Random " + getValue());
  }

  private double generateRandomNumber(double max) {
    Random rand = new Random();
    return rand.nextInt((int) max);
  }
}
