package ch2.q2_06_Palindrome;

import java.util.HashMap;
import java.util.LinkedList;

import ch2.LinkedListNode;

public class Palindrome {

  public static boolean checkPalindromePermutation(LinkedListNode head) {
    HashMap<Integer, Integer> dataMap = new HashMap<Integer, Integer>();

    while (head != null) {
      if (dataMap.get(head.data) == null) {
        dataMap.put(head.data, 1);
      } else {
        dataMap.put(head.data, dataMap.get(head.data) + 1);
      }
    head = head.next;
    }

    System.out.println(dataMap);
    boolean oneOdd = false;
    for (int count : dataMap.values()) {
      if (count % 2 == 1) {
        if (oneOdd) return false;
        oneOdd = true;
      }
    }
    return true;
  }

  // REVERSE FRONT HALF doesn't make sense because you already need to iterate
  // to the end if length is unknown
  public static boolean checkPalindrome(LinkedListNode head) {
    LinkedListNode p1 = head;
    LinkedListNode p2 = null;
    LinkedListNode last = head;

    int length = 0;

    LinkedList<LinkedListNode> frontHalf = new LinkedList<LinkedListNode>();

    while (p1 != null) {
      length += 1;
      if (length % 2 == 0) {
        p2 = (p2 == null) ? head : p2.next;
        frontHalf.add(p2);
      }
      last = p1;
      p1 = p1.next;
    }
    System.out.println(frontHalf);
    while (frontHalf.size() > 0) {
      if (frontHalf.remove().data != last.data) return false;
      last = last.prev;
    }

    return true;
  }

  public static class Result {
    public LinkedListNode node;
    public boolean result;
    public Result(LinkedListNode n, boolean res) {
      node = n;
      result = res;
    }
  }

  public static int getLength(LinkedListNode head) {
    int length = 0;
    while(head != null) {
      head = head.next;
      length += 1;
    }
    return length;
  }

  public static Result recursePalindrome(LinkedListNode head, int length) {
    if (head == null || length <=0 ) {
      return new Result(head, true);
    } else if (length == 1) {
      return new Result(head.next, true);
    }

    Result nextResult = recursePalindrome(head.next, length - 2);

    if (!nextResult.result || nextResult.node == null) return nextResult;

    boolean match = (nextResult.node.data == head.data);
    return new Result(nextResult.node.next, match);
  }


  public static boolean checkPalindromeB(LinkedListNode head) {
    int length = getLength(head);
    Result res = recursePalindrome(head, length);
    return res.result;
  }

  public static void main(String[] args) {
    int[] array1 = {0, 1, 2, 1, 0};
    LinkedListNode head1 = LinkedListNode.createLinkedListFromArray(array1);

    boolean isPalindromePermutation1 = checkPalindromePermutation(head1);
    System.out.println("Is Palindrome: " + isPalindromePermutation1);

    boolean isPalindrome = checkPalindrome(head1);
    System.out.println("check palindrom with queue: " + isPalindrome);

    boolean isPalindromeB = checkPalindromeB(head1);
    System.out.println("check palindrome recursive: " + isPalindromeB);
  }
}