package application.stack.assembly;

/**
 * Signals that the stack is empty and the operation wanted cannot occur.
 * 
 * @author zlac318
 */
public class EmptyStack extends Exception {

  private static final long serialVersionUID = 1900439315893433924L; // auto-generated

  public EmptyStack() {
    super("The stack is empty");
  }
}
