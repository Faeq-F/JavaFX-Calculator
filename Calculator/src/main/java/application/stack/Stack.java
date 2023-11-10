package application.stack;

import application.stack.assembly.EmptyStack;
import application.stack.assembly.Entry;
import java.util.ArrayList;
import java.util.List;

/**
 * A stack data-structure holding entries.
 * 
 * @author zlac318
 */
public class Stack {

  private List<Entry> entries;
  private int size;

  /**
   * Constructs the stack.
   */
  public Stack() {
    entries = new ArrayList<Entry>();
    size = 0;
  }
  
  /**
   * Adds an entry to the top of the stack.
   * 
   * @param entry to add
   */
  public void push(Entry entry) {
    entries.add(entry);
    size++;
  }
  
  /**
   * Provides the top item in the stack after removing it.
   * 
   * @return the top item in the stack
   * @throws EmptyStack when the stack has no items
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
   * Provides the top item in the stack, without removing it.
   * 
   * @return the top item in the stack
   * @throws EmptyStack when the stack has no items
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
