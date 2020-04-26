package ch2.q2_03_Delete_Middle;

import ch2.LinkedListNode;

public class DeleteMiddle {

  public static void deleteMiddleNode(LinkedListNode middle) {
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6};
    LinkedListNode head = LinkedListNode.createLinkedListFromArray(array);
    LinkedListNode next = head.next;
    for (int i = 1; i < array.length - 2; i++) {
      System.out.println("Deleting the " + i + "th node:");

      deleteMiddleNode(next);

      System.out.println(head.printForward());
      System.out.println("-----------------------");

      next = next.next;
    }
  }
}