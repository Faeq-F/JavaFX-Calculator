package application.calculator;

import application.stack.NumStack;

/**
 * Evaluates a String as a Reverse Polish (postfix) expression.
 *
 * @author zlac318
 */
public class RevPolishCalc {

  private NumStack numStack;
  
  public RevPolishCalc() {
    numStack = new NumStack();
  }

  /**
   * Evaluates a String as a Reverse Polish (postfix) expression.
   * 
   * @param expr The expression to evaluate
   * @return The number the expression evaluates to
   * @throws InvalidExpression when the expression cannot be calculated
   */
  public float evaluate(String expr) throws InvalidExpression {
    return 5;
  }
}
