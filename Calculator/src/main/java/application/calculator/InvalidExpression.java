package application.calculator;

/**
 * Signals that the provided expression cannot be calculated.
 * 
 * @author zlac318
 */
public class InvalidExpression extends Exception {

  private static final long serialVersionUID = 8820694079512995768L; // auto-generated
  
  public InvalidExpression() {
    super("The expression is invalid");
  }

}
