package ch4;

public class TreeNode {
  public int data;
  public TreeNode left;
  public TreeNode right;
  public TreeNode parent;
  private int size = 0;

  public TreeNode(int d) {
    data = d;
    size = 1;
  }

  public void setLeftChild(TreeNode left) {
    this.left = left;
    if (left != null) {
      left.parent = this;
    }
  }

  public void setRightChild(TreeNode right) {
    this.right = right;
    if (right != null) {
      right.parent = this;
    }
  }

  public void insertInOrder(int d) {
    System.out.println("d: " + d + " data: " + data);
    if (d <= data) {
      if (left == null) {
        setLeftChild(new TreeNode(d));
      } else {
        System.out.println(left.data);
        left.insertInOrder(d);
      }
    } else {
      if (right == null) {
        setRightChild(new TreeNode(d));
      } else {
        right.insertInOrder(d);
      }
    }
    size += 1;
  }

  public int size() {
    return size;
  }

  public boolean isBST() {
    if (left != null) {
      if (data < left.data || !left.isBST()) {
        return false;
      }
    }

    if (right != null) {
      if (data >= right.data || !right.isBST()) {
        return false;
      }
    }

    return true;
  }

  public static void printTree(TreeNode root) {
    if (root == null) return;

    printTree(root.left);
    System.out.println("Height: " + root.height() + " depth: " + root.depth() + " data: " + root.data);
    printTree(root.right);
  }

  public int height() {
    int leftHeight = left != null ? left.height() : 0;
    int rightHeight = right != null ? right.height() : 0;
    return 1 + Math.max(leftHeight, rightHeight);
  }

  public int depth() {
    int depth = 0;
    TreeNode current = this;
    // System.out.println(current.data);
    while (current.parent != null) {
      // System.out.println(current.parent.data);
      depth += 1;
      current = current.parent;
    }
    return depth;
  }

  public static TreeNode createTreeFromArray(int[] array) {
    return createMinimalBST(array, 0, array.length - 1);
  }
  
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
}