package application.view;


/**
 * The Factory (ConcreteCreator) for creating Views (ConcreteProduct).
 * 
 * @author zlac318
 */
public class ViewFactory {

  /**
   * The factory method for creating views based on the type of UI the user wishes to interact with.
   * 
   * @param type The type of interface the user wishes to interact with, which is either 'GUI' or
   *        'CLI'. If neither, the UI created is based off whether System.console() is null.
   * @return The UI for the user to interact.
   */
  public ViewInterface create(String type) {
    switch (type) {
      case "CLI":
        return AsciiView.getInstance();
      case "GUI":
        return CalcView.getInstance();
      default:
        return System.console() == null ? CalcView.getInstance() : AsciiView.getInstance();
    }
  }
}
