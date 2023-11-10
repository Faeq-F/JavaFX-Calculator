package application.stack;

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
  
  public int size() {
    return numStack.size();
  }
  
}
