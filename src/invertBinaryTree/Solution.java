package invertBinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	
	
    public TreeNode invertTree(TreeNode root) {
    	
    	List<TreeNode> q = new LinkedList<TreeNode>();
    	
    	
    	if (q != null) {
    		q.add(root);
    	}
    	
    	TreeNode p = null, tmp = null;
    	while (true) {
    		if (q.isEmpty()) {
    			break;
    		}
    		
    		p = q.remove(0);
    		
    		if (p.left != null) {
    			q.add(p.left);
    		}
    		if (p.right != null) {
    			q.add(p.right);
    		}
    		
    		tmp = p.left;
    		p.left = p.right;
    		p.right = tmp;    		
    	}
    	
    	return root;
    }
	
}
