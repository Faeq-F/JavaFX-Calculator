package application.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  // Test 117
  // Testing StrStack.push adds an item (through size being 1)
  // Solution: made push delegate to Stack.push() with a new Entry with the string passed in
  void testPushingItems() {
    strStack.push("test 117");
    assertEquals(strStack.size(), 1);
  }

}
