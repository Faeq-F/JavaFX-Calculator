package application.stack.assembly;

import java.util.Objects;

/**
 * A stack entry capable of holding either a number, symbol or string. The relevant constructors are
 * provided, with IllegalArgumentException being thrown when Symbol.INVALID is stored. The getter
 * methods for the three different types capable of being stored are provided.
 * 
 * @author zlac318
 */
public class Entry {

  private float number;
  private Symbol other;
  private String str;

  private Type type;

  /**
   * Creates an entry with the provided value.
   * 
   * @param value The value to store.
   */
  public Entry(float value) {
    // casting null to float will result in NullPointerException, no need to check for it ourselves
    number = value;
    type = Type.NUMBER;
  }

  /**
   * Creates an entry with the provided symbol. If Symbol.INVALID is provided, the entry's type will
   * be Type.INVALID, and IllegalArgumentException is thrown.
   * 
   * @param which The symbol to store.
   */
  public Entry(Symbol which) {
    if (which == null) {
      // "throws NullPointerException" not required in method declaration
      // assume disregarded in UML as well
      throw new NullPointerException("null Symbol passed to Entry constructor");
    } else if (which == Symbol.INVALID) {
      type = Type.INVALID; // kept to throw InvalidExpression easily in future
      // "throws IllegalArgumentException" disregarded like above
      throw new IllegalArgumentException("Invalid symbol used to instantiate Entry");
    } else {
      type = Type.SYMBOL;
    }
    other = which;
  }

  /**
   * Creates an entry with the provided string.
   * 
   * @param string The string to store.
   */
  public Entry(String string) {
    if (string == null) {
      // "throws NullPointerException" not required in method declaration
      // assume disregarded in UML as well
      throw new NullPointerException("null String passed to Entry constructor");
    }
    str = string;
    type = Type.STRING;
  }

  // auto-generated
  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

  // auto-generated first 7 lines
  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    } else if (obj == null) {
      return false;
    } else if (getClass() != obj.getClass()) {
      return false;
    }
    Entry otherEntry = (Entry) obj;

    try {
      switch (type) {
        case STRING:
          return str.equals(otherEntry.getString());
        case NUMBER:
          return Float.floatToIntBits(number) == Float.floatToIntBits(otherEntry.getValue());
        default:
          return this.other == otherEntry.getSymbol();
      }

    } catch (BadType exception) {
      return false; // The types are not the same
    }
  }

  public Type getType() {
    return type;
  }

  /**
   * Returns the value held in this entry.
   * 
   * @return string The value that is held in this entry.
   * @throws BadType When this entry does not hold a string value.
   */
  public String getString() throws BadType {
    if (type == Type.STRING) {
      return str;
    } else {
      throw new BadType(Type.STRING, type);
    }
  }

  /**
   * Returns the value held in this entry.
   * 
   * @return symbol The value that is held in this entry.
   * @throws BadType When this entry does not hold a symbol value.
   */
  public Symbol getSymbol() throws BadType {
    if (type == Type.SYMBOL) {
      return other;
    } else {
      throw new BadType(Type.SYMBOL, type);
    }
  }

  /**
   * Returns the value held in this entry.
   * 
   * @return number The value that is held in this entry.
   * @throws BadType When this entry does not hold a floating-point value.
   */
  public float getValue() throws BadType {
    if (type == Type.NUMBER) {
      return number;
    } else {
      throw new BadType(Type.NUMBER, type);
    }
  }

  @Override
  public String toString() {
    String output = "Entry holding type " + type.name() + " has value: ";
    if (type == Type.STRING) {
      return output + str;
    } else if (type == Type.NUMBER) {
      return output + number;
    } else { // This would be SYMBOL or INVALID (can only be INVALID with Symbol.INVALID)
      return output + other.toString();
    }
  }

}
