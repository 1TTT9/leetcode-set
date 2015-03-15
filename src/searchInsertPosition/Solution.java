package searchInsertPosition;

public class Solution {

	
    public static int searchInsert(int[] A, int target) {
        
    	if (A.length == 0) {
    		return 0;
    	}else if (A.length == 1) {
    		if (target <= A[0]) {
    			return 0;
    		} else {
    			return 1;
    		}
    	}
    	
    	int offset = 0, length = A.length-1, i = 0;
    	while (true) {
    		
    		if ( offset == length-1 ) {    			
    			if (target <= A[offset]) {
    				i = offset;
    			} else if (A[offset] < target && target <= A[length]){
    				i = length;
    			} else {
    				i = length+1;
    			}
    			break;
    		}

    		i = (offset + length)/2;
    		if ( A[i] == target ) {
    			break;
    		} else {
    			if (A[i] < target) {
    				offset = i;
    			} else {
    				length = i;
    			}
    		}
    	}
    	return i;    	
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1};
		System.out.println( searchInsert(a, -5) );
		System.out.println( searchInsert(a, 1) );
		System.out.println( searchInsert(a, 2) );
		System.out.println( searchInsert(a, 12) );
		System.out.println( searchInsert(a, 13) );
		System.out.println( searchInsert(a, 15) );
	}

}
