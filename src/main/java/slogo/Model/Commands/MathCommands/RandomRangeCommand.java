package slogo.Model.Commands.MathCommands;

import java.util.Random;

/**
 * @author Mike Keohane
 *
 * Random Rangle Command
 */
public class RandomRangeCommand extends MathCommands {

  public RandomRangeCommand(double[] params) {
    super(params);
  }

  /**
   * Returns a random value between the specified parameters
   * @return random value between the parameters
   */
  @Override
  public double getValue() {
    return generateRandomNumber(getParams()[0], getParams()[1]);
  }

//  @Override
//  public String toString() {
//    return ("RandomRange " + getValue());
//  }

  private double generateRandomNumber(double min, double max) {
    Random rand = new Random();
    return rand.nextInt((int) min, (int) max);
  }
}
