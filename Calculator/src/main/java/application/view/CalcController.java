package application.view;

import application.calculator.CalcModel;
import application.calculator.InvalidExpression;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalcController {
  private CalcModel model;
  private ViewInterface view;

  /**
   * Get the Model to calculate in the expression passed in, and return the result of the
   * calculation.
   * 
   * @param expr The expression like "5 7 +"
   * @return The result of the calculation.
   */
  public String handleCalculation(String expr) { // could make a mock class to keep these private
    try {
      return "" + model.evaluate(expr);
    } catch (InvalidExpression e) {
      return e.getMessage();
    }
  }

  public void handleTypeChange() {}

  /**
   * Instantiates the calculator.
   * 
   * @param model used to calculate expressions.
   * @param view with actions to observe.
   */
  public CalcController(CalcModel model, ViewInterface view) {
    this.view = view;
    this.model = model;
    view.addCalculateObserver(this::handleCalculation);
  }
}
