package uk.ac.rhul.cs;

import java.util.Random;

/**
 * Contains methods to randomise anything needed by tests; entries, strings, symbols, etc.
 */
public final class Randomizer {

  private static Random random = new Random();

  /**
   * Pushes a random number of random entries to the given stack, if a limit is not given.
   * 
   * @param stack to push entries to.
   * @param givenLimit number of entries to push. If -1, a random amount of entries is
   *        pushed.
   * @return a string representing what a stack's toString method should return if only the entries
   *         pushed in this method were in it.
   */
  static String pushRandomItems(Stack stack, int givenLimit) {
    int limit;
    if (givenLimit == -1) {
      limit = random.nextInt(10000) + 1; // +1 ensures at least 1 push is made
    } else {
      limit = givenLimit;
    }
    String output = "The stack currently contains the following entries:\n";
    for (int number = 0; number < limit; number++) {
      Entry randomEntry = Randomizer.newRandomEntry();
      stack.push(randomEntry);
      output += randomEntry.toString() + "\n";
    }
    return output;
  }

  /**
   * Creates a new random entry with a random String, float or Symbol in it.
   * 
   * @return the new random Entry
   */
  static Entry newRandomEntry() {
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
   * alphabet.
   * 
   * @return the random string generated
   */
  static String generateRandomString() {
    int length = random.nextInt(21);
    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] text = new char[length];
    for (int textPos = 0; textPos < length; textPos++) {
      text[textPos] = characters.charAt(random.nextInt(characters.length()));
    }
    return new String(text);
  }

  /**
   * Generates a random Symbol but not Symbol.INVALID.
   * 
   * @return the random symbol generated
   */
  static Symbol generateRandomSymbol() {
    return Symbol.values()[random.nextInt(6)];
  }

}
