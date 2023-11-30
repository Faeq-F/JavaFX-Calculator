package application.stack;

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
  
  public int size() {
    return opStack.size();
  }

}
