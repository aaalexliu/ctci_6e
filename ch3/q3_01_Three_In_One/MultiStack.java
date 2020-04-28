package ch3.q3_01_Three_In_One;

import java.util.EmptyStackException;
import java.util.Arrays;

public class MultiStack {
  private StackInfo[] stacks;
  private int[] values;
  
  private class StackInfo {
    public int start, size, capacity;

    public StackInfo(int start, int capacity) {
      this.start = start;
      this.capacity = capacity;
      this.size = 0;
    } 

    public int getEndIndex(int valueSize) {
      return (start + size - 1) % valueSize;
    }

    public int getStartIndex() {
      return start;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public boolean isFull() {
      return size == capacity;
    }
  }

  public MultiStack(int numStacks, int startSize) {
    stacks = new StackInfo[numStacks];
    for (int i = 0; i < numStacks; i++) {
      stacks[i] = new StackInfo(i * startSize, startSize);
    }
    values = new int[numStacks * startSize];
  }

  public void push(int stackNum, int val) throws FullStackException {
    System.out.println("Adding to stack " + stackNum + " value: " + val);
    if (isAllFull()) throw new FullStackException();
    StackInfo current = stacks[stackNum];
    if (current.isFull()) {
      expand(stackNum);
    } 

    values[getNextEmptyIndex(current)] = val;
    current.size += 1;
  }

  public int pop(int stackNum) throws EmptyStackException {
    StackInfo current = stacks[stackNum];
    if (current.isEmpty()) throw new EmptyStackException();
    
    current.size -= 1;
    int value = values[getNextEmptyIndex(current)];
    values[getNextEmptyIndex(current)] = 0;

    System.out.println("Popping from stack " + stackNum + " value " + value);
    return value;
  }

  private void shiftOne(StackInfo stack) {
    int swapIndex = stack.getEndIndex(values.length);
    int stopIndex = getPrevIndex(stack.getStartIndex());
    while(swapIndex != stopIndex) {
      values[getNextIndex(swapIndex)] = values[swapIndex];
      swapIndex = getPrevIndex(swapIndex);
    }
    values[stack.getStartIndex()] = 0;
    stack.start += 1;
  }

  public void shift(int stackNum) {
    System.out.println("Shifting stack: " + stackNum);

    StackInfo stack = stacks[stackNum];
    if (!stack.isFull()) {
      shiftOne(stack);
      stack.capacity -= 1;
    } else {
      int nextStack = getNextStackIndex(stackNum);
      shift(nextStack);
      shiftOne(stack);
    }
  }

  public void expand(int stackNum) {
    System.out.println("Expanding stack: " + stackNum);
    
    int nextStack = getNextStackIndex(stackNum);
    shift(nextStack);

    stacks[stackNum].capacity += 1;
  }

  public boolean isAllFull() {
    for (int i = 0; i < stacks.length; i++) {
      if (!stacks[i].isFull()) return false;
    }
    return true;
  }

  public int getNextStackIndex(int stackNum) {
    return (stackNum + 1) % stacks.length;
  }

  public int getNextEmptyIndex(StackInfo stack) {
    return (stack.start + stack.size) % values.length;
  }

  public int getPrevIndex(int index) {
    return (index - 1) % values.length;
  }

  public int getNextIndex(int index) {
    return (index + 1) % values.length;
  }

  public int[] getValues() {
    return values;
  }

  public String stackToString(int stackNum) {
    return Arrays.toString(
      Arrays.copyOfRange(values, 
        stacks[stackNum].start,
        stacks[stackNum].start + stacks[stackNum].capacity));
  }
}
