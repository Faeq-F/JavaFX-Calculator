package application.stack;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import application.Randomizer;
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
  
  @Test // Test 54
  void testPoppingItems() {
    numStack.push(9);
    assertDoesNotThrow(() ->  assertEquals(numStack.pop(), 9));
  }
  
  @Test // Test 55
  void testTop() {
    numStack.push(10);
    assertDoesNotThrow(() -> assertEquals(numStack.top(), 10));
  }
  
  @Test // Test 56
  void testToString() {
    assertEquals(numStack.toString(), "The stack is currently empty");
  }

}
