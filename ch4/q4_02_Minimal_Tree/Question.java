package ch4.q4_02_Minimal_Tree;

import ch4.TreeNode;

public class Question {
  
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    TreeNode root = TreeNode.createMinimalBST(array);
    System.out.println("Root? " + root.data);
    System.out.println("Created BST? " + root.isBST());
    TreeNode.printTree(root);
    System.out.println("Height: " + root.height());
  }
}