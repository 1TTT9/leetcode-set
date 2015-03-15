package maximumDepthofBinaryTree;

public class Solution {

    public int maxDepth(TreeNode root) {
    	
    	if (root == null) {
    		return 0;
    	}else{
    		return traverseDFS(root, 1);
    	}
    }
    
    public int traverseDFS(TreeNode node, int depth) {
    	
    	int max = depth, depth_left = 0, depth_right = 0;
    	
    	if (node.left != null) {
    		depth_left = traverseDFS(node.left, depth+1);    		
    		if (max <depth_left) {
    			max = depth_left;
    		}
    	}
    	if (node.right != null) {
    		depth_right = traverseDFS(node.right, depth+1);
    		if (max <depth_right) {
    			max = depth_right;
    		}    		
    	}
    	return max;
    }
}
