package application.stack;

import application.stack.assembly.EmptyStack;
import application.stack.assembly.Entry;
import java.util.ArrayList;
import java.util.List;

/**
 * The Stack class represents a last-in-first-out (LIFO) stack data-structure holding entries. The
 * usual push and pop operations are provided, as well as a method to return the top entry on the
 * stack and a method to get the number of entries in the stack. When a stack is first created, it
 * contains no items.
 * 
 * @author zlac318
 */
public class Stack {

  private List<Entry> entries;
  private int size;

  /**
   * Creates an empty Stack.
   */
  public Stack() {
    entries = new ArrayList<Entry>();
    size = 0;
  }

  /**
   * Pushes an entry onto the top of this stack.
   * 
   * @param entry the entry to be pushed onto this stack.
   */
  public void push(Entry entry) {
    entries.add(entry);
    size++;
  }

  /**
   * Removes the entry at the top of this stack and returns that entry as the value of this
   * function.
   * 
   * @return The entry at the top of this stack.
   * @throws EmptyStack if this stack is empty.
   */
  public Entry pop() throws EmptyStack {
    if (size == 0) {
      throw new EmptyStack();
    } else {
      size--;
      return entries.remove(size);
    }
  }


  /**
   * Looks at the entry at the top of this stack without removing it from the stack.
   * 
   * @return the entry at the top of this stack.
   * @throws EmptyStack if this stack is empty.
   */
  public Entry top() throws EmptyStack {
    if (size == 0) {
      throw new EmptyStack();
    } else {
      return entries.get(size - 1);
    }
  }


  public int size() {
    return size;
  }

  @Override
  public String toString() {
    if (size == 0) {
      return "The stack is currently empty";
    } else {
      String output = "The stack currently contains the following entries:\n";
      for (Entry entry : entries) {
        output += entry.toString() + "\n";
      }
      return output;
    }
  }

}
