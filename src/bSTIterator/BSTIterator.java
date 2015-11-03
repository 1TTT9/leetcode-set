package bSTIterator;

import java.util.Stack;

public class BSTIterator {

	/*
	 * what is BST
	 * nodes'values on left-hand side are less than parent
	 * nodes'values on right-hand side are greater than parent 
	 * sub-tree are also BST
	 */
	
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	
	Stack<TreeNode> st = null;
	
    public BSTIterator(TreeNode root) {
        
    	st = new Stack<TreeNode>();
    	
    	while (true) {
    			
    		if (root == null) 
    			break;
    		
    		st.push(root);
    		
    		root = root.left;    			
    	}
    	
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
    	return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	
    	TreeNode tn = st.pop();
    	
    	int ret = tn.val;
    	
    	tn = tn.right;
    	
    	while (true) {    		
    		if (tn == null) 
    			break;
    		
    		st.push(tn);
    		tn = tn.left;    		
    	}
    	
    	return ret;
    }	
	
	
	public static void main(String[] args) {
		
		

	}

}
