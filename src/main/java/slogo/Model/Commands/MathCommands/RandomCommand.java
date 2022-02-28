package slogo.Model.Commands.MathCommands;

import java.util.Random;
import slogo.Model.Commands.Command;
<<<<<<< HEAD:src/main/java/slogo/Model/Commands/MathCommands/RandomCommand.java
=======

>>>>>>> a1fd1bd9892aad0647f852e5510072745a3922c9:src/main/java/slogo/Model/Commands/MathCommmands/RandomCommand.java

public class RandomCommand extends Command {
  public RandomCommand(double[] params) {
    super(params);
  }


  @Override
  public double getValue(){
    return generateRandomNumber(getParams()[0]);
  }

  @Override
  public String toString(){
    return ("Random " + getValue());
  }

  private double generateRandomNumber(double max){
    Random rand = new Random();
    return rand.nextInt((int) max);
  }
}
