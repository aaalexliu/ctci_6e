package ch2.q2_07_Intersection;

import java.util.HashSet;

import ch2.LinkedListNode;

public class Intersection {

  // this method takes O(A + B) time and O(A) space
  // ctci method takes O(A + B) time and O(1) space
  public static LinkedListNode findIntersection(
    LinkedListNode head1, LinkedListNode head2) {
    
    HashSet<LinkedListNode> list1Set = new HashSet<LinkedListNode>();
    
    while (head1 != null) {
      list1Set.add(head1);
      head1 = head1.next;
    }

    while (head2 != null) {
      if (list1Set.contains(head2)) return head2;
      head2 = head2.next;
    }

    return new LinkedListNode(-1);
  }

  public static void main(String[] args) {
    	/* Create linked list */
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode list1 = LinkedListNode.createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode list2 = LinkedListNode.createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
  
    LinkedListNode intersection = findIntersection(list1, list2);

    System.out.println(intersection.printForward());
  }
}