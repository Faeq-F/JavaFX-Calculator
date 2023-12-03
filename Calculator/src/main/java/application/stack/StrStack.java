package application.stack;

import application.stack.assembly.BadType;
import application.stack.assembly.EmptyStack;
import application.stack.assembly.Entry;
import application.stack.assembly.Type;

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

  /**
   * Removes the string at the top of this stack and returns that string as the value of this
   * function.
   * 
   * @return The string at the top of this stack.
   * @throws EmptyStack If this stack is empty.
   */
  public String pop() throws EmptyStack {
    try {
      return strStack.pop().getString();
    } catch (BadType exception) {
      System.out.println(
          "\n\nYou have done something horribly wrong!\nThis is not meant to ever happen;\n\n");
      exception.printStackTrace();
      return Type.INVALID.toString();
    }
  }

  public int size() {
    return strStack.size();
  }

}
