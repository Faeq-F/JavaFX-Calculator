package application.view;


/**
 * The Factory (ConcreteCreator) for creating Views (ConcreteProduct).
 */
public class ViewFactory {

  /**
   * The factory method for creating views based on the type of UI the user wishes to interact with.
   * 
   * @param type The type of interface the user wishes to interact with.
   * @return The UI for the user to interact.
   */
  public ViewInterface create(String type) {
    switch (type) {
      case "CLI":
        return new AsciiView();
      case "GUI":
        return CalcView.getInstance();
      default:
        return System.console() == null ? CalcView.getInstance() : new AsciiView();
    }
  }
}
