package application.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestOpStack {
  
  private OpStack numStack;
  private Random random;

  @BeforeEach
  void setUp() {
    numStack = new OpStack();
    random = new Random();
  }

  @Test
  // Test 98
  // Testing size is 0 when stack is constructed
  // Solution: made NumStack.size() delegate responsibility to Stack.size()
  void testSizeEmpty() {
    assertEquals(numStack.size(), 0);
  }

}
