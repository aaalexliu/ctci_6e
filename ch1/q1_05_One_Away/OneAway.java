package ch1.q1_05_One_Away;

import java.lang.Math;

public class OneAway {

  // Get char count for both strings using hashmap, subtract, and check if differences > 1
  // doesn't work - abc vs cba would check out

  // another way: compare side by side
  // if length diff > 1 return false
  // if length equals...
  public static boolean checkOneAwayA(String s1, String s2) {
    if (Math.abs(s1.length() - s2.length()) > 1) return false;

    if (s1.length() == s2.length()) {
      // System.out.println("boo " + s2);
      boolean checkOne = false;
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          if (checkOne) return false;
          checkOne = !checkOne;
        }
      }
      return true;
    }

    String shorter = s1.length() < s2.length() ? s1 : s2;
    String longer = shorter == s1 ? s2 : s1;

    // System.out.println("REACHED: " + shorter + ", " + longer);
    for (int i = 0; i < shorter.length(); i++) {
      if (shorter.charAt(i) != longer.charAt(i)) {
        return shorter.substring(i).equals(longer.substring(i + 1));
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String word1 = "hello";
    String word2 = "hellob";
    String word3 = "helo";
    String word4 = "hello";
    String word5 = "helloo3";

    System.out.printf("%s vs. %s y/n: %b\n", word1, word2, checkOneAwayA(word1, word2));
    System.out.printf("%s vs. %s y/n: %b\n", word1, word3, checkOneAwayA(word1, word3));
    System.out.printf("%s vs. %s y/n: %b\n", word1, word4, checkOneAwayA(word1, word4));
    System.out.printf("%s vs. %s y/n: %b\n", word1, word5, checkOneAwayA(word1, word5));
  }
}