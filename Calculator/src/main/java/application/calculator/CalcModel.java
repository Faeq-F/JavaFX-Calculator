package application.calculator;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel implements Calculator {
  
  private RevPolishCalc postfixCalc;
  
  public CalcModel() {
    postfixCalc = new RevPolishCalc();
  }
  
  @Override
  public float evaluate(String expression) throws InvalidExpression {
    return postfixCalc.evaluate(expression);
  }
  
  //used for state pattern
  public void setType(boolean infix){
    
  }
}
