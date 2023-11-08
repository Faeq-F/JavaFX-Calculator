package application.stack.assembly;

/**
 * The type of data held by the Entry.
 * 
 * @author zlac318
 */
public enum Type {
  NUMBER("The entry holds a floating point value"), SYMBOL(
      "The entry holds a mathematical operator"), STRING(
          "The entry holds a string"), INVALID("The entry was initialized incorrectly");

  private String description;

  private Type(String description) {
    this.description = description;
  }

  public String toString() {
    return this.name() + "; " + description;
  }

}
