package application.view;

import java.util.function.Consumer;

/**
 * Used by the test suite as a View - it is convenient to have a mock view with public fields.
 */
public class MockView implements ViewInterface {
  public Runnable evaluateMethodToBeNotified;
  public String expression;
  public String answer;
  public String type;

  @Override
  public void addCalculateObserver(Runnable function) {
    evaluateMethodToBeNotified = function;
  }

  @Override
  public void addTypeObserver(Consumer<String> c) {}

  /**
   * A mock method representing what would happen when the user would press the 'calculate' button
   * in the GUI view.
   */
  public void calculate() {
    evaluateMethodToBeNotified.run();
  }

  @Override
  public String getExpression() {
    return expression;
  }

  @Override
  public void setAnswer(String a) {
    answer = a;
  }

  @Override
  public void startView() {
    evaluateMethodToBeNotified = null;
    expression = "";
  }
}
