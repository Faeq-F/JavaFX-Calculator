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
  // Solution: made evaluate return the desired number
  // Test 132
  // Testing StandardCalc evaluates a single (random) number correctly
  // Solution: made evaluate return the argument parsed as a float
  void testSingleNumber() {
    assertDoesNotThrow(() -> assertEquals(calc.evaluate("5"), 5));
    float randomFloat = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(calc.evaluate("" + randomFloat), randomFloat));
  }

  @Test
  // Test 133
  // Testing the correct evaluation of simple addition between two numbers
  // Solution: Split the argument into sections and push + onto the stack when it is encountered
  // Pop the operator off the stack after all numbers have been added to the postfix string
  // Test 134
  // Testing the correct evaluation of simple addition between two random numbers.
  void testSimpleAddition() {
    assertDoesNotThrow(() -> assertEquals(6, calc.evaluate("1 + 5")));
    float randomFloat1 = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat1 + randomFloat2,
        calc.evaluate(randomFloat1 + " + " + randomFloat2)));
  }

}
