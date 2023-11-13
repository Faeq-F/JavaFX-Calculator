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
   * @throws BadType this should not be here - will remove in due course
   */
  public float pop() throws EmptyStack, BadType {
    return numStack.pop().getValue();
  }

  public int size() {
    return numStack.size();
  }

}
