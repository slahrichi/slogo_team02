package slogo.View.Exceptions;

import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SlogoException extends IOException {

  /**
   * Constructs a new runtime exception with the specified detail message. The cause is not
   * initialized, and may subsequently be initialized by a call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for later retrieval by the
   *                {@link #getMessage()} method.
   */
  public SlogoException(String message) {
    super(message);
  }

  /**
   * Constructs a new runtime exception with the specified detail message and cause.  <p>Note that
   * the detail message associated with {@code cause} is <i>not</i> automatically incorporated in
   * this runtime exception's detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the {@link
   *                #getMessage()} method).
   * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()}
   *                method). (A {@code null} value is permitted, and indicates that the cause is
   *                nonexistent or unknown.)
   * @since 1.4
   */
  public SlogoException(String message, Throwable cause) {
    super(message, cause);
  }


}

