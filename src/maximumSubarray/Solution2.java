package maximumSubarray;

public class Solution2 {

    public int maxSubArray(int[] nums) {

    	if (nums.length == 1) 
    		return nums[0];
    	
    	
    	int curMax = nums[0], finMax = nums[0];
    	
    	for (int i=1;i<nums.length;i++) {
    		int c = nums[i];
    		if (c>curMax+c)
    			curMax = c;
    		else
    			curMax = curMax+c;
    		
    		if (curMax>finMax)
    			finMax = curMax;	
    	}
    	
    	
    	return finMax;
    }
	
	
	public static void main(String[] args) {


		Solution2 su = new Solution2();
		
		int a[] =  {-2, -3, -4, -1, -2, -1, -5, -3};
		
		System.out.println(su.maxSubArray(a));
		
	}

}
