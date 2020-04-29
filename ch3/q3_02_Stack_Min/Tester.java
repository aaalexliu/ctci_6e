package ch3.q3_02_Stack_Min;

public class Tester {

  public static void main(String[] args) {
    int[] array = {2, 1, 3, 1};
    StackWithMin stack = new StackWithMin();

    for (int value: array) {
      stack.push(value);
    }

    System.out.println('\n');
    System.out.println(stack);

		for (int i = 0; i < array.length; i++) {
			System.out.println("Popped " + stack.pop());
			System.out.println("New min is " + stack.min());
		}
  }
}