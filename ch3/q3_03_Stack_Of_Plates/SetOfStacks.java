package ch3.q3_03_Stack_Of_Plates;

import java.util.Stack;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {

  ArrayList<Stack<Integer>> stacks;
  int maxSize;

  public SetOfStacks(int max) {
    stacks = new ArrayList<Stack<Integer>>();
    maxSize = max;
  }

  public void push(int n) {
    Stack<Integer> stack = nextAvailableStack();
    stack.push(n);
  }

  public int pop() throws EmptyStackException{
    if (stacks.size() == 0) throw new EmptyStackException();
    Stack<Integer> stack = getLastStack();
    while (stack.size() == 0) {
      int lastIndex = stacks.size() - 1;
      stacks.remove(lastIndex);
      stack = getLastStack();
    }
    return stack.pop();
  }

  public Stack<Integer> getLastStack() {
    return stacks.get(stacks.size() - 1);
  }

  public int popAt(int index) {
    return stacks.get(index).pop();
  }

  private Stack<Integer> nextAvailableStack() {
    if ((stacks.size() == 0) ||
      (getLastStack().size() == maxSize)) {
      Stack<Integer> stack = new Stack<Integer>();
      stacks.add(stack);
      return stack;
    } else {
      return stacks.get(stacks.size() - 1);
    }
  }
}