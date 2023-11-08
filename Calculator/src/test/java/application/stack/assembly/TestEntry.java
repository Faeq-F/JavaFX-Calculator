package application.stack.assembly;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import application.Randomizer;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEntry {

  private static Entry stringEntry;
  private static Entry numberEntry;
  private static Entry symbolEntry;

  private static Random random;

  @BeforeEach
  void setUp() {
    random = new Random();
    stringEntry = new Entry(Randomizer.generateRandomString());
    numberEntry = new Entry(random.nextFloat());
    symbolEntry = new Entry(Randomizer.generateRandomSymbol());
  }

  @Test
  // Test 11
  // Testing auto-generated hash-code and equals methods
  // Test 12
  // Testing with random values
  // Test 13
  // Testing invalid
  // Solution: made entry's type invalid if instantiated with Symbol.INVALID
  // Test 14
  // Testing all symbols
  // Test 17
  // Testing with modified equals method (to account for type of entry)
  // Solution: made other object's fields be accessed through the getter methods
  // and check if the entries are the same type first
  void testEqual() {
    String randomString = Randomizer.generateRandomString();
    stringEntry = new Entry(randomString);

    assertEquals(stringEntry.hashCode(), new Entry(randomString).hashCode());
    assertTrue(stringEntry.equals((Object) new Entry(randomString)));
    assertEquals(stringEntry, new Entry(randomString));

    float randomFloat = random.nextFloat();
    numberEntry = new Entry(randomFloat);

    assertEquals(numberEntry.hashCode(), new Entry(randomFloat).hashCode());
    assertEquals(numberEntry, new Entry(randomFloat));

    for (Symbol symbol : Symbol.values()) {
      try {
        assertEquals(new Entry(symbol).hashCode(), new Entry(symbol).hashCode());
        assertEquals(new Entry(symbol), new Entry(symbol));
      } catch (IllegalArgumentException e) {
        assertEquals(e.getMessage(), "Invalid symbol used to instantiate Entry");
      }
    }
  }

  @Test
  // Test 15
  // Testing multiple different entries with random values
  // Test 16
  // Testing null & some wrong types
  void testNotEqual() {
    String randomString = Randomizer.generateRandomString();
    assertNotEquals(new Entry(randomString), new Entry(randomString + "a"));
    assertNotEquals(new Entry(random.nextFloat()), new Entry(random.nextFloat() + 0.1f));
    assertNotEquals(new Entry(Symbol.LEFT_BRACKET), new Entry(Symbol.RIGHT_BRACKET));
    assertNotEquals(new Entry(Randomizer.generateRandomSymbol()), new Entry(randomString));

    assertNotEquals(stringEntry, null);
    assertNotEquals(numberEntry, null);
    assertNotEquals(symbolEntry, null);
    assertNotEquals(stringEntry, new Object());
    assertNotEquals(numberEntry, random.nextInt());
    assertNotEquals(symbolEntry, randomString);
  }

  @Test
  // Test 18
  // Testing all types
  // Test 23
  // Testing not equals
  // Test 43
  // Test invalid entry
  // (now removed as an exception is to be thrown for invalid entries)
  void testGetType() {
    assertEquals(stringEntry.getType(), Type.STRING);
    assertEquals(numberEntry.getType(), Type.NUMBER);
    assertEquals(symbolEntry.getType(), Type.SYMBOL);

    assertNotEquals(stringEntry.getType(), Type.INVALID);
    assertNotEquals(stringEntry.getType(), Type.NUMBER);
    assertNotEquals(stringEntry.getType(), Type.SYMBOL);
    assertNotEquals(numberEntry.getType(), Type.INVALID);
    assertNotEquals(numberEntry.getType(), Type.STRING);
    assertNotEquals(numberEntry.getType(), Type.SYMBOL);
    assertNotEquals(symbolEntry.getType(), Type.INVALID);
    assertNotEquals(symbolEntry.getType(), Type.NUMBER);
    assertNotEquals(symbolEntry.getType(), Type.STRING);
  }

  @Test
  // Test 19
  // Testing the correct values are given with randomness
  // Test 21
  // Asserting that no exceptions are thrown
  void testGetCorrectData() throws BadType {
    String randomString = Randomizer.generateRandomString();
    assertDoesNotThrow(() -> assertEquals(new Entry(randomString).getString(), randomString));
    float randomFloat = random.nextFloat();
    assertDoesNotThrow(() -> assertEquals(new Entry(randomFloat).getValue(), randomFloat));
    Symbol randomSymbol = Randomizer.generateRandomSymbol();
    assertDoesNotThrow(() -> assertEquals(new Entry(randomSymbol).getSymbol(), randomSymbol));
  }

  @Test
  // Test 45
  // Testing boundary conditions for float constructor
  void testFloatBoundaries() {
    assertDoesNotThrow(() -> new Entry(Float.MAX_VALUE));
    assertDoesNotThrow(() -> new Entry(-Float.MAX_VALUE));
  }

  @SuppressWarnings("null")
  @Test
  // Test 48
  // Testing null passed as argument to Entry constructor
  // Solution throw exception if null in constructor
  // Test 50
  // Test exception message
  void testNullConstructor() {
    String nullStr = null;
    NullPointerException exception =
        assertThrows(NullPointerException.class, () -> new Entry(nullStr));
    assertEquals(exception.getMessage(), "null String passed to Entry constructor");
    Symbol nullSymbol = null;
    exception = assertThrows(NullPointerException.class, () -> new Entry(nullSymbol));
    assertEquals(exception.getMessage(), "null Symbol passed to Entry constructor");
    assertThrows(NullPointerException.class, () -> new Entry((Float) null));
  }

  @Test
  // Test 20
  // Testing that BadType is thrown for all possible types
  // Solution: check if the type of entry is correct
  // Test 22
  // Checking exception message - Solution: added message to exception
  // Test 44
  // Replacing duplicated code with for loop
  void testGetIncorrectData() {
    Entry[] throwsOnGetString = {numberEntry, symbolEntry};
    Entry[] throwsOnGetValue = {stringEntry, symbolEntry};
    Entry[] throwsOnGetSymbol = {stringEntry, numberEntry};
    Entry[][] throwingEntries = {throwsOnGetString, throwsOnGetValue, throwsOnGetSymbol};

    BadType exception;
    for (int throwsArr = 0; throwsArr < 3; throwsArr++) {
      for (Entry entry : throwingEntries[throwsArr]) {
        switch (throwsArr) {
          case 0:
            exception = assertThrows(BadType.class, () -> {
              entry.getString();
            });
            assertEquals(exception.getMessage(),
                "Unable to get value. STRING was asked for, but Entry held "
                    + entry.getType().name());
            break;
          case 1:
            exception = assertThrows(BadType.class, () -> {
              entry.getValue();
            });
            assertEquals(exception.getMessage(),
                "Unable to get value. NUMBER was asked for, but Entry held "
                    + entry.getType().name());
            break;
          default:
            exception = assertThrows(BadType.class, () -> {
              entry.getSymbol();
            });
            assertEquals(exception.getMessage(),
                "Unable to get value. SYMBOL was asked for, but Entry held "
                    + entry.getType().name());
            break;
        }
      }
    }
  }

  @Test
  // Test 24
  // Testing toString - Solution: added toString to return the right value
  // Test 25
  // Testing all possible types with randomness
  // Test 26
  // Testing with extra info in toString - Solution: added type to string returned
  void testToString() {
    String randomString = Randomizer.generateRandomString();
    assertEquals(new Entry(randomString).toString(),
        "Entry holding type STRING has value: " + randomString);
    float randomFloat = random.nextFloat();
    assertEquals(new Entry(randomFloat).toString(),
        "Entry holding type NUMBER has value: " + randomFloat);
    Symbol randomSymbol = Randomizer.generateRandomSymbol();
    assertEquals(new Entry(randomSymbol).toString(),
        "Entry holding type SYMBOL has value: " + randomSymbol);
  }

}
