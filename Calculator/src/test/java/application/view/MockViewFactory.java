package application.view;

/**
 * Used by the test suite as a View Factory.
 */
public class MockViewFactory {

  /**
   * The factory method for creating views based on the type of UI the user wishes to interact with.
   * 
   * @param type The type of interface the user wishes to interact with.
   * @return A representation of the UI, the user would interact with.
   */
  public String create(String type) {
    switch (type) {
      case "CLI":
        return "A CLI";
      case "GUI":
        return "A GUI";
      default:
        return System.console() == null ? "A GUI" : "A CLI";
    }
  }
}
