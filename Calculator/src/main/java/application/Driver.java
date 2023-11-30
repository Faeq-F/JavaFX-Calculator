package application;

import application.calculator.CalcModel;
import application.view.CalcController;
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
    ViewFactory viewFactory = new ViewFactory(); // Auto-magically choose which view to use!
    ViewInterface view = viewFactory.create(args.length < 1 ? "" : args[0]);

    new CalcController(new CalcModel(), view);
    view.startView();
  }
}
