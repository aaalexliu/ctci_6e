package ch2.q2_04_Partition;

import ch2.LinkedListNode;

public class Partition {

  public static boolean partitionList(LinkedListNode head, int p) {
    LinkedListNode maxP = null;
    LinkedListNode curr = head;

    while(curr != null) {
      if (curr.data < p) {
        if (maxP != null) {
          curr.prev.setNext(curr.next);
          // curr.prev.next = curr.next;

          //the problem is when you reach node 1 prev is still 2;

          // System.out.println(curr.prev.next.data);
          LinkedListNode next = curr.next;
          LinkedListNode temp = maxP.next;
          // maxP.next = curr;
          // curr.next = temp;
          maxP.setNext(curr);
          curr.setNext(temp);
          // curr = next;
          // maxP = maxP.next;
          maxP = curr;
          curr = next;
        } else {
          maxP = curr;
          curr = curr.next;
        }
      } else {
        curr = curr.next;
      }
      // System.out.println(curr.data);
      System.out.println(head.printForward());

    }

    return true;
  }

  public static void main(String[] args) {
    int[] array = {3, 5, 8, 5, 10, 2, 1};
    LinkedListNode head = LinkedListNode.createLinkedListFromArray(array);

    boolean partitionSuccess = partitionList(head, 5);

    System.out.println("Partition on 5 status: " + partitionSuccess);
    System.out.println(head.printForward());
  }
}