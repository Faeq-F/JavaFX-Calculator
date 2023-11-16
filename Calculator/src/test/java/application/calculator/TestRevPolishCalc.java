package application.calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {

  private RevPolishCalc calc;

  @BeforeEach
  void setUp() {
    calc = new RevPolishCalc();
  }

  @Test // Test 67
  void testSingleNumber() {
    assertDoesNotThrow(() -> assertEquals(calc.evaluate("5"), 5));
  }

}
