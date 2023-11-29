package application.stack;

import application.stack.assembly.BadType;
import application.stack.assembly.EmptyStack;
import application.stack.assembly.Entry;

/**
 * A stack data-structure holding floating point numbers. The usual methods, push, pop and top, are
 * provided. The toString method will display all values held in the stack.
 * 
 * @author zlac318
 */
public class NumStack {

  // This class will be a facade of the Stack class and an adapter for the RevPolishCalc
  private Stack numStack;

  /**
   * Creates an empty NumStack.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Pushes a value onto the top of this stack.
   * 
   * @param value the value to be pushed onto this stack.
   */
  public void push(float value) {
    numStack.push(new Entry(value));
  }

  /**
   * Removes the value at the top of this stack and returns that entry as the value of this
   * function.
   * 
   * @return The value at the top of this stack.
   * @throws EmptyStack if this stack is empty.
   */
  public float pop() throws EmptyStack {
    try {
      return numStack.pop().getValue();
    } catch (BadType exception) {
      System.out.println(
          "\n\nYou have done something horribly wrong!\nThis is not meant to ever happen;\n\n");
      exception.printStackTrace();
      return Float.NaN;
    }
  }

  /**
   * Looks at the value at the top of this stack without removing it from the stack.
   * 
   * @return the value at the top of this stack.
   * @throws EmptyStack if this stack is empty.
   */
  public float top() throws EmptyStack {
    try {
      return numStack.top().getValue();
    } catch (BadType exception) {
      System.out.println(
          "\n\nYou have done something horribly wrong!\nThis is not meant to ever happen;\n\n");
      exception.printStackTrace();
      return Float.NaN;
    }
  }

  public int size() {
    return numStack.size();
  }

  @Override
  public String toString() {
    return numStack.toString().replace("entries", "floats")
        .replace("Entry holding type NUMBER has value: ", "").replace("stack", "NumStack");
  }

}
