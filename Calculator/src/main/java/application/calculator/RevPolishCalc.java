package application.calculator;

import application.stack.NumStack;
import application.stack.assembly.BadType;
import application.stack.assembly.EmptyStack;

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
    String[] expression = expr.split(" ");
    for (String section : expression) {
      if (section.equals("+")) {
        try {
          numStack.push(numStack.pop() + numStack.pop());
        } catch (Exception e) {
          // There isn't enough numbers in the stack to complete the operation
          throw new InvalidExpression();
        }
      } else { // The section is a number
        if (section != "") {
          numStack.push(Float.parseFloat(section));
        }
      }
    }
    if (numStack.size() > 1) {
      throw new InvalidExpression();
    }
    try {
      return numStack.pop();
    } catch (Exception e) {
      throw new InvalidExpression();
    }
  }
}
