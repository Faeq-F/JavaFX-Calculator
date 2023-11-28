package application.view;

import application.calculator.OpType;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Used by the test suite as a View - it is convenient to have a mock view with public fields.
 */
public class MockView implements ViewInterface {
  public Function<String, String> evaluateMethodToBeNotified = null;

  @Override
  public void addCalculateObserver(Function<String, String> evaluate) {
    evaluateMethodToBeNotified = evaluate;
  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
  }

  @Override
  public String getExpression() {
    return null;
  }

  @Override
  public void setAnswer(String a) {
  }

  @Override
  public void startView() {
  }
}