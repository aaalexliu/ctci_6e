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
    if (d <= data) {
      if (left == null) {
        setLeftChild(new TreeNode(d));
      } else {
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
    System.out.println("Height: " + root.height() + " data: " + root.data);
    printTree(root.right);
  }

  public int height() {
    int leftHeight = left != null ? left.height() : 0;
    int rightHeight = right != null ? right.height() : 0;
    return 1 + Math.max(leftHeight, rightHeight);
  }

  public static TreeNode createTreeFromArray(int[] array) {
		if (array.length > 0) {
			TreeNode root = new TreeNode(array[0]);
			java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while (!done) {
				TreeNode r = (TreeNode) queue.element();
				if (r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length) {
					done = true;
				}
			}
			return root;
		} else {
			return null;
		}
	}
}