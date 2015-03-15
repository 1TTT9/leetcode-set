package permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public void traverse(int[] num, int depth, List<List<Integer>> ret) {
		
		if (depth == num.length) {
			List<Integer> num_cp = new ArrayList<Integer>();
			for (int i:num) {
				num_cp.add(i);
			}			
			ret.add(num_cp);
		}
		else {
			for (int i=depth;i<=num.length;i++) {
				swap(num, i, depth);
				traverse(num, depth+1, ret);
				swap(num, depth, i);
			}
		}
	}
	
	public void swap(int[] A, int x, int y) {
		int temp = A[x-1];
		A[x-1] = A[y-1];
		A[y-1] = temp;
	}
	
	
    public List<List<Integer>> permute(int[] num) {
        
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	
    	if (num.length == 0) {
    		return ret;
    	}
    	
    	traverse(num, 1,ret);
    	
    	return ret;
    }
	
	public static void main(String[] args) {

		
		int[] test = new int[]{1,2,2,4};
				
		Solution su = new Solution();
		
		List<List<Integer>> ret = su.permute(test);
		
		for (List<Integer> r:ret) {			
			for (Integer i:r) {
				System.out.print(i + ",");				
			}
			System.out.println();
		}
	}

}
