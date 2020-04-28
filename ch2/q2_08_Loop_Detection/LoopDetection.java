package ch2.q2_08_Loop_Detection;

import java.util.HashSet;

import ch2.LinkedListNode;

public class LoopDetection {

  public static LinkedListNode detectLoop(LinkedListNode head) {
    
    HashSet<LinkedListNode> nodeSet = new HashSet<LinkedListNode>();
    
    while (head != null) {
      if (nodeSet.contains(head)) return head;
      nodeSet.add(head);
      head = head.next;
    }

    return new LinkedListNode(-1);
  }

  public static void main(String[] args) {
    int[] vals1 = {1, 2, 3, 4, 5};
    LinkedListNode list1 = LinkedListNode.createLinkedListFromArray(vals1);
    LinkedListNode temp1 = list1.next.next;
    // temp1.next = null;
    list1.next.next.next.next.next = temp1;
    // System.out.println(list1.printForward());
    
    LinkedListNode loopStart = detectLoop(list1);
    System.out.println("start of loop: " + loopStart.data);
  }
}