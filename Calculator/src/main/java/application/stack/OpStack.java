package application.stack;

import application.stack.assembly.Entry;
import application.stack.assembly.Symbol;

/**
 * A stack data-structure holding operators. The usual methods, push, pop and top, are provided. The
 * toString method will display all operators held in the stack.
 * 
 * @author zlac318
 */
public class OpStack {

  // This class will be a facade of the Stack class and an adapter for the StandardCalc
  private Stack opStack;

  /**
   * Creates an empty OpStack.
   */
  public OpStack() {
    opStack = new Stack();
  }

  /**
   * Pushes an operator onto the top of this stack.
   * 
   * @param operator the operator to be pushed onto this stack.
   */
  public void push(Symbol operator) {
    opStack.push(new Entry(operator));
  }

  public int size() {
    return opStack.size();
  }

}
