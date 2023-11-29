package application.view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import application.calculator.CalcModel;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcController {

  private CalcController testController;
  private Random random;

  @BeforeEach
  void setUp() {
    testController = new CalcController(new CalcModel(), new MockView());
    random = new Random();
  }

  @Test
  // Test 85
  // Testing whether the controller can be used to evaluate a string with a single number
  // Solution: made the CalcView use the controllers evaluate, through the observer methods
  void testSingleNumber() {
    float number = random.nextFloat();
    assertEquals(testController.handleCalculation("" + number), "" + number);
  }

  @Test
  // Test 92
  // Testing larger mathematical expressions
  void testLargeExpressions() {
    assertDoesNotThrow(() -> assertEquals(63,
        Float.parseFloat(testController.handleCalculation("5 6 7 + * 2 -"))));

    assertDoesNotThrow(() -> assertEquals(21.5454,
        Float.parseFloat(testController.handleCalculation("10 6 9 3 + -11 * / * 17 + 5 +")),
        0.002));

    assertDoesNotThrow(() -> assertEquals(1357.3636,
        Float.parseFloat(
            testController.handleCalculation("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + *")),
        0.002));

    assertDoesNotThrow(() -> assertEquals(29308.02,
        Float.parseFloat(
            testController.handleCalculation("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + *"
                + " 10 6 9 3 + -11 * / * 17 + 5 + * 5 6 7 + * 2 - +")),
        0.02));

    assertDoesNotThrow(() -> assertEquals(1420.3636,
        Float.parseFloat(testController
            .handleCalculation("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + * 5 6 7 + * 2 - +")),
        0.002));
  }

}
