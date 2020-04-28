package ch3.q3_01_Three_In_One;

import java.util.Arrays;

public class Tester {

	public static void printStacks(MultiStack stacks) {
		System.out.println(stacks.stackToString(0));
		System.out.println(stacks.stackToString(1));
    System.out.println(stacks.stackToString(2));
    System.out.println(Arrays.toString(stacks.getValues()));
	}
	
	public static void main(String [] args) throws Exception  {	
		MultiStack stacks = new MultiStack(3, 4);
		printStacks(stacks);
		stacks.push(0, 10);
		printStacks(stacks);
		stacks.push(1, 20);
		printStacks(stacks);
		stacks.push(2, 30);
		printStacks(stacks);
		
		stacks.push(1, 21);
		printStacks(stacks);
		stacks.push(0, 11);
		printStacks(stacks);
		stacks.push(0, 12);
		printStacks(stacks);
		
		stacks.pop(0);
		printStacks(stacks);
		
		stacks.push(2, 31);
		printStacks(stacks);
		
		stacks.push(0, 13);
		printStacks(stacks);
		stacks.push(1, 22);
		printStacks(stacks);
		
		stacks.push(2, 31);
		printStacks(stacks);
		stacks.push(2, 32);
		printStacks(stacks);
		stacks.push(2, 33);
		printStacks(stacks);
		stacks.push(2, 34);
		printStacks(stacks);
		
		stacks.pop(1);
		printStacks(stacks);
		stacks.push(2, 35);
		printStacks(stacks);
		
    System.out.println("Final Stack: ");
    printStacks(stacks);

    //result:
    //[33, 34, 35, 10, 11, 13, 20, 21, 30, 31, 31, 32]

    //expected:
    // Final Stack: 33, 34, 35, 10, 11, 13, 20, 21, 30, 31, 31, 32, 
	}
}