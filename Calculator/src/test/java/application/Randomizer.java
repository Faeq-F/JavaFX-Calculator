package application;

import application.stack.NumStack;
import application.stack.OpStack;
import application.stack.Stack;
import application.stack.StrStack;
import application.stack.assembly.Entry;
import application.stack.assembly.Symbol;
import java.util.Random;

/**
 * Contains methods to randomise anything needed by tests; entries, strings, symbols, etc.
 * 
 * @author zlac318
 */
public final class Randomizer {

  private static Random random = new Random();
  
  private static int parseGivenLimit(int givenLimit) {
    if (givenLimit == -1) {
      return random.nextInt(10000) + 1; // +1 ensures at least 1 push is made
    } else {
      return givenLimit;
    }
  }

  /**
   * Pushes a random number of random entries to the given stack, if a limit is not given.
   * 
   * @param stack The stack to push entries to.
   * @param givenLimit The number of entries to push. If -1, a random amount of entries is
   *        pushed.
   * @return Represents what a stack's toString method should return if only the entries
   *         pushed in this method were in it.
   */
  public static String pushRandomItems(Stack stack, int givenLimit) {
    int limit = parseGivenLimit(givenLimit);
    String output = "The stack currently contains the following entries:\n";
    for (int number = 0; number < limit; number++) {
      Entry randomEntry = Randomizer.newRandomEntry();
      stack.push(randomEntry);
      output += randomEntry.toString() + "\n";
    }
    return output;
  }
  
  /**
   * Pushes a random number of random floats to the given NumStack, if a limit is not given.
   * 
   * @param numstack The stack to push floats to. 
   * @param givenLimit number of floats to push. If -1, a random amount of floats is pushed.
   * @return Represents what a stack's toString method should return if only the floats
   *         pushed in this method were in it.
   */
  public static String pushRandomFloats(NumStack numstack, int givenLimit) {
    int limit = parseGivenLimit(givenLimit);
    String output = "The NumStack currently contains the following floats:\n";
    for (int number = 0; number < limit; number++) {
      float randomFloat = random.nextFloat();
      numstack.push(randomFloat);
      output += randomFloat + "\n";
    }
    return output;
  }
  
  /**
   * Pushes a random number of random Symbols to the given OpStack, if a limit is not given.
   * 
   * @param opStack The stack to push Symbols to. 
   * @param givenLimit number of Symbols to push. If -1, a random amount of Symbols is pushed.
   * @return Represents what a stack's toString method should return if only the Symbols
   *         pushed in this method were in it.
   */
  public static String pushRandomSymbols(OpStack opStack, int givenLimit) {
    int limit = parseGivenLimit(givenLimit);
    String output = "The OpStack currently contains the following symbols:\n";
    for (int number = 0; number < limit; number++) {
      Symbol randomSymbol = Randomizer.generateRandomSymbol();
      opStack.push(randomSymbol);
      output += randomSymbol + "\n";
    }
    return output;
  }
  
  /**
   * Pushes a random number of random Strings to the given StrStack, if a limit is not given.
   * 
   * @param strStack The stack to push Strings to. 
   * @param givenLimit number of Strings to push. If -1, a random amount of Strings is pushed.
   * @return Represents what a stack's toString method should return if only the Strings
   *         pushed in this method were in it.
   */
  public static String pushRandomStrings(StrStack strStack, int givenLimit) {
    int limit = parseGivenLimit(givenLimit);
    String output = "The StrStack currently contains the following strings:\n";
    for (int number = 0; number < limit; number++) {
      String randomString = Randomizer.generateRandomString();
      strStack.push(randomString);
      output += randomString + "\n";
    }
    return output;
  }

  /**
   * Creates a new random entry holding either a random String, float or Symbol.
   * 
   * @return The new random Entry.
   */
  public static Entry newRandomEntry() {
    switch (random.nextInt(3)) {
      case 0:
        return new Entry(generateRandomString());
      case 1:
        return new Entry(random.nextFloat());
      default:
        return new Entry(generateRandomSymbol());
    }
  }

  /**
   * Generates a random string (maximum length 20, minimum length 0), from the letters of the
   * English alphabet.
   * 
   * @return The random string generated.
   */
  public static String generateRandomString() {
    int length = random.nextInt(21);
    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] text = new char[length];
    for (int textPos = 0; textPos < length; textPos++) {
      text[textPos] = characters.charAt(random.nextInt(characters.length()));
    }
    return new String(text);
  }

  /**
   * Generates a random Symbol, but not Symbol.INVALID.
   * 
   * @return The random symbol generated.
   */
  public static Symbol generateRandomSymbol() {
    return Symbol.values()[random.nextInt(6)];
  }

}
