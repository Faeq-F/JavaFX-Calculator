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
  
  @Test // Test 52
  void testSizeEmpty() {
    assertEquals(numStack.size(), 0);
  } 
  
  @Test // Test 58
  void testSize() {
    String itemsString = Randomizer.pushRandomFloats(numStack, -1);
    int stackSize = itemsString.split("\n").length - 1;
    assertEquals(stackSize, numStack.size());
  }
  
  @Test // Test 53, 57
  void testPushingItems() {
    float randomFloat = random.nextFloat();
    numStack.push(randomFloat);
    assertEquals(numStack.size(), 1);
    assertDoesNotThrow(() -> assertEquals(numStack.top(), randomFloat));
  }
  
  @Test // Test 54, 60
  void testPoppingItems() {
    assertThrows(EmptyStack.class, () -> {
      numStack.pop();
    });
    numStack.push(9);
    assertDoesNotThrow(() ->  assertEquals(numStack.pop(), 9));
  }
  
  @Test // Test 62, 63
  void testSizeWithPop() {
    final String itemsString = Randomizer.pushRandomFloats(numStack, 3);
    numStack.push(random.nextFloat());
    assertEquals(numStack.size(), 4);
    assertDoesNotThrow(() -> numStack.pop());
    assertEquals(numStack.size(), 3);
    assertEquals(itemsString, numStack.toString()); //did pop remove the correct items?
  }
  
  @Test // Test 55, 61
  void testTop() {
    assertThrows(EmptyStack.class, () -> {
      numStack.top();
    });
    numStack.push(10);
    assertDoesNotThrow(() -> assertEquals(numStack.top(), 10));
  }
  
  @Test // Test 56, 59
  void testToString() {
    assertEquals("The NumStack is currently empty", numStack.toString());
    String itemsString = Randomizer.pushRandomFloats(numStack, -1);
    assertEquals(itemsString, numStack.toString());
  }

}
