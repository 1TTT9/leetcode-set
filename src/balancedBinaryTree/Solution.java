package balancedBinaryTree;

public class Solution {

	public int tryDFS(TreeNode n) {
		
		if (n==null) {
			return 0;
		}
		
		int leftH = tryDFS(n.left);
		if (leftH == -1) {
			return -1;
		}		
		int rightH = tryDFS(n.right);
		if (rightH == -1) {
			return -1;
		}		
		if (leftH-rightH >1 || rightH-leftH >1) {
			return -1;
		}
		
		int max = leftH;
		if (max<rightH) max = rightH;
		return max + 1;		
	}
	
    public boolean isBalanced(TreeNode root) {
    	
    	if (root == null) {
    		return true;
    	}
        
    	if (-1 == tryDFS(root))
    		return false;
    	return true;
    }	
	
}
