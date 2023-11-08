package application.stack.assembly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TestType {

  private static final Type typeString = Type.STRING;
  private static final Type typeSymbol = Type.SYMBOL;
  private static final Type typeNumber = Type.NUMBER;
  private static final Type typeInvalid = Type.INVALID;

  @Test
  // Test 1
  // Testing all combinations for Equals
  // Test 2
  // Testing all combinations for NotEquals
  // Test 41
  // Merging Equals & NotEquals into one test
  void testEquality() {
    Type[] types = {typeString, typeSymbol, typeNumber, typeInvalid};
    Type[] otherTypes = {Type.STRING, Type.SYMBOL, Type.NUMBER, Type.INVALID};
    for (int index = 0; index < types.length; index++) {
      for (int otherIndex = 0; otherIndex < otherTypes.length; otherIndex++) {
        if (index == otherIndex) {
          assertEquals(types[index], otherTypes[otherIndex]);
        } else {
          assertNotEquals(types[index], otherTypes[otherIndex]);
        }
      }
    }
  }

  @Test
  // Test 3
  // Testing toString method - Solution: added toString method that returns this.name()
  // Test 4
  // Testing with descriptions - Solution: created constructor & added description to toString
  // Test 5
  // Testing all possible values
  void testToString() {
    assertEquals(typeString.toString(), "STRING; The entry holds a string");
    assertEquals(typeSymbol.toString(), "SYMBOL; The entry holds a mathematical operator");
    assertEquals(typeNumber.toString(), "NUMBER; The entry holds a floating point value");
    assertEquals(typeInvalid.toString(), "INVALID; The entry was initialized incorrectly");
  }

}
