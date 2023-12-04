package application.calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {
  
  private StandardCalc calc;

  @BeforeEach
  void setUp() {
    calc = new StandardCalc();
  }

  @Test
  // Test 131
  // Testing StandardCalc evaluates a single number correctly
  void testSingleNumber() {
    assertDoesNotThrow(() -> assertEquals(calc.evaluate("5"), 5));
  }

}
