package application.stack;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.Randomizer;
import application.stack.assembly.EmptyStack;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
  // Test 122
  // Testing StrStack.size with a random amount of random strings
  void testSize() {
    String itemsString = Randomizer.pushRandomStrings(strStack, -1);
    int stackSize = itemsString.split("\n").length - 1;
    assertEquals(stackSize, strStack.size());
  }

  @Test
  // Test 117
  // Testing StrStack.push adds an item (through size being 1)
  // Solution: made push delegate to Stack.push() with a new Entry with the string passed in
  // Test 121
  // Testing StrStack.push adds an item (through StrStack.top)
  void testPushingItems() {
    String randomString = Randomizer.generateRandomString();
    strStack.push(randomString);
    assertEquals(strStack.size(), 1);
    assertDoesNotThrow(() -> assertEquals(strStack.top(), randomString));
  }

  @Test
  // Test 118
  // Testing StrStack.pop removes the correct item
  // Solution: made StrStack.pop() delegate responsibility to Stack.pop()
  // Test 124
  // Testing StrStack.pop rightly throws EmptyStack
  // Test 128
  // Testing StrStack.pop removes the correct (random) item.
  void testPoppingItems() {
    assertThrows(EmptyStack.class, () -> {
      strStack.pop();
    });
    strStack.push("test 118");
    assertDoesNotThrow(() -> assertEquals(strStack.pop(), "test 118"));
    String randomString = Randomizer.generateRandomString();
    strStack.push(randomString);
    assertDoesNotThrow(() -> assertEquals(strStack.pop(), randomString));
  }

  @Test
  // Test 126
  // Testing size changes with StrStack.pop
  // Test 127
  // Testing StrStack.pop removes the correct items (through toString)
  // Test 129
  // Testing size goes back to 0 with StrStack.pop
  void testSizeWithPop() {
    final String itemsString = Randomizer.pushRandomStrings(strStack, 3);
    strStack.push(Randomizer.generateRandomString());
    assertEquals(strStack.size(), 4);
    assertDoesNotThrow(() -> strStack.pop());
    assertEquals(strStack.size(), 3);
    assertEquals(itemsString, strStack.toString()); // did pop remove the correct items?
    for (int itemsLeft = 3; itemsLeft > 0; itemsLeft--) {
      assertDoesNotThrow(() -> strStack.pop());
      assertEquals(strStack.size(), itemsLeft - 1);
    }
    assertThrows(EmptyStack.class, () -> {
      strStack.pop();
    });
  }

  @Test
  // Test 119
  // Testing StrStack.top shows the correct last item
  // Solution: made StrStack.top() delegate responsibility to Stack.top()
  // Test 125
  // Testing StrStack.top rightly throws EmptyStack
  void testTop() {
    assertThrows(EmptyStack.class, () -> {
      strStack.top();
    });
    String randomString = Randomizer.generateRandomString();
    strStack.push(randomString);
    assertDoesNotThrow(() -> assertEquals(randomString, strStack.top()));
  }

  @Test
  // Test 120
  // Testing StrStack.toString returns an appropriate message when StrStack is empty
  // Solution: Implemented toString
  // Test 123
  // Testing StrStack.toString with a random amount of random strings
  // Solution: modified string from Stack.toString to show strings
  void testToString() {
    assertEquals(strStack.toString(), "The StrStack is currently empty");
    String itemsString = Randomizer.pushRandomStrings(strStack, -1);
    assertEquals(itemsString, strStack.toString());
  }

}
