package combinationSumIII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	
	public void goDFS(int target, int maxDepth, int depth, int idx, LinkedList<Integer> path, List<List<Integer>> ret) {
			
		if (target == 0 && depth == maxDepth) {
			ret.add(new LinkedList<Integer>(path));
			return;
		}
		
		if (depth >= maxDepth) {
			return;
		}		
		
		for (int i=idx; i<=9;i++) {
			
			int resTarget = target - i;
			
			if (resTarget<0) {
				break;
			}
						
			path.addLast(i);
			
			goDFS(resTarget, maxDepth, depth+1, i+1, path, ret);
			
			path.removeLast();			
		}
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        if (n == 0 || k == 0) {
        	return ret;
        }
        
        LinkedList<Integer> path = new LinkedList<Integer>();
        goDFS(n, k, 0, 1, path, ret);
        
        
        return ret;
    }	
	
	public static void main(String[] args) {
		
		Solution su = new Solution();
		
		List<List<Integer>> ret = su.combinationSum3(3, 9);
		
		for (List<Integer> l:ret) {
			for (int c:l) {
				System.out.format("%d ", c);
			}
			System.out.println();
		}

	}

}
