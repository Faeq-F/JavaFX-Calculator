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

  @Test
  // Test 91
  // Testing larger mathematical expressions with default postfix calc
  void testLargeExpressions() {
    assertDoesNotThrow(() -> assertEquals(63, model.evaluate("5 6 7 + * 2 -")));

    assertDoesNotThrow(
        () -> assertEquals(21.5454, model.evaluate("10 6 9 3 + -11 * / * 17 + 5 +"), 0.002));

    assertDoesNotThrow(() -> assertEquals(1357.3636,
        model.evaluate("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + *"), 0.002));

    assertDoesNotThrow(
        () -> assertEquals(29308.02, model.evaluate("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + *"
            + " 10 6 9 3 + -11 * / * 17 + 5 + * 5 6 7 + * 2 - +"), 0.02));

    assertDoesNotThrow(() -> assertEquals(1420.3636,
        model.evaluate("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + * 5 6 7 + * 2 - +"), 0.002));
  }

  @Test
  // Test 152
  // Testing infix expressions after setting type with "infix"
  void testInfixWithStateChange() {
    model.setType("infix");
    assertDoesNotThrow(
        () -> assertEquals(-1.4, model.evaluate("( 5 + 2 ) / ( 5 * ( 7 - 8 ) )"), 0.02));
  }
  
  @Test
  // Test 153
  // Testing postfix expressions after setting type with "postfix"
  void testPostfixWithStateChange() {
    model.setType("postfix");
    assertDoesNotThrow(
        () -> assertEquals(21.5454, model.evaluate("10 6 9 3 + -11 * / * 17 + 5 +"), 0.002));
  }
  
  @Test
  // Test 154
  // Testing infix expressions after setting type with empty string
  void testInfixWithEmptyStateChange() {
    model.setType("");
    assertDoesNotThrow(
        () -> assertEquals(-1.4, model.evaluate("( 5 + 2 ) / ( 5 * ( 7 - 8 ) )"), 0.02));
  }
}
