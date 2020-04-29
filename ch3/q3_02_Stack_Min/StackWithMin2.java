package ch3.q3_02_Stack_Min;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer>{
  public Stack<Integer> min;

  public StackWithMin2() {
    min = new Stack<Integer>();
  }

  public void push(int n) {
    System.out.println("boo");
    if (min.empty()) {
      min.push(n);
    } else {
      // System.out.println("peek: " + min.peek() + ", " + n);
      if (min.peek().intValue() >= n) {
        min.push(n);
      }
    }
    super.push(n);
  }

  public Integer pop() {
    int value = super.pop().intValue();
    // System.out.println(value + ", current min: " + min.peek().intValue());
    if (value == min.peek().intValue()) min.pop();
    return value;
  }

  public int min() {
    if (min.empty()) return Integer.MAX_VALUE;
    return min.peek().intValue();
  }
}