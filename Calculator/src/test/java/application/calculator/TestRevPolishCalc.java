package application.calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {

  private RevPolishCalc calc;
  private Random random;

  @BeforeEach
  void setUp() {
    calc = new RevPolishCalc();
    random = new Random();
  }

  @Test // Test 67
  void testSingleNumber() {
    assertDoesNotThrow(() -> assertEquals(5, calc.evaluate("5")));
  }

  @Test // Test 68
  void testSingleNumberAgain() {
    float randomFloat = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat, calc.evaluate("" + randomFloat)));
  }

  @Test // Test 69
  void testSingleNumberWithSpaces() {
    float randomFloat = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat, calc.evaluate(" " + randomFloat)));
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat2, calc.evaluate(randomFloat2 + " ")));
    float randomFloat3 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat3, calc.evaluate(" " + randomFloat3 + " ")));
  }

  @Test // Test 70, 71, 72
  void testSimpleAddition() {
    assertDoesNotThrow(() -> assertEquals(6, calc.evaluate("1 5 +")));
    float randomFloat1 = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat1 + randomFloat2,
        calc.evaluate(randomFloat1 + " " + randomFloat2 + " +")));
    assertDoesNotThrow(() -> assertEquals(randomFloat1 + randomFloat2,
        calc.evaluate(" " + randomFloat1 + "  " + randomFloat2 + " +    ")));
  }

  @Test // Test 73, 74
  void testInvalidAddition() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1 + 5"));
    assertThrows(InvalidExpression.class, () -> calc
        .evaluate(random.nextFloat() + " " + random.nextFloat() + " + " + random.nextFloat()));
  }

  @Test
  // Test 75
  // Subtraction between the same number
  // Test 76
  // Subtraction between different, random numbers
  void testSimpleSubtraction() {
    assertDoesNotThrow(() -> assertEquals(0, calc.evaluate("1 1 -")));
    float randomFloat = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat - randomFloat2,
        calc.evaluate(randomFloat + " " + randomFloat2 + " -")));
  }

}
