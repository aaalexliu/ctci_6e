import java.util.HashMap;

public class Permutation {

  public static boolean permutation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    char[] s1Array = s1.toCharArray();
    char[] s2Array = s2.toCharArray();
    java.util.Arrays.sort(s1Array);
    java.util.Arrays.sort(s2Array);

    String s1sorted = new String(s1Array);
    String s2sorted = new String(s2Array);

    return  s1sorted.equals(s2sorted);
  }

  public static HashMap<String, Integer> stringToHash(String s) {
    HashMap<String, Integer> stringCount = new HashMap<String, Integer>();
    for(char c : s.toCharArray()) {
      String convertedChar = String.valueOf(c);
      if (stringCount.get(convertedChar) == null) {
        stringCount.put(convertedChar, 1);
      } else {
        stringCount.put(convertedChar, stringCount.get(convertedChar) + 1);
      }
    }
    // System.out.println(stringCount);
    return stringCount;
  }
  public static boolean permutation2(String s1, String s2) {
    HashMap<String, Integer> s1Count = stringToHash(s1);
    HashMap<String, Integer> s2Count = stringToHash(s2);
    return s1Count.equals(s2Count);
  }

  public static void main(String[] args) {
    String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      boolean anagram = permutation(word1, word2);
      boolean anagram2 = permutation2(word1, word2);
      System.out.println("v1 " + word1 + ", " + word2 + ": " + anagram);
      System.out.println("v2 " + word1 + ", " + word2 + ": " + anagram2);
    }
  }
}

/*
space: n
time: nlogn
*/