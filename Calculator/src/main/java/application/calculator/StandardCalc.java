package application.calculator;

/**
 * Evaluates a String as an expression in Standard (infix) notation.
 *
 * @author zlac318
 */
public class StandardCalc implements Calculator {


  /**
   * Evaluates a String as an expression in Standard (infix) notation.
   * 
   * @param expression The expression to evaluate.
   * @return The value the expression evaluates to.
   * @throws InvalidExpression When the expression cannot be calculated.
   */
  @Override
  public float evaluate(String expression) throws InvalidExpression {
    return Float.parseFloat(expression);
  }

}
