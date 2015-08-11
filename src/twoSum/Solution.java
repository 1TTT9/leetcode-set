package twoSum;

import java.util.HashMap;

public class Solution {

	
	public void heapify(int[] nums, int idx, int len) {
		
		int max = idx, left = idx*2, right = left+1;
		
		if ( left<=len && nums[max]<nums[left] ) max = left;
		if (right<=len && nums[max]<nums[right]) max = right;
		
		if (max != idx) {
			int tmp = nums[idx];
			nums[idx] = nums[max];
			nums[max] = tmp;			
			heapify(nums, max, len);
		}
		
	}
	
	
	public void heapSort(int[] nums) {
		
		for (int i=nums.length/2;i>=0;i--) {
			heapify(nums, i, nums.length-1);
		}
		
		for (int i=nums.length-1;i>=1;i--) {
			int temp = nums[i];
			nums[i] = nums[0];
			nums[0] = temp;
			heapify(nums, 0, i-1);			
		}
	}
	
	
	
    public int[] twoSumA(int[] nums, int target) {
    	
    	
    	
    	boolean isAscending = true;
        for (int i=1;i<nums.length;i++) {
        	if (nums[i-1]>nums[i]) {
        		isAscending = false;
        		break;
        	}
        }
        
        if (!isAscending) {
        	heapSort(nums);
        }
        
        
        for (int c:nums) {
        	System.out.format("%d ", c);
        }
        System.out.println();
        
        
        
        int idx = 0, i = 0;
    	boolean isFound = false;        
        for (i=nums.length-1;i>=1;i--) {
        	
        	int resTarget = target - nums[i];
        	idx = i/2;
        	while (true) {

        		if (nums[idx]==resTarget) {
        			isFound = true;
        			break;
        		} 
        		
        		if (idx+1== i || idx==0) {
        			break;
        		}
        		
        		if (nums[idx]<resTarget) {
        			idx = (idx + i) / 2;
        		} else {
        			idx = idx /2;
        		}
        	}        	
        	
        	if (isFound) {
        		break;
        	}
        }
        
        return new int[]{idx+1, i+1};
    }	
	
	
    public int[] twoSum(int[] nums, int target) {
    	
    	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    	
    	for (int i=0;i<nums.length;i++){
    		hm.put(nums[i], i);
    	}
    	
    	int a=0, b=0;
    	for (int j=0;j<nums.length;j++) {
    		int resTarget = target - nums[j];	
    		if (hm.containsKey(resTarget)) {    			
    			a = j+1;
    			b = hm.get(resTarget)+1;
    			if (a!=b)
    				break;
    		}
    	}
    	
    	int[] ret;
    	if (a<b) {
    		ret = new int[]{a,b};
    	} else {
    		ret = new int[]{b,a};
    	}
    	return ret;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution su = new Solution();
		//int[] ret = su.twoSum(new int[]{15,11,7,2},9);
		int[] ret = su.twoSum(new int[]{3,2,4},6);
		for (int c:ret) {
			System.out.format("%d ", c);
		}
		System.out.println();
	}

}
