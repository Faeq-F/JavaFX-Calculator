package application.stack;

import application.stack.assembly.BadType;
import application.stack.assembly.EmptyStack;
import application.stack.assembly.Entry;

/**
 * A stack data-structure holding floating point numbers.
 * 
 * @author zlac318
 */
public class NumStack {

  // This class will be a facade of the Stack class and an adapter for the RevPolishCalc
  private Stack numStack;

  /**
   * Constructs the stack.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Adds a value to the top of the stack.
   * 
   * @param value to add
   */
  public void push(float value) {
    numStack.push(new Entry(value));
  }

  /**
   * Provides the top item in the stack after removing it.
   * 
   * @return the top item in the stack
   * @throws EmptyStack when the stack has no items
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
   * Provides the top item in the stack without removing it.
   * 
   * @return the top item in the stack
   * @throws EmptyStack when the stack has no items
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
