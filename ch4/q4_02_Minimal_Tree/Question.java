package ch4.q4_02_Minimal_Tree;

import ch4.TreeNode;

public class Question {

  public static TreeNode createMinimalBST(int[] array, int begin, int end) {
    System.out.println(begin + ", " + end);

    if (begin == end) {
      return new TreeNode(array[begin]);
    }
    int middleIndex = (int) (Math.ceil((end - begin) / (double) 2) + begin);

    TreeNode middle = new TreeNode(array[middleIndex]);

    TreeNode left = createMinimalBST(array, begin, middleIndex - 1);
    middle.setLeftChild(left);

    if (middleIndex != end) {
      TreeNode right = createMinimalBST(array, middleIndex + 1, end);
      middle.setRightChild(right);
    }

    return middle;
  }

  public static TreeNode createMinimalBSTFromArray(int[] array) {
    return createMinimalBST(array, 0, array.length - 1);
  }
  
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    TreeNode root = createMinimalBSTFromArray(array);
    System.out.println("Root? " + root.data);
    System.out.println("Created BST? " + root.isBST());
    TreeNode.printTree(root);
    System.out.println("Height: " + root.height());
  }
}