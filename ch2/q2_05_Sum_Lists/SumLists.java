package ch2.q2_05_Sum_Lists;

import ch2.LinkedListNode;

public class SumLists {

  public static LinkedListNode sumLists(LinkedListNode head1, LinkedListNode head2) {
    LinkedListNode sumStart = new LinkedListNode(-1);
    LinkedListNode sumEnd = sumStart;
    int carry = 0;

    while(!(head1 == null && head2 == null)) {
      int digit1 = (head1 == null) ? 0 : head1.data;
      int digit2 = (head2 == null) ? 0 : head2.data; 

      int digitSum = digit1 + digit2 + carry;
      carry = 0;
      if (digitSum > 9) {
        digitSum -= 10;
        carry = 1;
      }
      LinkedListNode digit = new LinkedListNode(digitSum);

      sumEnd.next = digit;
      sumEnd = digit;

      head1 = (head1 == null) ? null : head1.next;
      head2 = (head2 == null) ? null : head2.next;
    }

    if (carry > 0) sumEnd.next = new LinkedListNode(1);

    return sumStart.next;
  }

  public static void main(String[] args) {
    int[] num1 = {7, 1, 6, 3};
    int[] num2 = {5, 9, 2};

    LinkedListNode head1 = LinkedListNode.createLinkedListFromArray(num1);
    LinkedListNode head2 = LinkedListNode.createLinkedListFromArray(num2);

    LinkedListNode sum = sumLists(head1, head2);
    System.out.println(sum.printForward());
  }
}