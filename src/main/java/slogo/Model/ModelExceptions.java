package slogo.Model;

public class ModelExceptions extends Exception{

    public ModelExceptions(String message) {
      super(message);

    }

    public ModelExceptions(String message, Throwable cause) {
      super(message, cause);
    };

}
