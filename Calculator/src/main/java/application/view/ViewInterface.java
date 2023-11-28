package application.view;

import application.calculator.OpType;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Any calculator view must implement these methods to allow the controller and the view to properly
 * work together.
 * 
 * @author Dave Cohen (d.cohen@rhul.ac.uk)
 * @author zlac318
 **/
public interface ViewInterface {

  /**
   * Add the method that should do the calculation. The evaluate parameter has to take a parameter
   * and return the result.
   * 
   * @param evaluate The method to do the calculation.
   */
  void addCalculateObserver(Function<String, String> evaluate);

  /**
   * Add the method to tell the controller the type of calculation to do.
   * 
   * @param c the method to do the calculation takes an OpType argument and returns no value
   */
  void addTypeObserver(Consumer<OpType> c);

  /**
   * The controller can call this to find the current expression to be evaluated.
   */
  String getExpression();

  /**
   * The controller should call this to display the evaluated answer to the user.
   */

  void setAnswer(String a);

  /**
   * Activate the user interface - all systems are go. All buttons start disabled - the controller
   * calls this method once it is ready to start calculating.
   */
  public void startView();
}
