import java.util.*;

public class Palindrome {

  public static int getCharNumber(char c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');

    int targetVal = Character.getNumericValue(c);
    if (a <= targetVal && targetVal <= z) {
      return targetVal - a;
    }
    return -1;
  }

  public static HashMap getCharMap(String s) {
    HashMap<Integer, Integer> charMap = new HashMap<Integer, Integer>();
    for (char c : s.toCharArray()) {
      int charNum = getCharNumber(c);
      if (charNum < 0) {
        continue;
      }
      if (charMap.get(charNum) == null) {
        charMap.put(charNum, 1);
      } else {
        charMap.put(charNum, charMap.get(charNum) + 1);
      }
    }
    return charMap;
  }

  public static boolean checkOddCount(HashMap<Integer, Integer> charMap) {
    boolean oneOdd = false;
    for (Integer c : charMap.values()) {
      int count = c.intValue();
      if (count % 2 == 1) {
        if (oneOdd) return true;
        oneOdd = true;
      }
    }
    return false;
  }

  public static boolean isPermutePalindromeA(String s) {
    // char[] charArray = s.toCharArray();
    // for (char c: charArray) {
    // System.out.println(c + " " + (int) c);

    // }
    HashMap charMap = getCharMap(s);
    System.out.println(charMap);

    return !checkOddCount(charMap);
  }

  public static boolean isPermutePalindromeC(String s) {
    int bitVector = 0;
    for (char c : s.toCharArray()) {
      int val = getCharNumber(c);
      if (val < 0) continue;
      bitVector ^= (1 << val);
    }
    if (bitVector == 0) return true;
    
    return (((bitVector - 1) & (bitVector)) == 0);
  }

  public static void main(final String[] args) {
    String word1 = "Tact Coa";
    boolean bool1 = isPermutePalindromeA(word1);

    System.out.println(word1 + ": isPalindrome? " + bool1);

    String word2 = "Rats live on no evil star";
    System.out.println(word2 + ": isPalindrome A? " + isPermutePalindromeA(word2));
    System.out.println(word2 + ": isPalindrome C? " + isPermutePalindromeC(word2));
  }
}