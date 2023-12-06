package application.view;

import java.util.function.Consumer;

/**
 * Any calculator view must implement these methods to allow the controller and the view to properly
 * work together.
 * 
 * @author Dave Cohen (d.cohen@rhul.ac.uk)
 * @author zlac318
 **/
public interface ViewInterface {

  /**
   * Add the method that should do the calculation.
   * 
   * @param function The runnable object to do the calculation (a method that takes no parameters
   *        and returns no value).
   */
  void addCalculateObserver(Runnable function);

  /**
   * Add the method to tell the controller the type of calculation to do.
   * 
   * @param consumer The method to do the calculation takes a string argument and returns no value.
   */
  void addTypeObserver(Consumer<String> consumer);

  /**
   * The controller can call this to find the current expression to be evaluated.
   */
  String getExpression();

  /**
   * The controller should call this to display the evaluated answer to the user.
   */
  void setAnswer(String a);

  /**
   * The controller should call this to save a notification to the view. The notification is to
   * indicate to the user, which calculator they are currently using.
   * 
   * @param notification The notification to show the user, informing them on which calculator is
   *        being used.
   */
  void setCalculatorNotification(String notification);

  /**
   * Activate the user interface - all systems are go. All buttons start disabled - the controller
   * calls this method once it is ready to start calculating.
   */
  public void startView();
}
