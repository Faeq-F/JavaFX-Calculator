package application.stack;

import application.stack.assembly.Entry;

/**
 * A stack data-structure holding strings. The usual methods, push, pop and top, are provided. The
 * toString method will display all strings held in the stack.
 * 
 * @author zlac318
 */
public class StrStack {

  // This class will be a facade of the Stack class
  private Stack strStack;

  /**
   * Creates an empty OpStack.
   */
  public StrStack() {
    strStack = new Stack();
  }

  /**
   * Pushes a string onto the top of this stack.
   * 
   * @param str The string to be pushed onto this stack.
   */
  public void push(String str) {
    strStack.push(new Entry(str));
  }

  public int size() {
    return strStack.size();
  }

}
