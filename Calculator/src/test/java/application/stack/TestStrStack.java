package application.stack;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import application.Randomizer;

public class TestStrStack {

  private StrStack strStack;
  private Random random;

  @BeforeEach
  void setUp() {
    strStack = new StrStack();
    random = new Random();
  }

  @Test
  // Test 116
  // Testing size is 0 when stack is constructed
  // Solution: made StrStack.size() delegate responsibility to Stack.size()
  void testSizeEmpty() {
    assertEquals(strStack.size(), 0);
  }

  @Test
  // Test 117
  // Testing StrStack.push adds an item (through size being 1)
  // Solution: made push delegate to Stack.push() with a new Entry with the string passed in
  void testPushingItems() {
    strStack.push("test 117");
    assertEquals(strStack.size(), 1);
  }

  @Test
  // Test 118
  // Testing StrStack.pop removes the correct item
  // Solution: made StrStack.pop() delegate responsibility to Stack.pop()
  void testPoppingItems() {
    strStack.push("test 118");
    assertDoesNotThrow(() -> assertEquals(strStack.pop(), "test 118"));
  }

  @Test
  // Test 119
  // Testing StrStack.top shows the correct last item
  // Solution: made StrStack.top() delegate responsibility to Stack.top()
  void testTop() {
    String randomString = Randomizer.generateRandomString();
    strStack.push(randomString);
    assertDoesNotThrow(() -> assertEquals(randomString, strStack.top()));
  }

  @Test
  // Test 120
  // Testing StrStack.toString returns an appropriate message when StrStack is empty
  // Solution: Implemented toString
  void testToString() {
    assertEquals(strStack.toString(), "The stack is currently empty");
  }

}
