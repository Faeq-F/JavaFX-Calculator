package application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import application.calculator.CalculatorFactory;
import application.view.MockView;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcController {

  private MockView view;
  private CalcController testController;
  private Random random;

  @BeforeEach
  void setUp() {
    view = new MockView();
    view.startView();
    testController = new CalcController(new CalculatorFactory().create(""), view);
    random = new Random();
  }

  /**
   * Reusable method for running assertEquals tests with the MockView.
   * 
   * @param expr The expression to calculate.
   * @param expected The expected result from evaluating the expression. This should be able to be
   *        cast to a float if the calculator is expected to return this.
   * @param delta The delta between the values for them to be considered equal (see delta in
   *        assertEquals). If -1, it is ignored.
   */
  private void runNewTest(String expr, double expected, double delta) {
    view.expression = expr;
    view.calculate();
    if (delta != -1) {
      assertEquals(expected, Float.parseFloat(view.answer), delta);
    } else {
      assertEquals(expected, Float.parseFloat(view.answer));
    }
  }

  @Test
  // Test 85
  // Testing whether the controller can be used to evaluate a string with a single number
  // Solution: made the CalcView use the controllers evaluate, through the observer methods
  void testSingleNumber() {
    float number = random.nextFloat();
    runNewTest("" + number, number, 0.02);
  }


  @Test
  // Test 92
  // Testing larger mathematical expressions
  void testLargeExpressions() {
    runNewTest("5 6 7 + * 2 -", 63, -1);

    runNewTest("10 6 9 3 + -11 * / * 17 + 5 +", 21.5454, 0.002);

    runNewTest("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + *", 1357.3636, 0.002);

    runNewTest("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + *"
        + " 10 6 9 3 + -11 * / * 17 + 5 + * 5 6 7 + * 2 - +", 29308.02, 0.02);

    runNewTest("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + * 5 6 7 + * 2 - +", 1420.3636, 0.002);
  }

  @Test
  // Test 156
  // Testing infix expressions with type change
  void testInfixTypeChange() {
    view.expression = "5 + 2 / 5 * 7 - 8";
    testController.handleTypeChange("infix");
    view.calculate();
    assertEquals(-0.2, Float.parseFloat(view.answer), 0.02);
  }

  @Test
  // Test 157
  // Testing invalid postfix expressions
  void testInvalidExpr() {
    view.expression = "5 6 7 + * 2";
    view.calculate();
    assertEquals(
        "The expression is invalid; There are too many numbers!",
        view.answer);
  }

}
