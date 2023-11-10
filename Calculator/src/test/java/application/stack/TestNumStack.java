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

}
