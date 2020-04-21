public class StringCompression {

  public static String compressStringA(String s) {
    int index1 = 0;
    int index2 = 0;
    int fullLength = s.length();
    char[] compressed = new char[s.length()];
    int tempCount = 0;
    while (index1 < fullLength && index2 < fullLength) {
      if (compressed[index1] != s.charAt(index2)) {
        if (tempCount == 0) {
          compressed[0] = s.charAt(0);
          tempCount = 1;
        } else {
          index1++;
          compressed[index1] = (char) (tempCount + '0');
          index1++;
          compressed[index1] = s.charAt(index2);
          tempCount = 1;
        }
      } else {
        tempCount++;
      }
      index2++;
    }
    // index1++;
    // index2--;
    // compressed[index1] = s.charAt(index2);
    index1++;
    compressed[index1] = (char) (tempCount + '0');
    return new String(compressed).trim();
  }

  public static String compressStringB(String s) {
    StringBuilder compressed = new StringBuilder();
    int countChars = 0;
    for (int index = 0; index < s.length(); index++) {
      countChars++;
      if (index == s.length() - 1 || (s.charAt(index) != s.charAt(index + 1))) {
        compressed.append(s.charAt(index));
        compressed.append(countChars);
        countChars = 0;
      }
    }
    return compressed.toString();
  }

  public static void main(String[] args) {
    String uncompressed1 = "aabcccccaaa";
    String compressed1 = "a2b1c5a3";
    String output1 = compressStringA(uncompressed1);
    String output2 = compressStringB(uncompressed1);

    System.out.println(output1 + ", " + compressed1 + " match?: " + output1.equals(compressed1));
    System.out.println(output2 + ", " + compressed1 + " match?: " + output2.equals(compressed1)); 
  }
}