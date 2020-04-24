package ch2.q2_01_Remove_Dups;

import java.util.Hashtable;

import ch2.LinkedListNode;

public class RemoveDups {

  public static void deleteDupsA(LinkedListNode current) {
    Hashtable<Integer, Integer> dataCount = new Hashtable<Integer, Integer>();

    while(current != null) {
      boolean dataExists = (dataCount.get(current.data) != null);
      // System.out.println(dataCount);
      // System.out.println(dataExists);

      if (dataExists) {

        LinkedListNode prev = current.prev;
        prev.setNext(current.next);
      } else {
        dataCount.put(current.data, 1);
      }
      current = current.next;
    }
  }

  public static void deleteDupsB(LinkedListNode head) {
    // delete dups without buffer. O(N^2) time
    LinkedListNode perm = head;

    while (head != null) {
      int headData = head.data;

      LinkedListNode prev = head;
      LinkedListNode current = prev.next;
      while(current != null) {
        if (current.data == headData) {
          prev.setNext(current.next);
          current = current.next;
        } else {
          prev = current;
          current = current.next;
        }
        System.out.println(perm.printForward());
      }

      head = head.next;
    }
  }

  public static void main(String[] args) {
    LinkedListNode first = new LinkedListNode(0, null, null);
    LinkedListNode head = first;
		LinkedListNode second = first;

    for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		// System.out.println(head.printForward());

		LinkedListNode cloneA = head.clone();
		LinkedListNode cloneB = head.clone();
    LinkedListNode cloneC = head.clone();
    
    // deleteDupsA(cloneA);
    deleteDupsB(cloneB);

    // System.out.println(cloneA.printForward());
		System.out.println(cloneB.printForward());
		// System.out.println(cloneC.printForward());
  }
}