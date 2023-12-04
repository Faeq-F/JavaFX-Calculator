package application.calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {

  private StandardCalc calc;
  private Random random;

  @BeforeEach
  void setUp() {
    calc = new StandardCalc();
    random = new Random();
  }

  @Test
  // Test 131
  // Testing StandardCalc evaluates a single number correctly
  // Test 132
  // Testing StandardCalc evaluates a single (random) number correctly
  void testSingleNumber() {
    assertDoesNotThrow(() -> assertEquals(calc.evaluate("5"), 5));
    float randomFloat = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(calc.evaluate("" + randomFloat), randomFloat));
  }

  @Test
  // Test 133
  // Testing the correct evaluation of simple addition between two numbers
  void testSimpleAddition() {
    assertDoesNotThrow(() -> assertEquals(6, calc.evaluate("1 + 5")));
  }

}
