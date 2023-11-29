package application.view;

import application.calculator.OpType;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;


/**
 * Skeleton code for a terminal based calculator that reads an expression from the user and
 * evaluates it and prints out the answer.
 * 
 * @author zlac318
 */
public class AsciiView implements ViewInterface {
  // The current question that the calculator must solve: entered like ?3*(5+4)
  private String question;
  private String answer;
  private Function<String, String> evaluator;

  // This method will be injected so we can ask the controller to calculate
  Runnable doCalculation = null;

  // This method changes how the calculator will evaluate the question
  Consumer<OpType> setCalculatorType = null;


  private void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();

    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.toUpperCase().charAt(0)) {
        case 'C': // Ask the controller to calculate
          System.out.println(evaluator.apply(question).toString());
          break;
        case '?': // Set current question
          question = s.nextLine().replace("?", "");
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
    System.out.println("  ?Expression - to set expression");
    System.out.println("  C - to calculate");
    System.out.println("  S - change to a standard calculator");
    System.out.println("  R - change to a reverse polish calculator");
    System.out.println("  Q - to exit");
  }

  @Override
  public String getExpression() {
    return "0";
  }

  @Override
  public void setAnswer(String answer) {
    System.out.println("Answer is just around the corner");
  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {}

  @Override
  public void startView() {
    menu();
  }

  @Override
  public void addCalculateObserver(Runnable function) {
    //evaluator = evaluate
  }

}
