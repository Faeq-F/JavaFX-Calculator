package application.stack;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.Randomizer;
import application.stack.assembly.EmptyStack;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {

  private NumStack numStack;
  private Random random;

  @BeforeEach
  void setUp() {
    numStack = new NumStack();
    random = new Random();
  }

  @Test
  // Test 52
  // Testing size is 0 when stack is constructed
  // Solution: made NumStack.size() delegate responsibility to Stack.size()
  void testSizeEmpty() {
    assertEquals(numStack.size(), 0);
  }

  @Test
  // Test 58
  // Testing NumStack.size with a random amount of random floats
  void testSize() {
    String itemsString = Randomizer.pushRandomFloats(numStack, -1);
    int stackSize = itemsString.split("\n").length - 1;
    assertEquals(stackSize, numStack.size());
  }

  @Test
  // Test 53
  // Testing NumStack.push adds an item (through size being 1)
  // Solution: made push delegate to Stack.push() with a new Entry with the float passed in
  // Test 57
  // Testing NumStack.push adds an item (through NumStack.top)
  // Solution: made NumStack.top() delegate responsibility to Stack.top()
  void testPushingItems() {
    float randomFloat = random.nextFloat();
    numStack.push(randomFloat);
    assertEquals(numStack.size(), 1);
    assertDoesNotThrow(() -> assertEquals(numStack.top(), randomFloat));
  }

  @Test
  // Test 54
  // Testing NumStack.pop removes the correct item
  // Solution: made NumStack.pop() delegate responsibility to Stack.pop()
  // Test 60
  // Testing NumStack.pop rightly throws EmptyStack.
  // Test 64
  // Testing NumStack.pop removes the correct (random) item.
  void testPoppingItems() {
    assertThrows(EmptyStack.class, () -> {
      numStack.pop();
    });
    float randomFloat = random.nextFloat();
    numStack.push(randomFloat);
    assertDoesNotThrow(() -> assertEquals(numStack.pop(), randomFloat));
  }

  @Test
  // Test 62
  // Testing size changes with NumStack.pop
  // Test 63
  // Testing NumStack.pop removes the correct items (through toString)
  // Test 65
  // Testing size goes back to 0 with NumStack.pop
  void testSizeWithPop() {
    final String itemsString = Randomizer.pushRandomFloats(numStack, 3);
    numStack.push(random.nextFloat());
    assertEquals(numStack.size(), 4);
    assertDoesNotThrow(() -> numStack.pop());
    assertEquals(numStack.size(), 3);
    assertEquals(itemsString, numStack.toString()); // did pop remove the correct items?
    for (int itemsLeft = 3; itemsLeft > 0; itemsLeft--) {
      assertDoesNotThrow(() -> numStack.pop());
      assertEquals(numStack.size(), itemsLeft - 1);
    }
    assertThrows(EmptyStack.class, () -> {
      numStack.pop();
    });
  }

  @Test
  // Test 55
  // Testing NumStack.top shows the last item.
  // Solution: made NumStack.top return 10 (as required - faked)
  // Test 61
  // Testing NumStack.top rightly throws EmptyStack
  // Test 66
  // Tested NumStack.top does not change size with a random amount of random floats
  void testTop() {
    assertThrows(EmptyStack.class, () -> {
      numStack.top();
    });
    for (int numEntries = 0; numEntries < new Random().nextInt(10000) + 1; numEntries++) {
      float randomFloat = random.nextFloat();
      numStack.push(randomFloat);
      assertEquals(numStack.size(), numEntries + 1);
      assertDoesNotThrow(() -> assertEquals(randomFloat, numStack.top()));
      assertEquals(numStack.size(), numEntries + 1);
    }
  }

  @Test
  // Test 56
  // Testing NumStack.toString returns an appropriate message when NumStack is empty.
  // Solution: implemented toString
  // Test 59
  // Testing NumStack.toString with a random amount of random floats
  // Solution: modified string from Stack.toString to show floats
  void testToString() {
    assertEquals("The NumStack is currently empty", numStack.toString());
    String itemsString = Randomizer.pushRandomFloats(numStack, -1);
    assertEquals(itemsString, numStack.toString());
  }

}
