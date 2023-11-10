package application.stack;

/**
 * A stack holding only floats.
 * 
 * @author zlac318
 */
public class NumStack {

  private Stack numStack;
  
  public NumStack() {
    numStack = new Stack();
  }
  
  public int size() {
    return numStack.size();
  }
  
}
