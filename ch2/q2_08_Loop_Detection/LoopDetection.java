package ch2.q2_08_Loop_Detection;

import java.util.HashSet;

import ch2.LinkedListNode;

public class LoopDetection {

  // this takes O(n) because we have to go through entire list to find loop
  public static LinkedListNode detectLoop(LinkedListNode head) {
    
    HashSet<LinkedListNode> nodeSet = new HashSet<LinkedListNode>();
    
    while (head != null) {
      if (nodeSet.contains(head)) return head;
      nodeSet.add(head);
      head = head.next;
      // System.out.println(head.data);
    }

    return null;
  }

  public static LinkedListNode detectLoopB(LinkedListNode head) {
    LinkedListNode fast = head;
    LinkedListNode slow = head;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (fast == slow) break;
    }
    if (fast == null || fast.next == null) return null;

    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return fast;
  }

  public static void main(String[] args) {
    // int[] vals1 = {1, 2, 3, 4, 5};
    // LinkedListNode list1 = LinkedListNode.createLinkedListFromArray(vals1);
    // LinkedListNode temp1 = list1.next.next;
    // // temp1.next = null;
    // list1.next.next.next.next.next = temp1;
    // // System.out.println(list1.printForward());


    // LinkedListNode loopStart = detectLoop(list1);
    // System.out.println("start of loop: " + loopStart.data);

    int list_length = 100;
		// int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		// nodes[list_length - 1].next = nodes[list_length - k];
		
    LinkedListNode loop = detectLoop(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
    LinkedListNode loop2 = detectLoopB(nodes[0]);
		if (loop2 == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop2.data);
		}
  }
}