package ch2.q2_02_Kth_Last;

import ch2.LinkedListNode;

public class KthLast {
  
  public static void printKthLastA(LinkedListNode head, int k) {
    LinkedListNode tempK = null;
    int tailLength = 0;

    // LinkedListNode prev = null;
    LinkedListNode curr = head;
    while (curr != null) {
      tailLength += 1;
      if ((tempK == null) && (tailLength - k == 1)) {
        tempK = head;
      }
      // prev = curr;
      curr = curr.next;

      if (tempK != null && (tailLength - k > 1)){
        tempK = tempK.next;
      }
    }

    if (tempK != null) {
      System.out.println("k: " + k + ", kth: "+ tempK.data);
    } else {
      System.out.println(k + "th node doesn't exist");
    }
  }

  public static LinkedListNode getKthLastB(LinkedListNode head, int k) {
    LinkedListNode p1 = head;
    LinkedListNode p2 = head;

    for (int i = 0; i < k; i++) {
      if (p1.next == null) return null;
      p1 = p1.next;
    }
    
    while(p1.next != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    return p2;
  }

  public static void main(String[] args) {
    int[] array = {0, 1, 2, 3, 4, 5, 6};
    LinkedListNode head = LinkedListNode.createLinkedListFromArray(array);
    System.out.println(head.printForward());
    for (int i = 0; i < array.length + 1; i++) {
      printKthLastA(head, i);
      LinkedListNode methodB = getKthLastB(head, i);
      int bData =  (methodB == null) ? -1 : methodB.data;
      System.out.println("Method B, k: " + i + ", kth: " + bData);
    }
  }
}