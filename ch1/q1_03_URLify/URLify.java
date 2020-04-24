package ch1.q1_03_URLify;

public class URLify {

  public static String encodeURL(String s, int length) {
    s = s.substring(0, length);
    String[] characters = s.split("");
    for (int i = 0; i < length; i++) {
      System.out.println(characters[i]);
      System.out.println(characters[i].equals(" "));
      if (characters[i].equals(" ")) {
        characters[i] = "%20";
      }
    }
    return String.join("", characters);
  }

  public static void main(String[] args) {
    String url1 = "Mr John Smith   ";
    int length = 13;
    String urlEncoded = encodeURL(url1, length);
    System.out.println(urlEncoded);
  }
}