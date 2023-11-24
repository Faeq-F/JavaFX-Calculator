package application.calculator;

import application.stack.NumStack;

/**
 * Evaluates a String as an expression in Reverse Polish (postfix) notation.
 *
 * @author zlac318
 */
public class RevPolishCalc {

  private NumStack numStack;

  public RevPolishCalc() {
    numStack = new NumStack();
  }

  /**
   * Evaluates a String as an expression in Reverse Polish (postfix) notation.
   * 
   * @param expr The expression to evaluate.
   * @return The value the expression evaluates to.
   * @throws InvalidExpression When the expression cannot be calculated.
   */
  public float evaluate(String expr) throws InvalidExpression {
    String[] expression = expr.split(" ");
    try {
      for (String section : expression) {
        switch (section) {
          case "+":
            numStack.push(numStack.pop() + numStack.pop());
            break;
          case "*":
            numStack.push(numStack.pop() * numStack.pop());
            break;
          case "-":
            float secondOp = numStack.pop();
            numStack.push(numStack.pop() - secondOp);
            break;
          case "/":
            secondOp = numStack.pop();
            numStack.push(numStack.pop() / secondOp);
            break;
          default: // The section is a number
            if (section != "") {
              numStack.push(Float.parseFloat(section));
            }
        }
      }
      if (numStack.size() > 1) {
        throw new InvalidExpression();
      } else {
        return numStack.pop();
      }
    } catch (Exception e) {
      throw new InvalidExpression();
    }
  }
}
