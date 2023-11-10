package application.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {

  private NumStack numStack;

  @BeforeEach
  void setUp() {
    numStack = new NumStack();
  }
  
  @Test
  // Test 52
  // Testing size is 0 when stack is constructed
  // Solution: made NumStack.size() delegate responsibility to Stack.size() 
  void testSizeEmpty() {
    assertEquals(numStack.size(), 0);
  } 
  
  @Test
  // Test 53
  // Testing push adds an item (through size being 1)
  // Solution: made push delegate to Stack.push() with a new Entry with the float passed in 
  void testPushingItems() {
    numStack.push(7);
    assertEquals(numStack.size(), 1);
  }

}
