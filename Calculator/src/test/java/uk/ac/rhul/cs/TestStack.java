package uk.ac.rhul.cs;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {

  private Stack stack;

  @BeforeEach
  void setUp() {
    stack = new Stack();
  }

  @Test
  // Test 30
  // Testing size is 0 when stack is constructed
  // Solution: made size = 0 in constructor
  void testSizeEmpty() {
    assertEquals(stack.size(), 0);
  }

  @Test
  // Test 28
  // Testing push adds an item
  // Test 32
  // Testing size changes - Solution: made size increase
  // Test 35
  // Testing random amount of pushes - Solution: using ArrayList
  // Test 36
  // Testing random entries in pushes
  void testPushingItems() {
    String itemsString = Randomizer.pushRandomItems(stack, -1);
    int stackSize = itemsString.split("\n").length - 1;
    assertEquals(stackSize, stack.size());
    Entry randomEntry = Randomizer.newRandomEntry();
    stack.push(randomEntry);
    assertEquals(itemsString + randomEntry.toString() + "\n", stack.toString());
    assertEquals(stackSize + 1, stack.size());
  }

  @Test
  // Test 29
  // Testing pop removes the correct item
  // Test 33
  // Testing size changes - Solution: decreased size
  // Test 37
  // Testing emptyStack - Solution: check if size is 0
  // Test 39
  // Testing size goes back to 0 when there are no items
  void testPoppingItems() {
    assertThrows(EmptyStack.class, () -> {
      stack.pop();
    });
    final String itemsString = Randomizer.pushRandomItems(stack, 3);
    stack.push(Randomizer.newRandomEntry());
    assertEquals(stack.size(), 4);
    assertDoesNotThrow(() -> stack.pop());
    assertEquals(stack.size(), 3);
    assertEquals(itemsString, stack.toString());
    for (int itemsLeft = 3; itemsLeft > 0; itemsLeft--) {
      assertDoesNotThrow(() -> stack.pop());
      assertEquals(stack.size(), itemsLeft - 1);
    }
    assertThrows(EmptyStack.class, () -> {
      stack.pop();
    });
  }

  @Test
  // Test 31
  // Testing top shows last item
  // Test 34
  // Testing size does not change with random number of entries
  // Test 38
  // Testing emptyStack & message - Solution: check if size is 0
  void testTop() {
    EmptyStack exception = assertThrows(EmptyStack.class, () -> {
      stack.top();
    });
    assertEquals(exception.getMessage(), "The stack is empty");
    for (int numEntries = 0; numEntries < new Random().nextInt(10000) + 1; numEntries++) {
      Entry randomEntry = Randomizer.newRandomEntry();
      stack.push(randomEntry);
      assertEquals(stack.size(), numEntries + 1);
      assertDoesNotThrow(() -> assertEquals(randomEntry, stack.top()));
      assertEquals(stack.size(), numEntries + 1);
    }
  }

  @Test
  // Test 27
  // testing toString holds all entries
  // Solution: loop through entries and add them to returned string
  // Test 40
  // Testing empty stack message - check if size is 0
  void testToString() {
    assertEquals(stack.toString(), "The stack is currently empty");
    String itemsString = Randomizer.pushRandomItems(stack, -1);
    assertEquals(stack.toString(), itemsString);
  }

  @Test
  // Test 46
  // Testing that 100 items can be pushed and will be popped in order
  // Test 47
  // Testing top before popping next item
  void test100Items() {
    assertDoesNotThrow(() -> hundredItemTest(0));
  }

  private void hundredItemTest(int curr) throws EmptyStack {
    Entry randomEntry = Randomizer.newRandomEntry();
    stack.push(randomEntry);
    if (curr < 100) {
      hundredItemTest(curr + 1);
    }
    assertEquals(stack.top(), randomEntry);
    assertEquals(stack.pop(), randomEntry);
  }

  @Test
  // Test 49
  // push 10, pop 3, check top and pop are correct
  // Test 51
  // Checking size is correct
  void testCorrectMiddleItem() {
    Randomizer.pushRandomItems(stack, 6);
    assertEquals(stack.size(), 6);
    Entry randomEntry = Randomizer.newRandomEntry();
    stack.push(randomEntry);
    assertEquals(stack.size(), 7);
    Randomizer.pushRandomItems(stack, 3);
    assertEquals(stack.size(), 10);
    assertDoesNotThrow(() -> stack.pop());
    assertDoesNotThrow(() -> stack.pop());
    assertDoesNotThrow(() -> stack.pop());
    assertEquals(stack.size(), 7);
    assertDoesNotThrow(() -> assertEquals(stack.top(), randomEntry));
    assertDoesNotThrow(() -> assertEquals(stack.pop(), randomEntry));
    assertEquals(stack.size(), 6);
  }

}
