package application.calculator;

/**
 * The Factory (ConcreteCreator) for creating Calculators (ConcreteProduct).
 */
public class CalculatorFactory {

  /**
   * The factory method for creating Calculators based on the notation the user wishes to use in
   * their expressions.
   * 
   * @param type The notation the user wishes to use. Either "infix" or "postfix" - if neither is
   *        given, then a CalcModel, capable of both types of notation, will be returned.
   * @return The calculator to evaluate the expression.
   */
  public Calculator create(String type) {
    switch (type) {
      case "infix":
        return new StandardCalc();
      case "postfix":
        return new RevPolishCalc();
      default:
        return new CalcModel();
    }
  }

}
