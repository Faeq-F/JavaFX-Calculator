package application;

import application.calculator.CalcModel;
import application.view.AsciiView;
import application.view.CalcController;
import application.view.CalcView;
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
   * @param args ignored - will be used to choose which view to load in future
   */
  public static void main(String[] args) {
    ViewInterface view = new AsciiView();

    CalcModel model = new CalcModel();
    
    // Decide which view to build.
    if (System.console() == null) {
      view = CalcView.getInstance();
    }
    
    new CalcController(model, view);
    
    // All ready so begin the interface.
    view.startView();
  }
}
