package application.view;

import java.io.IOException;
import java.util.function.Consumer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

/**
 * This class provides a resizeable JavaFx GUI for the calculator MVC.
 * 
 * @author zlac318
 */

public class CalcView extends Application implements ViewInterface {

  @FXML
  private Button calcButton;

  @FXML
  private TextArea historyPane;

  @FXML
  private ToggleButton selectNotationToggle;

  @FXML
  private TextField textField;

  // Methods for registering an observer and for accessing user data in the UI
  // These methods build the Observer/Observable pattern

  @Override
  public void addCalculateObserver(Runnable function) {
    calcButton.setOnAction(event -> function.run());
  }

  @Override
  public void addTypeObserver(Consumer<String> c) {
    selectNotationToggle.setOnAction(event -> c.accept(""));
  }

  @Override
  public void setCalculatorNotification(String notification) {
    selectNotationToggle.setText(notification + "\n(click to change)");
  }

  @Override
  public String getExpression() {
    return textField.getText();
  }

  @Override
  public void setAnswer(String answer) {
    historyPane.appendText(textField.getText() + " = " + answer + "\n");
    textField.setText(answer);
  }

  @Override
  public void startView() {
    calcButton.setDisable(false);
    selectNotationToggle.setDisable(false);
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    SplitPane page = (SplitPane) FXMLLoader.load(CalcView.class.getResource("View.fxml"));
    Scene scene = new Scene(page);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("Calculator");
    primaryStage.show();
  }

  /////////////////////////////////////////////////////////////////////////////////
  // Block for creating an instance variable for others to use.
  // Make it a JavaFX singleton. Instance is set by the javafx "initialize" method

  private static volatile CalcView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * This is a Singleton View constructed by the JavaaFX Thread and made available through this
   * method.
   * 
   * @return The single object representing this view.
   */
  public static synchronized CalcView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(CalcView.class)).start();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }

    return instance;
  }
  // End of special block
  /////////////////////////////////////////////////////////////////////////////////

}
