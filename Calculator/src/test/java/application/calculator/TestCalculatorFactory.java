package application.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalculatorFactory {

  private CalculatorFactory calcFactory;

  @BeforeEach
  void setUp() {
    calcFactory = new CalculatorFactory();
  }
  
  @Test
  // Test 149
  // Testing RevPolishCalc is returned when "postfix" is passed in
  void testGUIarg() {
    assertEquals(new RevPolishCalc().getClass(), calcFactory.create("postfix").getClass());
  }

}
