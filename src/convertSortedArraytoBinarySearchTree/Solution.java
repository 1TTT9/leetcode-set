package convertSortedArraytoBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}	
	
	public TreeNode sortedArrayToBST0(int[] num) {
        
		if (num.length == 0) {
			return null;
		}
		
		Solution.TreeNode root = new Solution.TreeNode(num[ 0 ]);
		root.left = null;
		root.right = null;
		
		int depth = num.length/2;
		if (depth <1) {
			return root;
		}
		
		int layer = 0, index = 2;

		List<Solution.TreeNode> nodelist = new ArrayList<Solution.TreeNode>();
		nodelist.add(root);
		while (true) {
		
			if (index>num.length) {
				break;
			}			

			if (layer+1 > depth ) {
				nodelist.remove(nodelist.size()-1);
				layer--;
			} else {
				Solution.TreeNode cur = nodelist.get(nodelist.size()-1);				
				if (cur.left != null && cur.right != null) {
					nodelist.remove(nodelist.size()-1);
					layer--;					
				}
				else {
					Solution.TreeNode next = new Solution.TreeNode(num[ index-1 ]);
					next.left = null;
					next.right = null;				
					
					if (cur.left == null) {
						cur.left = next;
					} else if (next.right == null) {
						cur.right = next;
					}
					nodelist.add(next);
					index++;
					layer++;
				}				
			}
		}
		return root;
    }
	

	public TreeNode sortedArrayToBST(int[] num) {
		        
		if (num.length == 0) {
			return null;
		}
		
		int m = getMid(1,num.length);
		
		Solution.TreeNode root = new Solution.TreeNode(num[m-1]);		
		traverseDFS(num, root, 1, m-1);
		traverseDFS(num, root, m+1, num.length);
		return root;
    }
	
	
	public void traverseDFS(int[] num, TreeNode node, int i, int j) {

		if (i > j ) {
			return;
		} else {
			
			int m = getMid(i,j);

			Solution.TreeNode next = new Solution.TreeNode(num[ m-1 ]);
			next.left = null;
			next.right = null;
			
			if (node.left == null) {
				node.left = next;				
			} else if (node.right == null) {
				node.right = next;
			}
				
			traverseDFS(num, next, i, m-1);
			traverseDFS(num, next, m+1, j);	
		}		
	}
	
	public int getMid(int x, int y) {
		if (x==y) {
			return x;
		}
		if (y%2==0) {
			return (x+y+1)/2;
		} else {
			return (x+y)/2;
		}
	}
	
	public void traverse(TreeNode root) {
		
		if (root == null) {
			return;
		}
		System.out.print(root.val);		
		traverse(root.left);
		traverse(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution su = new Solution();
		
		int[] num = {100};
		
		Solution.TreeNode tm = su.sortedArrayToBST(num);
				
		su.traverse(tm);
				
	}

}
