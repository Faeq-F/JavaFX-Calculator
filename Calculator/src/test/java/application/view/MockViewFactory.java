package application.view;

/**
 * Used by the test suite as a View Factory.
 */
public class MockViewFactory {

  /**
   * The factory method for creating views based on the type of UI the user wishes to interact with.
   * 
   * @param type The type of interface the user wishes to interact with.
   * @return A MockView with the type of UI the user would interact with.
   */
  public ViewInterface create(String type) {
    MockView view = new MockView();
    switch (type) {
      case "CLI":
        view.type = "CLI";
        return view;
      case "GUI":
        view.type = "GUI";
        return view;
      default:
        if (System.console() == null) {
          view.type = "GUI";
        } else {
          view.type = "CLI";
        }
        return view;
    }
  }
}
