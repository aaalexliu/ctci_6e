import javafx.scene.control.cell.CheckBoxTreeCell;

public class StringRotation {

  public static boolean checkRotation(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    if (s1.length() == 0) return false;

    String doubled = s1 + s1;

    return doubled.contains(s2);
  }

  public static void main(String[] args) {
    String s1 = "waterbottle";
    String s2 = "erbottlewat";
    boolean isRotation = checkRotation(s1, s2);

    System.out.println("isRotation?: " + isRotation);
  }
}