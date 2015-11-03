package validateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {
	

	boolean validateBST(TreeNode node, int min, int max) {
		
		if (node == null) {
			return true;
		}
		
		if (node.val <= min || node.val >= max) {
			return false;
		}
		
		return validateBST(node.left, min, node.val) && validateBST(node.left, node.val, max);	
	}
	
	
	boolean iterValidateBST(TreeNode node) {
		
		if (node == null) {
			return true;
		}
		
		List<Integer> qmin = new ArrayList<Integer>();
		List<Integer> qmax = new ArrayList<Integer>();		
		List<TreeNode> qn = new ArrayList<TreeNode>();				
		
		qn.add(node);
		
		TreeNode tn = null;
		int max = node.val, min = node.val;
		while (qn.size()>0) {
			tn = qn.remove(0);			
			if (min>tn.val) {
				min = tn.val;
			}
			if (max>tn.val) {
				max = tn.val;
			}			
			if (tn.left != null) {
				qn.add(tn.left);
			}
			if (tn.right != null) {
				qn.add(tn.right);
			}			
		}
		
		max += 1;
		min -= 1;
		
		qmin.add(min);
		qmax.add(max);
		qn.add(node);
		boolean ret = true;
		while (qn.size()>0) {
			tn = qn.remove(0);
			min = qmin.remove(0);
			max = qmax.remove(0);
			
			if (tn.val > max || tn.val < min) {
				ret = false;
				break;
			}

			if (tn.left != null) {
				qn.add(tn.left);
				qmin.add(min, tn.val);
			}

			if (tn.right != null) {
				qn.add(tn.right);
				qmin.add(tn.val, max);
			}
		}
		
		return ret;
	}	
	
	boolean iterValidateBST2(TreeNode node) {
		
		if (node == null) {
			return true;
		}
		
		List<TreeNode> stack = new ArrayList<TreeNode>();
		boolean started = false;
		TreeNode tn = node;
		int preVal = 0;
		
		while (true) {
			if (tn!=null) {
				stack.add(tn);
				tn = tn.left;
				continue;
			}
			
			if (stack.isEmpty()) {
				break;
			}
			
			tn = stack.remove(stack.size()-1);
			
			if (!started) {
				preVal = tn.val;
				started = true;
			} else {
				if (preVal > tn.val) {
					return false;
				}
				preVal = tn.val;
			}
			
			tn = tn.right;
		}
		return true;
	}		
	
	
	
	public boolean isValidBST(TreeNode root) {       
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }	
	

	public static void main(String[] args) {
		

	}

}
