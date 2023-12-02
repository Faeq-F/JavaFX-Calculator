package application.stack;

import application.stack.assembly.BadType;
import application.stack.assembly.EmptyStack;
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
   * @param operator The operator to be pushed onto this stack.
   */
  public void push(Symbol operator) {
    opStack.push(new Entry(operator));
  }

  /**
   * Removes the operator at the top of this stack and returns that operator as the value of this
   * function.
   * 
   * @return The operator at the top of this stack.
   * @throws EmptyStack If this stack is empty.
   */
  public Symbol pop() throws EmptyStack {
    try {
      return opStack.pop().getSymbol();
    } catch (BadType exception) {
      System.out.println(
          "\n\nYou have done something horribly wrong!\nThis is not meant to ever happen;\n\n");
      exception.printStackTrace();
      return Symbol.INVALID;
    }
  }

  public int size() {
    return opStack.size();
  }

}
