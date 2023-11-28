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

  @Test
  // Test 67
  // testing RevPolishCalc evaluates a single number correctly.
  // Solution: made evaluate return the required number (faking)
  void testSingleNumber() {
    assertDoesNotThrow(() -> assertEquals(5, calc.evaluate("5")));
  }

  @Test
  // Test 68
  // testing the correct evaluation of a single random number
  // Solution: modified evaluate to return the string parsed as a float
  void testSingleNumberAgain() {
    float randomFloat = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat, calc.evaluate("" + randomFloat)));
  }

  @Test
  // Test 69
  // testing the correct evaluation of a single random number with spaces on either
  void testSingleNumberWithSpaces() {
    float randomFloat = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat, calc.evaluate(" " + randomFloat)));
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat2, calc.evaluate(randomFloat2 + " ")));
    float randomFloat3 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat3, calc.evaluate(" " + randomFloat3 + " ")));
  }

  @Test
  // Test 70
  // testing the correct evaluation of simple addition between two numbers
  // Solution: split the given string and branch to addition when '+' is seen
  // Test 71
  // testing the correct evaluation of simple addition between two random numbers
  // Test 72
  // testing the evaluation of simple addition between two random numbers with superfluous spaces
  void testSimpleAddition() {
    assertDoesNotThrow(() -> assertEquals(6, calc.evaluate("1 5 +")));
    float randomFloat1 = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat1 + randomFloat2,
        calc.evaluate(randomFloat1 + " " + randomFloat2 + " +")));
    assertDoesNotThrow(() -> assertEquals(randomFloat1 + randomFloat2,
        calc.evaluate(" " + randomFloat1 + "  " + randomFloat2 + " +    ")));
  }

  @Test
  // Test 73
  // testing invalid expression with misplaced + symbol
  // Test 74
  // testing invalid expression with too many numbers
  // Solution: threw invalidExpression when the stack has more than one number, at the end of
  // calculation
  void testInvalidAddition() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1 + 5"));
    assertThrows(InvalidExpression.class, () -> calc
        .evaluate(random.nextFloat() + " " + random.nextFloat() + " + " + random.nextFloat()));
  }

  @Test
  // Test 75
  // Subtraction between the same number
  // Solution: wrote subtraction branch
  // Test 76
  // Subtraction between different, random numbers
  // Solution: rearrange the floats when applying - operator
  void testSimpleSubtraction() {
    assertDoesNotThrow(() -> assertEquals(0, calc.evaluate("1 1 -")));
    float randomFloat = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat - randomFloat2,
        calc.evaluate(randomFloat + " " + randomFloat2 + " -")));
  }

  @Test
  // Test 77
  // Misplaced - symbol & too many numbers
  void testInvalidSubtraction() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1 - 5"));
    assertThrows(InvalidExpression.class, () -> calc
        .evaluate(random.nextFloat() + " " + random.nextFloat() + " - " + random.nextFloat()));
  }

  @Test
  // Test 78
  // Multiplication between two numbers
  // Solution: write multiplication branch
  // Test 79
  // Multiplication between two random numbers
  // Solution: implement multiplication
  void testSimpleMultiplication() {
    assertDoesNotThrow(() -> assertEquals(1, calc.evaluate("1 1 *")));
    float randomFloat = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat * randomFloat2,
        calc.evaluate(randomFloat + " " + randomFloat2 + " *")));
  }

  @Test
  // Test 80
  // Misplaced * symbol & too many numbers
  void testInvalidMultiplication() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1 * 5"));
    assertThrows(InvalidExpression.class, () -> calc
        .evaluate(random.nextFloat() + " " + random.nextFloat() + " * " + random.nextFloat()));
  }

  @Test
  // Test 81
  // Division between two numbers
  // Solution: create division branch and return required number
  // Test 82
  // Division between two random numbers
  // Solution: implement division with provided numbers
  void testSimpleDivision() {
    assertDoesNotThrow(() -> assertEquals(1.5, calc.evaluate("3 2 /")));
    float randomFloat = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(randomFloat / randomFloat2,
        calc.evaluate(randomFloat + " " + randomFloat2 + " /")));
  }

  @Test
  // Test 83
  // Misplaced / symbol & too many numbers
  void testInvalidDivision() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1 / 5"));
    assertThrows(InvalidExpression.class, () -> calc
        .evaluate(random.nextFloat() + " " + random.nextFloat() + " / " + random.nextFloat()));
  }

  @Test
  // Test 86
  // Testing that any division by zero results in infinity
  void testDivideByZero() {
    assertDoesNotThrow(
        () -> assertEquals(calc.evaluate(random.nextFloat() + " 0 /"), Float.POSITIVE_INFINITY));
  }

  @Test
  // Test 87
  // Testing expressions with decimals will be calculated correctly
  // Test 88
  // Testing expressions with random decimals for every operator
  void testDecimals() {
    float randomFloat = random.nextFloat();
    float randomFloat2 = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(calc.evaluate(randomFloat + " " + randomFloat2 + " +"),
        randomFloat + randomFloat2));
    assertDoesNotThrow(() -> assertEquals(calc.evaluate(randomFloat + " " + randomFloat2 + " -"),
        randomFloat - randomFloat2));
    assertDoesNotThrow(() -> assertEquals(calc.evaluate(randomFloat + " " + randomFloat2 + " *"),
        randomFloat * randomFloat2));
    assertDoesNotThrow(() -> assertEquals(calc.evaluate(randomFloat + " " + randomFloat2 + " /"),
        randomFloat / randomFloat2));
  }

  @Test
  // Test 89, 90
  // Testing larger mathematical expressions
  void testLargeExpressions() {
    assertDoesNotThrow(() -> assertEquals(63, calc.evaluate("5 6 7 + * 2 -")));

    assertDoesNotThrow(
        () -> assertEquals(21.5454, calc.evaluate("10 6 9 3 + -11 * / * 17 + 5 +"), 0.002));

    assertDoesNotThrow(() -> assertEquals(1357.3636,
        calc.evaluate("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + *"), 0.002));

    assertDoesNotThrow(
        () -> assertEquals(29308.02, calc.evaluate("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + *"
            + " 10 6 9 3 + -11 * / * 17 + 5 + * 5 6 7 + * 2 - +"), 0.02));

    assertDoesNotThrow(() -> assertEquals(1420.3636,
        calc.evaluate("5 6 7 + * 2 - 10 6 9 3 + -11 * / * 17 + 5 + * 5 6 7 + * 2 - +"), 0.002));
  }

  @Test
  // Test 93
  // testing for overflow - calculator should know it is wrong
  void testOverflow() {
    assertDoesNotThrow(() -> assertEquals(4.4028235E38, calc.evaluate(Float.MAX_VALUE + " 1 +")));
  }
}
