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

    // Implementation of Shunting Yard Algorithm
    for (String section : expr) {
      if (symbolFromString(section) == Symbol.PLUS || symbolFromString(section) == Symbol.MINUS
          || symbolFromString(section) == Symbol.TIME
          || symbolFromString(section) == Symbol.DIVIDE) {

        try {
          while (values.size() > 0 && values.top() != Symbol.LEFT_BRACKET) {
            Symbol next = values.pop();
            postfixExpr += next.toString().charAt(next.toString().length()) + " ";
          }
        } catch (Exception e) {
          throw new InvalidExpression();
        }

        values.push(symbolFromString(section));


      } else if (section.equals("(")) {
        values.push(Symbol.LEFT_BRACKET);
      } else if (section.equals(")")) {
        try {
          while (values.top() != Symbol.LEFT_BRACKET) {
            Symbol next = values.pop();
            postfixExpr += next.toString().charAt(next.toString().length() - 1) + " ";
          }
          values.pop();
        } catch (Exception e) {
          throw new InvalidExpression();
        }
      } else { // It is a number
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
