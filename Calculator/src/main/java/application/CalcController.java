package application;

import application.calculator.CalcModel;
import application.calculator.Calculator;
import application.calculator.InvalidExpression;
import application.view.ViewInterface;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 * 
 * @author zlac318
 */
public class CalcController {
  private Calculator model;
  private ViewInterface view;

  /**
   * Get the Model to calculate the expression from the view, and set the result of the calculation
   * in the relevant place, in the view.
   */
  public void handleCalculation() { // could make a mock class to keep these private?
    try {
      view.setAnswer("" + model.evaluate(view.getExpression()));
    } catch (InvalidExpression e) {
      view.setAnswer(e.getMessage());
    }
  }

  public void handleTypeChange(String type) {
    ((CalcModel) model).setType(type); // You can only change type if using the CalcModel
    setCalculatorNotification();
  }
  
  public void setCalculatorNotification() {
    view.setCalculatorNotification(model.toString());
  }

  /**
   * Instantiates the calculator.
   * 
   * @param model Used to calculate expressions.
   * @param view The view with actions to observe.
   */
  public CalcController(Calculator model, ViewInterface view) {
    this.view = view;
    this.model = model;
    view.addCalculateObserver(this::handleCalculation);
    view.addTypeObserver(this::handleTypeChange);
    setCalculatorNotification();
  }
}
