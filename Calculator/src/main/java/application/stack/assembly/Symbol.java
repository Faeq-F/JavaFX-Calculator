package application.stack.assembly;

/**
 * A symbol within mathematical expressions, capable of being mathematical operators or brackets.
 * The symbol has a relevant descriptor, returned by toString.
 * 
 * @author zlac318
 */
public enum Symbol {
  LEFT_BRACKET("The left parenthese, i.e. ("), RIGHT_BRACKET("The right paranthese, i.e. )"), TIME(
      "The multiplication operator, i.e. *"), DIVIDE("The division operator, i.e. /"), PLUS(
          "The addition operator, i.e. +"), MINUS(
              "The minus operator, i.e. -"), INVALID("The symbol provided is not useable");

  private String description;

  private Symbol(String desc) {
    description = desc;
  }

  public String toString() {
    return this.name() + "; " + description;
  }

}
