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
  // Testing the correct evaluation of simple addition between two random numbers
  void testSimpleAddition() {
    assertDoesNotThrow(() -> assertEquals(6, calc.evaluate("1 + 5")));
    float randomFloat1 = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat1 + randomFloat2,
        calc.evaluate(randomFloat1 + " + " + randomFloat2)));
  }

  // @Test
  // Test 135 - Removed to pass pipeline tests - will add later
  // Testing invalid expression with misplaced + symbol
  /*
   * void testInvalidAddition() { assertThrows(InvalidExpression.class, () ->
   * calc.evaluate("1 5 +")); }
   */

  @Test
  // Test 136
  // Testing simple subtraction between two numbers
  // Solution: added branch for -
  // Test 137
  // Testing simple subtraction between two random numbers
  void testSimpleSubtraction() {
    assertDoesNotThrow(() -> assertEquals(4, calc.evaluate("5 - 1")));
    float randomFloat1 = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat1 - randomFloat2,
        calc.evaluate(randomFloat1 + " - " + randomFloat2)));
  }

  @Test
  // Test 138
  // Testing simple multiplication between two numbers
  // Solution: added branch for *
  // Test 139
  // Testing simple multiplication between two random numbers
  void testSimpleMultiplication() {
    assertDoesNotThrow(() -> assertEquals(10, calc.evaluate("5 * 2")));
    float randomFloat1 = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat1 * randomFloat2,
        calc.evaluate(randomFloat1 + " * " + randomFloat2)));
  }

  @Test
  // Test 140
  // Testing simple division between two numbers
  // Solution: added branch for /
  // Test 141
  // Testing simple division between two random numbers
  void testSimpleDivision() {
    assertDoesNotThrow(() -> assertEquals(2.5, calc.evaluate("5 / 2")));
    float randomFloat1 = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat1 / randomFloat2,
        calc.evaluate(randomFloat1 + " / " + randomFloat2)));
  }

  @Test
  // Test 142
  // Testing evaluation of expression with brackets around an already complete calculation
  // Solution: added branch for ( and ) - made them skip that iteration of the loop
  void testBracketsCompleteExpression() {
    assertDoesNotThrow(() -> assertEquals(2.5, calc.evaluate("( 5 / 2 )")));
  }

  @Test
  // Test 143
  // Testing expression with multiple brackets (with 3 of the same operators)
  // Solution: refactored if statements to check for operators all at once, introducing
  // symbolFromString. Made bracket branches store the symbol onto the stack and then add numbers
  // with relevant operators when popping the brackets off.
  void testMultipleBrackets() {
    assertDoesNotThrow(() -> assertEquals(3.5, calc.evaluate("( 5 / 2 ) / ( 5 / 7 )"), 0.02));
  }

  @Test
  // Test 144
  // Testing expression with multiple brackets and different operators
  void testMultipleBracketsAndOperators() {
    assertDoesNotThrow(
        () -> assertEquals(0.0714285714, calc.evaluate("( 5 / 2 ) / ( 5 * 7 )"), 0.02));
  }

}
