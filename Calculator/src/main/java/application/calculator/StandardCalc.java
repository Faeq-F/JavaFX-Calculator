package application.calculator;

import application.stack.OpStack;
import application.stack.assembly.EmptyStack;
import application.stack.assembly.Symbol;

/**
 * Evaluates a String as an expression in Standard (infix) notation.
 *
 * @author zlac318
 */
public class StandardCalc implements Calculator {

  private OpStack values;
  private RevPolishCalc rpCalc;

  public StandardCalc() {
    rpCalc = new RevPolishCalc();
  }


  /**
   * Evaluates a String as an expression in Standard (infix) notation.
   * 
   * @param expression The expression to evaluate.
   * @return The value the expression evaluates to.
   * @throws InvalidExpression When the expression cannot be calculated.
   */
  @Override
  public float evaluate(String expression) throws InvalidExpression {
    String[] expr = expression.split(" ");
    values = new OpStack();
    String postfixExpr = "";
    for (String section : expr) {
      if (section.equals("+")) {
        values.push(Symbol.PLUS);
      } else {
        postfixExpr += section + " ";
      }
    }
    while (values.size() > 0) {
      try {
        Symbol operator = values.pop();
        postfixExpr += operator.toString().charAt(operator.toString().length() - 1) + " ";
      } catch (EmptyStack e) {
        throw new InvalidExpression();
      }
    }
    return rpCalc.evaluate(postfixExpr);
  }

}
