package application.view;

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

}
