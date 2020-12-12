package ch4.q4_04_Check_Balanced;

import ch4.TreeNode;
import java.lang.Math;
import java.util.Stack;

public class Question {


  // if we check height at every node, then if the tree is completely unbalanced
  // it would be n + (n-1) + (n-2) + ... + 1
  // so.... it would be like less than n^2. which is pretty crap
  public static boolean isBalancedBruteForce(TreeNode root) {
    if (root == null) return true;
    
    Stack<TreeNode> toCheck = new Stack<TreeNode>();
    toCheck.push(root);
    while(!toCheck.empty()) {
      TreeNode curr = toCheck.pop();
      int leftHeight = 0;
      int rightHeight = 0;
      if (curr.left != null) {
        leftHeight = curr.left.height();
        toCheck.push(curr.left);
      }
      if (curr.right != null) {
        rightHeight = curr.right.height();
        toCheck.push(curr.right);
      }

      if (Math.abs(leftHeight - rightHeight) > 1) return false;
    }
    return true;
  }

  public static boolean isBalancedOptimized(TreeNode root) {

    if (root == null) return true;
    return false;
    
  }
  public static void main(String[] args) {
    int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode rootBalanced = TreeNode.createTreeFromArray(nodes_flattened);
    System.out.println(rootBalanced.height());
    TreeNode.printTree(rootBalanced);

    TreeNode rootUnbalanced = new TreeNode(10);
    for (int i = 0; i < 10; i++) {
			rootUnbalanced.insertInOrder((int) (Math.random() * 100));
    }
    TreeNode.printTree(rootUnbalanced);

    System.out.println("balanced is balanced? brute" + isBalancedBruteForce(rootBalanced));
    System.out.println("unbalanced is unbalanced? brute" + isBalancedBruteForce(rootUnbalanced));
  }
}