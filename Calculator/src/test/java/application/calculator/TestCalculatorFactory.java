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
  void testPostfixArg() {
    assertEquals(new RevPolishCalc().getClass(), calcFactory.create("postfix").getClass());
  }
  
  @Test
  // Test 150
  // Testing StandardCalc is returned when "infix" is passed in
  void testInfixArg() {
    assertEquals(new StandardCalc().getClass(), calcFactory.create("infix").getClass());
  }
  
  @Test
  // Test 151
  // Testing CalcModel is returned when "" is passed in
  void testNoArg() {
    assertEquals(new CalcModel().getClass(), calcFactory.create("").getClass());
  }

}
