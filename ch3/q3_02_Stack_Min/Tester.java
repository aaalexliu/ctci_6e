package ch3.q3_02_Stack_Min;

public class Tester {

  public static void main(String[] args) {
    int[] array = {2, 1, 3, 1};
    StackWithMin stack = new StackWithMin();
    StackWithMin2 stack2 = new StackWithMin2();

    for (int value: array) {
      stack.push(value);
      stack2.push(value);
    }

    System.out.println('\n');
    System.out.println(stack2.toString());

		for (int i = 0; i < array.length; i++) {
			System.out.println("Popped " + stack.pop());
      System.out.println("New min is " + stack.min());
      
      System.out.println("Popped2 " + stack2.pop());
      // System.out.println("min: " + stack2.min.toString());
			System.out.println("New min2 is " + stack2.min());
		}
  }
}