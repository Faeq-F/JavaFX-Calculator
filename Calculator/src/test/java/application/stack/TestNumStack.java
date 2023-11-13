package application.stack;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
  
  @Test // Test 53
  void testPushingItems() {
    numStack.push(7);
    assertEquals(numStack.size(), 1);
  }
  
  @Test // Test 54
  void testPoppingItems() {
    numStack.push(9);
    assertDoesNotThrow(() ->  assertEquals(numStack.pop(), 9));
  }

}
