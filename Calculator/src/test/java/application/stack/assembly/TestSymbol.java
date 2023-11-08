package application.stack.assembly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TestSymbol {

  private static final Symbol leftBracket = Symbol.LEFT_BRACKET;
  private static final Symbol rightBracket = Symbol.RIGHT_BRACKET;
  private static final Symbol time = Symbol.TIME;
  private static final Symbol divide = Symbol.DIVIDE;
  private static final Symbol minus = Symbol.MINUS;
  private static final Symbol plus = Symbol.PLUS;
  private static final Symbol invalid = Symbol.INVALID;

  @Test
  // Test 6
  // Testing all possible values for Equals
  // Test 7
  // Testing all combinations for NotEquals
  // Test 42
  // Merging Equals & NotEquals into one test
  void testEquality() {
    Symbol[] symbols = {leftBracket, rightBracket, time, divide, minus, plus, invalid};
    Symbol[] otherSymbols = {Symbol.LEFT_BRACKET, Symbol.RIGHT_BRACKET, Symbol.TIME, Symbol.DIVIDE,
        Symbol.MINUS, Symbol.PLUS, Symbol.INVALID};
    for (int index = 0; index < symbols.length; index++) {
      for (int otherIndex = 0; otherIndex < otherSymbols.length; otherIndex++) {
        if (index == otherIndex) {
          assertEquals(symbols[index], otherSymbols[otherIndex]);
        } else {
          assertNotEquals(symbols[index], otherSymbols[otherIndex]);
        }
      }
    }
  }

  @Test
  // Test 8
  // Testing toString method - Solution: added toString method that returns this.name()
  // Test 9
  // Testing with descriptions - Solution: created constructor & added description to toString
  // Test 10
  // Testing all possible values
  void testToString() {
    assertEquals(leftBracket.toString(), "LEFT_BRACKET; The left parenthese, i.e. (");
    assertEquals(rightBracket.toString(), "RIGHT_BRACKET; The right paranthese, i.e. )");
    assertEquals(time.toString(), "TIME; The multiplication operator, i.e. *");
    assertEquals(divide.toString(), "DIVIDE; The division operator, i.e. /");
    assertEquals(minus.toString(), "MINUS; The minus operator, i.e. -");
    assertEquals(plus.toString(), "PLUS; The addition operator, i.e. +");
    assertEquals(invalid.toString(), "INVALID; The symbol provided is not useable");
  }

}
