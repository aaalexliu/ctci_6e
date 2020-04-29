package ch3.q3_04_Stack_Via_Queue;

import java.util.Stack;

//  [1 2 3 4]
// [4 3 2 1]
// 5 6 7 8

public class MyQueue<T> {

  Stack<T> oldest;
  Stack<T> newest;

  public MyQueue() {
    oldest = new Stack<T>();
    newest = new Stack<T>();
  }

  public void popLeftToRight(Stack<T> left, Stack<T> right) {
    while (left.size() != 0) {
      right.push(left.pop());
    }
  }

  public void add(T val) {
    // if (oldest.size() != 0) {
    //   popLeftToRight(oldest, newest);
    // }
    newest.push(val);
  }

  public T peek() {
    if (oldest.size() == 0) {
      popLeftToRight(newest, oldest);
    }
    return oldest.peek();
  }

  public T remove() {
    if (oldest.size() == 0) {
      popLeftToRight(newest, oldest);
    }
    return oldest.pop();
  }

  public int size() {
    return oldest.size() +  newest.size();
  }
}