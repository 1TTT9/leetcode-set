package singleNumberII;

public class Solution {

    public int singleNumber(int[] A) {
    	
    	for (int i=A.length/2; i>=1;i--) {
    		heapify(A, i, A.length);
    	}

    	int ret = 0, c = 0;
    	for (int i=A.length;i>=1;i--) {
    		ret = A[0];
    		swap(A, 1, i);
    		c++;
    		if (c==3) {
    			if ( A[i-1] != A[i] || A[i-1] != A[i+1]) { 
	    			if (A[i-1] == A[i]) {
	    				ret = A[i+1];
	    			} else if (A[i-1] == A[i+1]) {
	    				ret = A[i];	
	    			} else {
	    				ret = A[i-1];
	    			}
	    			break;
    			}
    			c = 0;
    		}
    		heapify(A, 1, i-1);
    	}    	
    	return ret;
    }
    
    public void heapify(int[] A, int i, int len) {
    	
    	int left = i*2, right = left+1, max = i;
    	
    	if (left <= len ) {

    		if (A[max-1] < A[left-1]) {
    			max = left;
    		}
    	}
    	
    	if (right <= len) {
    		
    		if (A[max-1] < A[right-1]) {
    			max = right;
    		}    		
    	}
    	
    	if ( max != i ) {
    		swap(A, i, max);
    		if (max*2 <= len) {
    			heapify(A, max, len);
    		}
    	}
    }
    
    public void swap(int[] A, int x, int y) {
    	int t = A[x-1];
    	A[x-1] = A[y-1];
    	A[y-1] = t;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution su = new Solution();

		int[] A = new int[]{3,2,4,1,5,7};
		//System.out.println(su.singleNumber(A));
		
		A = new int[]{3,8,3,8,9,8,3};
		System.out.println(su.singleNumber(A));		
		
		A = new int[]{9,9,9,7,7,7,3,3,3,1};
		System.out.println(su.singleNumber(A));
		
		A = new int[]{1,9,9,9,7,7,7,3,3,3};
		System.out.println(su.singleNumber(A));						

		A = new int[]{9,9,9,7,7,7,3,3,3, 289};
		System.out.println(su.singleNumber(A));								
	}

}
