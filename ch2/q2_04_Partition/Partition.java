package ch2.q2_04_Partition;

import ch2.LinkedListNode;

public class Partition {

  public static boolean partitionListA(LinkedListNode head, int p) {
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
      // System.out.println(head.printForward());
    }

    return true;
  }

  public static LinkedListNode partitionListB(LinkedListNode node, int p) {
    LinkedListNode head = null;
    LinkedListNode tail = null;
    LinkedListNode headReturn = null;

    while (node != null) {
      System.out.println(node.data);
      if (node.data < p) {
        if (head == null) {
          head = new LinkedListNode(node.data);
          headReturn = head;
        } else {
          LinkedListNode clone = new LinkedListNode(node.data);
          head.setNext(clone);
          head = head.next;
          // node = node.next;
        }
      }
      if (node.data >= p) {
        if (tail == null) {
          tail = new LinkedListNode(node.data);
        } else {
          LinkedListNode clone = new LinkedListNode(node.data);
          tail.setPrevious(clone);;
          tail = tail.prev;
          // node = node.next;
        }
      }
      node = node.next;
    }
    System.out.println("hello");
    head.setNext(tail);
    return headReturn;
  }

  public static LinkedListNode partitionC(LinkedListNode node, int p) {
    LinkedListNode head = node;
    LinkedListNode tail = node;

    while (node != null) {
      LinkedListNode next = node.next;

      if (node.data < p) {
        node.next = head;
        head = node;
      }
      if (node.data >= p) {
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    tail.next = null;

    return head;
  }

  public static void main(String[] args) {
    int[] array = {3, 5, 8, 5, 10, 2, 1};
    LinkedListNode headA = LinkedListNode.createLinkedListFromArray(array);
    LinkedListNode headB = LinkedListNode.createLinkedListFromArray(array);
    LinkedListNode headC = LinkedListNode.createLinkedListFromArray(array);

    boolean partitionSuccessA = partitionListA(headA, 5);
    LinkedListNode partitionB = partitionListB(headB, 5);
    LinkedListNode partitionC = partitionListB(headC, 5);



    System.out.println("Partition on 5 status: " + partitionSuccessA);
    System.out.println(headA.printForward());

    System.out.println("Partition on 5 method B");
    System.out.println(partitionB.printForward());

    System.out.println("Partition on 5 method C");
    System.out.println(partitionC.printForward());
  }
}