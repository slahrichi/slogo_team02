package slogo.Model.Commands.MathCommmands;

import java.util.Random;


public class RandomRangeCommand extends MathCommands {

  public RandomRangeCommand(double[] params) {
    super(params);
  }


  @Override
  public double getValue() {
    return generateRandomNumber(getParams()[0], getParams()[1]);
  }

  @Override
  public String toString() {
    return ("RandomRange " + getValue());
  }

  private double generateRandomNumber(double min, double max) {
    Random rand = new Random();
    return rand.nextInt((int) min, (int) max);
  }
}
