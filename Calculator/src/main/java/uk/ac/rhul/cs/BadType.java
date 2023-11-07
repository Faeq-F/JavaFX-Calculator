package uk.ac.rhul.cs;

/**
 * Signals that the an Entry did not hold the type of data asked for.
 * 
 * @author zlac318
 */
public class BadType extends Exception {

  private static final long serialVersionUID = -824608623680010990L; // auto-generated

  public BadType(Type askedType, Type heldType) {
    super("Unable to get value. " + askedType.name() + " was asked for, but Entry held "
        + heldType.name());
  }
}
