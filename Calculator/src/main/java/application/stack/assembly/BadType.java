package application.stack.assembly;

/**
 * Thrown to indicate a type mismatch between the value of an entry, and the specified return value
 * of a method called from it.
 * 
 * @author zlac318
 */
public class BadType extends Exception {

  private static final long serialVersionUID = -824608623680010990L; // auto-generated

  /**
   * Constructs a new BadType exception with the conflicting types in the error message string.
   * 
   * @param askedType the specified type of the return value of a method called from the entry.
   * @param heldType the type of the value held by the entry.
   */
  public BadType(Type askedType, Type heldType) {
    super("Unable to get value. " + askedType.name() + " was asked for, but Entry held "
        + heldType.name());
  }
}
