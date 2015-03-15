package maximumSubarray;

public class Solution {

    public static int maxSubArray(int[] A) {

    	return findMax(A, A.length);

    }
    
    public static int findMax(int[] A, int len) {
    	
    	if (len == 1) {
    		return A[len-1];
    	}
    	
    	else {
    		int max = A[len-1], sum = max;
    		for (int i=len-1;i>=1;i--) {
    			sum += A[i-1];
    			if (sum>max) {
    				max = sum;
    			}
    		}
    		int prev = findMax(A, len-1);
    		if (max < prev) {
    			max = prev;
    		}    		
    		return max;    		
    	}
    }
    
    public static int findMaxIter(int[] A) {
    	
    	int i = 1, max = A[i-1], p = i, q = i, sum = 0;
    	for (i=2;i<=A.length;i++) {    		
    		sum = 0;
    		for (int j=i;j>=q;j--) {
    			sum += A[j-1];
    			if (max < sum) {
    				max = sum;
    				p = j;
    			}
    		}
    		q = p;
    	}
    	return max;
    }


    public static int findMaxDP(int[] A) {
    	
    	int i = 1, max_so_far = 0, max_here = 0;
    	int keep_max = A[i-1];
    	for (i=1;i<=A.length;i++) {
    		
    		if (keep_max < A[i-1]) {
    			keep_max = A[i-1];
    		}
    		
    		max_here = max_here + A[i-1];
    		if (max_here < 0) {
    			max_here = 0;
    		} 		
    		else if (max_here > max_so_far ) {
    			max_so_far = max_here;
    		}
    	}
    	if (keep_max < 0) {
    		return keep_max;
    	} else {
    		return max_so_far;
    	}
    }

	
	public static void main(String[] args) {

		int[] A = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(A));
		System.out.println(findMaxIter(A));		
		System.out.println(findMaxDP(A));				
		
		A = new int[] {1,-8,4};
		System.out.println(maxSubArray(A));
		System.out.println(findMaxIter(A));		
		System.out.println(findMaxDP(A));
		
		A = new int[] {-2,4,-3, 4};
		System.out.println(maxSubArray(A));		
		System.out.println(findMaxIter(A));		
		System.out.println(findMaxDP(A));
		
		A = new int[] {-299};
		System.out.println(maxSubArray(A));		
		System.out.println(findMaxIter(A));
		System.out.println(findMaxDP(A));
		
		A = new int[] {-299, -1};
		System.out.println(maxSubArray(A));		
		System.out.println(findMaxIter(A));				
		System.out.println(findMaxDP(A));
		
	}

}
