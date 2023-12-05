package application.stack;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.Randomizer;
import application.stack.assembly.EmptyStack;
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
  // Test 107
  // Testing OpStack.size with a random amount of random symbols
  void testSize() {
    String itemsString = Randomizer.pushRandomSymbols(opStack, -1);
    int stackSize = itemsString.split("\n").length - 1;
    assertEquals(stackSize, opStack.size());
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
  // Test 109
  // Testing OpStack.pop rightly throws EmptyStack
  // Test 113
  // Testing OpStack.pop removes the correct (random) item
  void testPoppingItems() {
    assertThrows(EmptyStack.class, () -> {
      opStack.pop();
    });
    opStack.push(Symbol.PLUS);
    assertDoesNotThrow(() -> assertEquals(opStack.pop(), Symbol.PLUS));
    Symbol randomSymbol = Randomizer.generateRandomSymbol();
    opStack.push(randomSymbol);
    assertDoesNotThrow(() -> assertEquals(opStack.pop(), randomSymbol));
  }

  @Test
  // Test 111
  // Testing size changes with OpStack.pop
  // Test 112
  // Testing OpStack.pop removes the correct items (through toString)
  // Test 114
  // Testing size goes back to 0 with OpStack.pop
  void testSizeWithPop() {
    final String itemsString = Randomizer.pushRandomSymbols(opStack, 3);
    opStack.push(Randomizer.generateRandomSymbol());
    assertEquals(opStack.size(), 4);
    assertDoesNotThrow(() -> opStack.pop());
    assertEquals(opStack.size(), 3);
    assertEquals(itemsString, opStack.toString()); // did pop remove the correct items?
    for (int itemsLeft = 3; itemsLeft > 0; itemsLeft--) {
      assertDoesNotThrow(() -> opStack.pop());
      assertEquals(opStack.size(), itemsLeft - 1);
    }
    assertThrows(EmptyStack.class, () -> {
      opStack.pop();
    });
  }

  @Test
  // Test 104
  // Testing OpStack.top shows the correct last item
  // Solution: made OpStack.top() delegate responsibility to Stack.top()
  // Test 110
  // Testing OpStack.top rightly throws EmptyStack
  // Test 115
  // Tested OpStack.top does not change size with a random amount of random symbols
  void testTop() {
    assertThrows(EmptyStack.class, () -> {
      opStack.top();
    });
    for (int numEntries = 0; numEntries < random.nextInt(10000) + 1; numEntries++) {
      Symbol randomSymbol = Randomizer.generateRandomSymbol();
      opStack.push(randomSymbol);
      assertEquals(opStack.size(), numEntries + 1);
      assertDoesNotThrow(() -> assertEquals(randomSymbol, opStack.top()));
      assertEquals(opStack.size(), numEntries + 1);
    }
  }

  @Test
  // Test 105
  // Testing OpStack.toString returns an appropriate message when OpStack is empty
  // Solution: Implemented toString
  // Test 108
  // Testing OpStack.toString with a random amount of random symbols
  // Solution: modified string from Stack.toString to show symbols
  void testToString() {
    assertEquals(opStack.toString(), "The OpStack is currently empty");
    String itemsString = Randomizer.pushRandomSymbols(opStack, -1);
    assertEquals(itemsString, opStack.toString());
  }

}
