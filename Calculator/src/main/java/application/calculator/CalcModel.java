package application.calculator;

/**
 * Evaluates an expression - the evaluation can be in Standard notation (infix) or Reverse Polish
 * notation (postfix); the setType method provided can be used to switch between these.
 * 
 * @author zlac318
 */
public class CalcModel implements Calculator {

  private Calculator postfix;
  private Calculator infix;
  private Calculator current;

  /**
   * Instantiates the required calculators for evaluating any provided expressions. Sets the initial
   * notation to postfix.
   */
  public CalcModel() {
    postfix = new RevPolishCalc();
    infix = new StandardCalc();
    current = postfix;
  }

  @Override
  public float evaluate(String expression) throws InvalidExpression {
    return current.evaluate(expression);
  }

  // used for state pattern
  /**
   * Sets the type of calculator to use for evaluating the expressions provided.
   * 
   * @param type Whether the model should use infix or postfix notation (pass either "infix" or
   *        "postfix"). If neither is passed, the model will set the notation to use as the one
   *        currently not being used (inverts current type).
   */
  public void setType(String type) {
    switch (type) {
      case "infix":
        current = infix;
        break;
      case "postfix":
        current = postfix;
        break;
      default:
        if (current == postfix) {
          current = infix;
        } else {
          current = postfix;
        }
        break;
    }
  }
  
  @Override
  public String toString() {
    return "Currently using the " + current.toString();
  }
}
