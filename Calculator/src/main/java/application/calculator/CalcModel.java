package application.calculator;

/**
 * Evaluates an expression - the evaluation can be in Standard notation (infix) or Reverse Polish
 * notation (postfix); the setType method provided can be used to switch between these. 
 * 
 * @author zlac318
 */
public class CalcModel implements Calculator {

  private RevPolishCalc postfixCalc;
  
  /**
   * Instantiates the required calculators for evaluating any provided expressions. 
   */
  public CalcModel() {
    postfixCalc = new RevPolishCalc();
  }

  @Override
  public float evaluate(String expression) throws InvalidExpression {
    return postfixCalc.evaluate(expression);
  }

  // used for state pattern
  /**
   * Sets the type of calculator to use for evaluating the expressions provided.
   * 
   * @param infix whether the model should use infix or postfix notation
   */
  public void setType(boolean infix) {

  }
}
