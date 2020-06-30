package ch4.q4_04_Check_Balanced;

import ch4.TreeNode;
import java.lang.Math;

public class Question {

  public static void main(String[] args) {
    int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode rootBalanced = TreeNode.createTreeFromArray(nodes_flattened);
    System.out.println(rootBalanced.height());
    TreeNode.printTree(rootBalanced);

    TreeNode rootUnbalanced = new TreeNode(10);
    for (int i = 0; i < 10; i++) {
			rootUnbalanced.insertInOrder((int) Math.random() * 100);
		}
  }
}