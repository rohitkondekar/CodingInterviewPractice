package apress.coding.interview;

/**
 * How do you verify whether a binary tree is a binary search tree? For example, the tree in Figure 3-13 is a binary search tree.
 * @author rohitkondekar
 *
 */
public class Question19_VerifyBinarySearchTree {
	
	
	class Node{
		int val;
		Node right=null;
		Node left=null;
		
		Node(int val){
			this.val = val;
		}
	}
	
	/**
	 * Pre order solution
	 * @param root
	 * @return
	 */
	boolean isBinarySearchTree(Node root){
		if(root==null || (root.left==null && root.right==null))
			return true;
		
		return isBinarySearchTreeHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	boolean isBinarySearchTreeHelper(Node root, int max, int min){
		
		if(root==null)
			return true;
		
		if(root.val>max || root.val<min)
			return false;
		
		return isBinarySearchTreeHelper(root.left,root.val,min) & isBinarySearchTreeHelper(root, max, root.val);
	}

}
