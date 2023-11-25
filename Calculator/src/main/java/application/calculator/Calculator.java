package application.calculator;

/**
 * A calculator capable of decoding a String as an arithmetic expression and evaluating the answer.
 */
public interface Calculator {

  /**
   * Does an actual calculation to evaluate a given expression. The calculation depends on the
   * implementing calculator which can be for an INFIX expression with brackets, like standard
   * arithmetic or a POSTFIX expression. In either case a badly formed expression is
   * notified to the caller by throwing an exception.
   * 
   * @param expression the question to be answered
   * @return the calculated value
   * @throws InvalidExpression when the expression cannot be evaluated
   */
  public float evaluate(String expression) throws InvalidExpression;
}
