package application.stack;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import application.Randomizer;
import application.stack.assembly.Symbol;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestOpStack {

  private OpStack opStack;
  private Random random;

  @BeforeEach
  void setUp() {
    opStack = new OpStack();
    random = new Random();
  }

  @Test
  // Test 98
  // Testing size is 0 when stack is constructed
  // Solution: made OpStack.size() delegate responsibility to Stack.size()
  void testSizeEmpty() {
    assertEquals(opStack.size(), 0);
  }

  @Test
  // Test 102
  // Testing OpStack.push adds an item (through size being 1)
  // Solution: made push delegate to Stack.push() with a new Entry with the symbol passed in
  // Test 106
  // Testing OpStack.push adds an item (through OpStack.top)
  void testPushingItems() {
    Symbol randomSymbol = Randomizer.generateRandomSymbol();
    opStack.push(randomSymbol);
    assertEquals(opStack.size(), 1);
    assertDoesNotThrow(() -> assertEquals(opStack.top(), randomSymbol));
  }

  @Test
  // Test 103
  // Testing OpStack.pop removes the correct item
  // Solution: made OpStack.pop() delegate responsibility to Stack.pop()
  void testPoppingItems() {
    opStack.push(Symbol.PLUS);
    assertDoesNotThrow(() -> assertEquals(opStack.pop(), Symbol.PLUS));
  }

  @Test
  // Test 104
  // Testing OpStack.top shows the correct last item
  // Solution: made OpStack.top() delegate responsibility to Stack.top()
  void testTop() {
    Symbol randomSymbol = Randomizer.generateRandomSymbol();
    opStack.push(randomSymbol);
    assertDoesNotThrow(() -> assertEquals(randomSymbol, opStack.top()));
  }

  @Test
  // Test 105
  // Testing OpStack.toString returns an appropriate message when OpStack is empty
  // Solution: Implemented toString
  void testToString() {
    assertEquals(opStack.toString(), "The stack is currently empty");
  }

}
