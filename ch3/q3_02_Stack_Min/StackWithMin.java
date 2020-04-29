package ch3.q3_02_Stack_Min;

import java.util.Stack;

public class StackWithMin {
  Stack<NodeWithMin> stack;
  int min;

  private class NodeWithMin {
    public int data;
    public int min;

    public NodeWithMin(int data, int min) {
      this.data = data;
      this.min = min;
    }
  }

  public StackWithMin() {
    stack = new Stack<NodeWithMin>();
    min = Integer.MAX_VALUE;
  }

  public void push(int n) {
    if (min > n) min = n;
    stack.push(new NodeWithMin(n, min));
  }

  public int pop() {
    NodeWithMin val = stack.pop();
    min = val.min;
    return val.data;
  }

  public int min() {
    return min;
  }
}