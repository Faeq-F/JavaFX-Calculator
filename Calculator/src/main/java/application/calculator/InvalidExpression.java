package application.calculator;

/**
 * An expression was passed to a method that could not be evaluated.
 * 
 * @author zlac318
 */
public class InvalidExpression extends Exception {

  private static final long serialVersionUID = 8820694079512995768L; // auto-generated

  /**
   * Constructs the exception with a default message.
   */
  public InvalidExpression() {
    super("The expression is invalid; please check the format of the expression."
        + " The resulting value may be too large or too small.");
  }

  /**
   * Constructs the exception with the provided message.
   * 
   * @param message The message for the exception (what went wrong).
   */
  public InvalidExpression(String message) {
    super("The expression is invalid; " + message);
  }

}
