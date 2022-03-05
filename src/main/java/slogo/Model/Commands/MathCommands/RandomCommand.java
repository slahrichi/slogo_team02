package slogo.Model.Commands.MathCommands;

import java.util.Random;

/**
 * @author Mike Keohane
 *
 * Random Command
 */
public class RandomCommand extends MathCommands {

  public RandomCommand(double[] params) {
    super(params);
  }

  /**
   * Gets a random int from 0 to param[0]
   * @return random double that corresponds to the into
   */
  @Override
  public double getValue() {
    return generateRandomNumber(getParams()[0]);
  }

//  @Override
//  public String toString() {
//    return ("Random " + getValue());
//  }

  private double generateRandomNumber(double max) {
    Random rand = new Random();
    return rand.nextInt((int) max);
  }
}
