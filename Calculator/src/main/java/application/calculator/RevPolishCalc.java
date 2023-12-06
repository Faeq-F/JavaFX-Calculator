package application.calculator;

import application.stack.NumStack;

/**
 * Evaluates a String as an expression in Reverse Polish (postfix) notation.
 *
 * @author zlac318
 */
public class RevPolishCalc implements Calculator {

  private NumStack numStack;
  // Add better InvalidExpression strings

  /**
   * Evaluates a String as an expression in Reverse Polish (postfix) notation.
   * 
   * @param expr The expression to evaluate.
   * @return The value the expression evaluates to.
   * @throws InvalidExpression When the expression cannot be calculated.
   */
  @Override
  public float evaluate(String expr) throws InvalidExpression {
    numStack = new NumStack();
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
              float number = Float.parseFloat(section);
              if (number == Float.MAX_VALUE || number == Float.MIN_VALUE
                  || number == Float.NEGATIVE_INFINITY || number == Float.POSITIVE_INFINITY) {
                throw new InvalidExpression("The result is too high / too low to compute!");
              }
              numStack.push(number);
            }
        }
      }
      if (numStack.size() > 1) {
        throw new InvalidExpression("There are too many numbers!");
      } else {
        return numStack.pop();
      }
    } catch (Exception e) { // replace prevents phrase from duplicating when exception propagates
      throw new InvalidExpression(e.getMessage().replace("The expression is invalid; ", ""));
    }
  }
  
  @Override
  public String toString() {
    return "Reverse Polish (postfix) calculator";
  }
}
