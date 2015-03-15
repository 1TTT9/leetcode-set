package binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Solution su = new Solution();
		
		Solution.TreeNode root = new Solution.TreeNode(1);
		
		Solution.TreeNode node1 = new Solution.TreeNode(3);
		
		Solution.TreeNode node2 = new Solution.TreeNode(4);
		
		Solution.TreeNode node3 = new Solution.TreeNode(2);
		
		Solution.TreeNode node4 = new Solution.TreeNode(5);
		
		root.left = node1;
		root.right = node2;
		node1.right = node3;
		node2.left = node4;
		
		List<Integer> ans =  su.inorderTraversal(root);
		
		//List<Integer> ans =  su.inorderTraversal(null);
		
		System.out.println("Result : ");
		Iterator<Integer> iterator = ans.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

    public List<Integer> inorderTraversal(TreeNode root) {
    	
		List<Integer> ans = new ArrayList<Integer>();
		List<TreeNode> stack = new ArrayList<TreeNode>();
		
		TreeNode node = null, temp = null;
		stack.add(root);
		while (true) {
			if (stack.isEmpty()) {
				break;
			}
			node = stack.remove(stack.size()-1);
			if (node == null) {
				break;
			}
			
			if (node.left == null && node.right == null) {
				ans.add(node.val);
			} else {
				temp = new TreeNode(node.val);
				if (node.right != null) {
					stack.add(node.right);
				}					
				stack.add(temp);				
				if (node.left != null) {
					stack.add(node.left);
				}
			}
		}		
        return ans;
    	
    }	
	
}
