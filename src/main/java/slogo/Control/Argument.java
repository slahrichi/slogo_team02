package slogo.Control;

/**
 * Since anything the user writes has a name (fd, 90, rt) and a value (the return of each command, the double of the constant), we could use
 * this class to represent that
 */
public class Argument {

  private String name;
  private Double value;

  public Argument(String name, Double value){
    this.name = name;
    this.value = value;
  }

  public String getString(){
    return name;
  }

  public Double getValue(){
    return value;
  }
}
