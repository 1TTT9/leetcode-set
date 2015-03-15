package searcha2DMatrix;

public class Solution {

	
    public boolean searchMatrix(int[][] matrix, int target) {
        
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int i = 1, j = m;
    	boolean ret =false;
    	
    	int k = 0;
    	while (true) {
    		k = matrix[(i+j)/2-1][0];
    		if ( k == target) {
    			ret = true;
    			break;
    		} else if (k > target) {
    			j = (i+j)/2;
    		} else {
    			i = (i+j)/2;
    		}
    		
    		if (i==j) {
    			break;
    		} else if (i+1==j) {
    			if (matrix[j-1][n-1]<target || matrix[i-1][0]>target) {
    				//excluded
    			}else{
    				if (matrix[j-1][0]<target) {
    					i = j;
    				}else {
    					//matrix[i-1][0]<target
    					j = i;
    				}    				
    			}
    			break;
    		}
    	}    
    	
    	if (ret == true || i!=j ) {
    		return ret;
    	} else {
        	int x = 1, y = n;
        	k = 0;
        	while (true) {    		
        		k = matrix[i-1][(x+y)/2-1];
        		if ( k == target) {
        			ret = true;
        			break;
        		} else if (k > target) {
        			y = (x+y)/2;
        		} else {
        			x = (x+y)/2;
        		}
        		
        		if (x==y) {
        			break;
        		} else if (x+1==y) {
        			if (matrix[i-1][x-1] == target || matrix[i-1][y-1] == target) {
        				ret = true;
        			}        			
        			break;
        		}
        	}        	
        	return ret;
    	}    	
    }	
	
	public static void main(String[] args) {


	}

}
