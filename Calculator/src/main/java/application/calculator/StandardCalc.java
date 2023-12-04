package application.calculator;

import application.stack.OpStack;
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
  public float evaluate(String expression) throws InvalidExpression {
    try {
      try {
        return Float.parseFloat(expression);
      } catch(Exception exc) {
        rpCalc.evaluate(expression);  
      }
    } catch (Exception e) {

      String[] expr = expression.split(" ");
      values = new OpStack();
      String postfixExpr = "";

      // Implementation of Shunting Yard Algorithm
      try {
        for (String section : expr) {
          Symbol sectionAsSymbol = symbolFromString(section);

          if (sectionAsSymbol == Symbol.LEFT_BRACKET) {
            values.push(Symbol.LEFT_BRACKET);

          } else if (sectionAsSymbol == Symbol.RIGHT_BRACKET) {

            while (values.top() != Symbol.LEFT_BRACKET) { // Add operators from stack until (
              Symbol operator = values.pop();
              postfixExpr += operator.toString().charAt(operator.toString().length() - 1) + " ";
            }
            values.pop();

          } else if (sectionAsSymbol != Symbol.INVALID) { // It is an operator

            // If it has < priority than the operator on the top of the stack
            while (values.size() > 0 && values.top() != Symbol.LEFT_BRACKET
                && getOperationOrder(values.top()) >= getOperationOrder(sectionAsSymbol)) {
              // add the operator from the stack
              Symbol operator = values.pop();
              postfixExpr += operator.toString().charAt(operator.toString().length() - 1) + " ";
            }

            // Once the current operator has >= priority, push it to the stack
            values.push(sectionAsSymbol);

          } else { // it is a number
            postfixExpr += section + " ";
          }
        }

        // Add on any remaining operators on the stack (There should be no brackets left)
        while (values.size() > 0) {
          Symbol operator = values.pop();
          postfixExpr += operator.toString().charAt(operator.toString().length() - 1) + " ";
        }

        return rpCalc.evaluate(postfixExpr);

      } catch (Exception ex) {
        throw new InvalidExpression();
      }
    }
    throw new InvalidExpression();
  }

  /**
   * Provides the priority of an operation, with 2 being the highest.
   * 
   * @param operator The operator whose conventional operation priority is to be found.
   * @return The priority of the operation enacted by the operator, with 2 being the highest.
   */
  private static int getOperationOrder(Symbol operator) {
    if (operator == Symbol.PLUS || operator == Symbol.MINUS) {
      return 1;
    } else if (operator == Symbol.TIME || operator == Symbol.DIVIDE) {
      return 2;
    } else {
      return 0;
    }
  }

  /**
   * Casts a string into a Symbol.
   * 
   * @param symbol The symbol that needs to be cast into a string. i.e. "*", "/", etc.
   * @return The symbol corresponding to the argument passed in. Returns Symbol.Invalid if the
   *         argument does not match any symbol.
   */
  private static Symbol symbolFromString(String symbol) {
    switch (symbol) {
      case "+":
        return Symbol.PLUS;
      case "-":
        return Symbol.MINUS;
      case "*":
        return Symbol.TIME;
      case "/":
        return Symbol.DIVIDE;
      case "(":
        return Symbol.LEFT_BRACKET;
      case ")":
        return Symbol.RIGHT_BRACKET;
      default:
        return Symbol.INVALID;
    }
  }
}
