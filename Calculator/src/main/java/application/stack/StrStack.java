package application.stack;

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

  public int size() {
    return strStack.size();
  }

}
