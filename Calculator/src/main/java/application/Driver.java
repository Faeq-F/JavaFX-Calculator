package application;

import application.calculator.Calculator;
import application.calculator.CalculatorFactory;
import application.view.ViewFactory;
import application.view.ViewInterface;

/**
 * A driver class that sets up the MVC framework and begins the application.
 * 
 * @author zlac318
 */
public class Driver {

  /**
   * The entry point for the calculator.
   * 
   * @param args A single string, which is either 'GUI' or 'CLI', used to create the desired UI. If
   *        neither, the UI created is based off whether System.console() is null.
   */
  public static void main(String[] args) {
    
    // Auto-magically choose which view to use!
    ViewFactory viewFactory = new ViewFactory();
    // Auto-magically choose which calculator to use!
    CalculatorFactory calcFactory = new CalculatorFactory();
    
    ViewInterface view = viewFactory.create(args.length < 1 ? "" : args[0]);
    Calculator calc = calcFactory.create("");
    
    //Everything is ready
    new CalcController(calc, view);
    view.startView();
  }
}
