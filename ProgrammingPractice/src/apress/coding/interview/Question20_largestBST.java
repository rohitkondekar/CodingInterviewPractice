package apress.coding.interview;

/**
 * Please implement a function to get the largest size of all binary search subtrees in a given binary tree. 
 * A subtree inside a tree t is a tree consisting of a node and all of its descendants in t. 
 * The size of a tree is defined as the number of nodes in the tree.
 * @author rohitkondekar
 *
 */
public class Question20_largestBST {
	
	class Node{
		int val;
		Node right=null;
		Node left=null;
		
		Node(int val){
			this.val = val;
		}
	}
	
	class Result{
		boolean status;
		int size;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		Result(boolean status, int size){
			this.status = status;
			this.size = size;
		}
		
		Result(boolean status, int size,int min, int max){
			this.status = status;
			this.size = size;
			this.min=min;
			this.max=max;
		}
	}
	
	int largestBST(Node root){
		if(root==null)
			return 0;
		else if(root.left==null && root.right==null)
			return 1;	
		
		return largestBSTHelper(root).size;
	}
	
	Result largestBSTHelper(Node root){
		
		if(root==null)
			return new Result(true, 0);
		
		Result rst1 = largestBSTHelper(root.right);
		Result rst2 = largestBSTHelper(root.left);
		
		if(rst1.status && rst2.status && root.val>=rst2.max && root.val<=rst1.min){
			return new Result(true,rst1.size+rst2.size+1,rst2.min,rst1.max);
		}
		return new Result(false, rst1.size>rst2.size?rst1.size:rst2.size);
	}
	

}
