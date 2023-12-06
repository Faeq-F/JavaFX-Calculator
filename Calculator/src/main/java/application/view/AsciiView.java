package application.view;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * View for a terminal based calculator that reads an expression from the user and evaluates it and
 * prints out the answer. Expressions must be entered like ? 3 * ( 5 + 4 )
 * 
 * @author zlac318
 */
public class AsciiView implements ViewInterface {

  // The current question that the calculator must solve: entered like ? 3 * ( 5 + 4 )
  private String question;

  // The current type of calculator being used - a notification given to the user when they first
  // run the program & change type
  private String typeNotification;

  private String history;

  // This method will be injected so we can ask the controller to calculate
  Runnable doCalculation;

  // This method changes how the calculator will evaluate the question
  Consumer<String> setCalculatorType;

  private void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    System.out.println(typeNotification);
    help();
    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.toUpperCase().charAt(0)) {
        case '?': // Set and calculate current question
          question = s.nextLine();
          doCalculation.run();
          break;
        case 'C': // Change the notation type to the one currently not being used
          setCalculatorType.accept("");
          System.out.println(typeNotification);
          break;
        case 'H':
          System.out.println("\n\nHistory:\n" + history + "\n");
          break;
        case 'Q':
          System.out.println("Bye");
          finished = true;
          break;
        default:
          help();
      }
    }
    s.close();
  }

  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("  ? Expression - to calculate an expression");
    System.out.println("  C - to change notation type");
    System.out.println("  H - to display history");
    System.out.println("  Q - to exit");
  }

  @Override
  public String getExpression() {
    return question;
  }

  @Override
  public void setAnswer(String answer) {
    System.out.println(answer);

    if (answer.contains("invalid")) {
      answer = "invalid expression"; // less clutter in history view
    }
    history += question + " = " + answer + "\n";
  }

  @Override
  public void startView() {
    menu();
  }

  // Methods for registering an observer and for accessing user data in the UI
  // These methods build the Observer/Observable pattern

  @Override
  public void addCalculateObserver(Runnable function) {
    doCalculation = function;
  }

  @Override
  public void addTypeObserver(Consumer<String> c) {
    setCalculatorType = c;
  }

  @Override
  public void setCalculatorNotification(String notification) {
    typeNotification = notification;
  }

  /////////////////////////////////////////////////////////////////////////////////
  // Block for creating an instance variable for others to use - singleton.

  /**
   * A private constructor for the singleton View. Constructs the view.
   */
  private AsciiView() {
    doCalculation = null;
    setCalculatorType = null;
    history = "";
  }

  private static volatile AsciiView instance = new AsciiView();

  /**
   * This is a Singleton View made available through this method.
   * 
   * @return The single object representing this view.
   */
  public static synchronized AsciiView getInstance() {
    if (instance == null) {
      instance = new AsciiView();
    }
    return instance;
  }
  // End of special block
  /////////////////////////////////////////////////////////////////////////////////


}
