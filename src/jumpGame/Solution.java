package jumpGame;

public class Solution {
	
	/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
	 */

	
    public boolean canJump(int[] A) {
        
        boolean isMovable = true;
        int rest = 1, r= 0;
        for (int i=0;i<A.length;i++) {
            rest-=1;        	
        	r = A[i];
            if (A.length-i <= r)  break;            	        	
        	
            if (r>rest) rest = r;
            
            if (rest==0) {
                if (i < A.length-1)  
                	isMovable = false;
                break;
            }
        }
        
        return isMovable;
    }	
	
	public static void main(String[] args) {
		
		Solution su = new Solution();
		
		int[] A = new int[]{3,2,1,0,4};
		System.out.println(su.canJump(A));
		
		A = new int[]{3,2,1,1,4};
		System.out.println(su.canJump(A));		

		A = new int[]{0};
		System.out.println(su.canJump(A));		

		A = new int[]{1,0};
		System.out.println(su.canJump(A));		
		
		A = new int[]{0,100,100};
		System.out.println(su.canJump(A));				
		
		A = new int[]{1,0,100};
		System.out.println(su.canJump(A));				
	}

}
