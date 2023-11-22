package application.stack.assembly;

/**
 * Thrown by methods in the Stack class to indicate that the stack is empty.
 * 
 * @author zlac318
 */
public class EmptyStack extends Exception {

  private static final long serialVersionUID = 1900439315893433924L; // auto-generated

  /**
   * Constructs a new EmptyStack exception with "The stack is empty" as its error message string.  
   */
  public EmptyStack() {
    super("The stack is empty");
  }
}
