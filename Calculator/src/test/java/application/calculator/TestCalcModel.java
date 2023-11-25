package application.calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {

  private CalcModel model;
  private Random random;

  @BeforeEach
  void setUp() {
    model = new CalcModel();
    random = new Random();
  }


  @Test
  // Test 84
  // Testing an expression is evaluated by the postfix calculator by default
  // Solution: wrote CalcModel.evaluate - directly passed expression to RevPolishCalc.evaluate
  void testPassThrough() {
    float firstNum = random.nextFloat();
    float secondNum = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(firstNum * secondNum,
        model.evaluate(firstNum + " " + secondNum + " *")));
  }

}
