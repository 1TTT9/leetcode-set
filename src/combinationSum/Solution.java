package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

		/*
		 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
			The same repeated number may be chosen from C unlimited number of times.
			Note:
			All numbers (including target) will be positive integers.
			Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
			The solution set must not contain duplicate combinations.
			For example, given candidate set 2,3,6,7 and target 7, 
			A solution set is: 
			[7] 
			[2, 2, 3] 
		 */

	public void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	public void heapify(int[] A, int i, int len) {
		
		int max = i, left = 2*i+1, right = left+1;
		if (left < len && A[max] < A[left])	max = left;
		
		if (right < len && A[max] < A[right])  max = right;
		
		if (max > i) {
			swap(A, i, max);
			heapify(A, max, len);
		}		
	}
	

	public int sumup(int[] set) {
		int sum = 0;		
		for (int s:set) {
			sum += s;
		}
		return sum;
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

    	ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	boolean isAscending = true;
    	for (int i=1;i<candidates.length;i++) {
    		if (candidates[i]<candidates[i-1]) {
    			isAscending = false;
    			break;
    		}
    	}  	
    	if (!isAscending) {    	
	    	for (int i=candidates.length/2;i>=0;i--) {
	    		heapify(candidates, i, candidates.length);
	    	}
	    	for (int i = candidates.length-1;i>=1;i--) {
	    		swap(candidates, 0, i);
	    		heapify(candidates, 0, i);
	    	}
    	}
    	
    	List<int[]> subset = new ArrayList<int[]>();
    	List<Integer> temp = null; 	
    	for (int c:candidates) {
    		if (c<target) {
    			subset.add(new int[]{c});
    		} else if (c==target) {
    			temp = new ArrayList<Integer>();
    			temp.add(new Integer(c));
    			ret.add(temp);
    		}
    	}

    	
    	if (subset.isEmpty()) {
    		return ret;
    	}
    	
    	int[] sub = null;
    	int[] t_sub = null;
    	int sum = 0;
    	do {
    		sub = subset.remove(0);    		
    		sum = sumup(sub);
    		if (sum == target) {
    			temp = new ArrayList<Integer>();
    			for (int s:sub) {
    				temp.add(new Integer(s));
    			}
    			ret.add(temp);
    		} else {
    			for (int c:candidates) {
    				if (c>target) break;    				
    				if (c<sub[sub.length-1]) continue;
    				if (sum+c <= target) {  					  					
    					t_sub = new int[sub.length+1];
    					t_sub = Arrays.copyOf(sub, sub.length+1);
    					t_sub[t_sub.length-1] = c;
    					subset.add(t_sub);
    				}
    			}
    		}
    	}while(subset.size()>0);
    	
    	return (List<List<Integer>>)ret;
	}

    
    public static void main(String...args){
    	Solution su = new Solution();
    	
    	int [] candidates = new int[]{1,2};
    	int target = 4;
    	/*
    	for (int i=candidates.length/2;i>=0;i--) {
    		heapify(candidates, i, candidates.length);
    	}
    	
    	for (int i = candidates.length-1;i>=1;i--) {
    		swap(candidates, 0, i);
    		heapify(candidates, 0, i);
    	}
    	
    	ArrayList<Integer> tmp = new ArrayList<Integer>();
    	
    	for (int i:candidates) {
    		tmp.add(new Integer(i));
    	}
    	
    	System.out.println(tmp);
    	*/
    	
    	List<List<Integer>> ret = su.combinationSum(candidates, target);
    	
    	System.out.println(ret);
    	
    }
}
