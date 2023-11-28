package application.calculator;

/**
 * An expression was passed to a method that could not be evaluated.
 * 
 * @author zlac318
 */
public class InvalidExpression extends Exception {

  private static final long serialVersionUID = 8820694079512995768L; // auto-generated

  public InvalidExpression() {
    super("The expression is invalid; please check the format of the expression."
        + "\nThe resulting value may be too large or too small.");
  }

}
