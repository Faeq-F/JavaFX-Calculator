package uk.ac.rhul.cs;

import java.util.Objects;

/**
 * A number, symbol or string on a stack.
 * 
 * @author zlac318
 */
public class Entry {

  private float number;
  private Symbol other;
  private String str;

  private Type type;

  /**
   * Constructs the entry with a float number.
   * 
   * @param value to store
   */
  public Entry(float value) {
    // casting null to float will result in NullPointerException, no need to check for it ourselves
    number = value;
    type = Type.NUMBER;
  }

  /**
   * Constructs the entry with a Symbol. If the Symbol is Symbol.INVALID, the entry's type will be
   * Type.INVALID.
   * 
   * @param which symbol to store
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
   * Constructs the entry with a String.
   * 
   * @param string to store
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
   * Provides the string held.
   * 
   * @return string that is held
   * @throws BadType when the entry does not hold a string
   */
  public String getString() throws BadType {
    if (type == Type.STRING) {
      return str;
    } else {
      throw new BadType(Type.STRING, type);
    }
  }

  /**
   * Provides the symbol held.
   * 
   * @return symbol that is held
   * @throws BadType when the entry does not hold a Symbol
   */
  public Symbol getSymbol() throws BadType {
    if (type == Type.SYMBOL) {
      return other;
    } else {
      throw new BadType(Type.SYMBOL, type);
    }
  }

  /**
   * Provides the number held.
   * 
   * @return number that is held
   * @throws BadType when the entry does not hold a number
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
