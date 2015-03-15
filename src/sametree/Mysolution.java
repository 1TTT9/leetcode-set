package sametree;




public class Mysolution {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
		
	public class Solution {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	    	if (p==null && q == null) {
	    		return true;
	    	} else if (p==null || q == null) {
	    		return false;	    		
	    	} else {
	    		return traverseDFS(p,q);
	    	}
	    }
	}

	
    public boolean traverseDFS(TreeNode p, TreeNode q) {
    	
    	if (p.val != q.val) {
    		return false;
    	}
    	
    	boolean isleftsame = false;    	
    	if (p.left == null && q.left == null) {
    		isleftsame = true;
    	} else if (p.left != null && q.left != null) {
    		isleftsame = traverseDFS(p.left, q.left);
    	} 
    	
    	if (!isleftsame) {
    		return false;
    	}
    	
    	boolean isrightsame = false;
    	if (p.right == null && q.right == null) {
    		isrightsame = true;
    	} else if (p.right != null && q.right != null) {
    		isrightsame = traverseDFS(p.right, q.right);
    	}
    	
    	if (!isrightsame) {
    		return false;
    	} else {
    		return true;
    	}
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
