package sumRootToLeafNumbers;

import java.util.ArrayList;
import java.util.List;


public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}

    public int toInteger(String seq) {
    	return Integer.parseInt(seq);
    }	
	
    public int sumNumbers(TreeNode root) {
    	int sum = 0;
    	
    	if (root == null) {
    		return sum;
    	}

    	return goToEnd(root, "");    	
    }	
	
    public int goToEnd(TreeNode node, String seq) {

		int sum = 0;
		
    	String seq2 = seq + Integer.toString(node.val);
    	
    	if (node.left == null && node.right == null) {
    		return toInteger(seq2);
    	} else {

    		if (node.left != null) {
    			sum += goToEnd(node.left, seq2);
    		}
    		if (node.right != null) {
    			sum += goToEnd(node.right, seq2);
    		}    		
    	}    	
    	return sum;
    }
	
	
	
    public int sumNumbersAllNodes(TreeNode root) {
    	int sum = 0, cur = 0;
    	
    	if (root == null) {
    		return sum;
    	}

    	final String seq = Integer.toString(root.val);
    	if (root.left != null) {
    		sum += traverse(root.left, cur, seq);
    	}
    	    	
    	if (root.right != null) {
    		sum += traverse(root.right, cur, seq);
    	}    	

    	return sum + toInteger(seq);
    }
    
    
    public int traverse(TreeNode node, int suml, final String seq) {
    	
    	int cur=suml, sum = suml;
    	String seq2 = seq + Integer.toString(node.val);
    	
    	if (node.left != null) {
    		sum += traverse(node.left,  cur, seq2);
    	}
    	
    	if (node.right != null) {
    		sum += traverse(node.right, cur, seq2);
    	}    	
    	 	    	
    	return sum+toInteger(seq2);
    }
    
	public static void main(String[] args) {

		Solution su = new Solution();
		
		Solution.TreeNode root = new Solution.TreeNode(9);


		Solution.TreeNode node1 = new Solution.TreeNode(3);
		Solution.TreeNode node2 = new Solution.TreeNode(4);
		Solution.TreeNode node3 = new Solution.TreeNode(0);
		Solution.TreeNode node4 = new Solution.TreeNode(8);		
		root.left = node1;
		root.right = node2;
		node1.right = node3;
		node2.left = node4;

		System.out.println(su.sumNumbers(root));
	}

}
