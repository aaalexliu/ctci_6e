package ch4.q4_03_List_Of_Depths;

import ch4.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class Question {

  public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
  }
  

  public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> levelLinkedList = new ArrayList<LinkedList<TreeNode>>();

    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while(!queue.isEmpty()) {
      TreeNode current = queue.remove();
      int level = root.height() - current.height();
      LinkedList<TreeNode> levelList;
      if (level > levelLinkedList.size() - 1) {
        levelList = new LinkedList<TreeNode>();
        levelLinkedList.add(levelList);
      } else {
        levelList = levelLinkedList.get(level);
      }
      levelList.add(current);
      
      if(current.left != null) queue.add(current.left);
      if(current.right != null) queue.add(current.right);
    }

    return levelLinkedList;
  }

  public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> levelLinkedList = new ArrayList<LinkedList<TreeNode>>();

    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    stack.push(root);
    while(!stack.isEmpty()) {
      TreeNode current = stack.pop();
      int level = root.height() - current.height();
      LinkedList<TreeNode> levelList;
      if (level > levelLinkedList.size() - 1) {
        levelList = new LinkedList<TreeNode>();
        levelLinkedList.add(levelList);
      } else {
        levelList = levelLinkedList.get(level);
      }
      levelList.add(current);

      if(current.left != null) stack.push(current.left);
      if(current.right != null) stack.push(current.right);
    }

    return levelLinkedList;
  }
  
  public static void main(String[] args) {
    int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createTreeFromArray(nodes_flattened);
    System.out.println(root.height());
    TreeNode.printTree(root);
    // ArrayList<LinkedList<TreeNode>> levelLinkedList = createLevelLinkedListDFS(root);
    ArrayList<LinkedList<TreeNode>> levelLinkedList = createLevelLinkedListDFS(root);

    printResult(levelLinkedList);
  }
}