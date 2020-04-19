package Q1_01_Is_Unique;

public class QuestionB {

	/* Assumes only letters a through z. */
	public static boolean isUniqueChars(String str) {
    int checked = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if ((checked & (1 << val)) > 0) {
        return false;
      }
      checked |= (1 << val);
    }
    return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

}
