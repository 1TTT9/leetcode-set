package setMatrixZeroes;

public class Solution {

    public void setZeroes1(int[][] matrix) {
     
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	
    	for (int i=1;i<=m;i++) {
    		for (int j=1;j<=n;) {
    			
    			if (matrix[i-1][j-1] == 0) {
    				if (matrix[i-2][j-1] == 0) {
    					//pass
    				} else {
    					
    					for(int k=1;k<=m;k++) {
    						matrix[k-1][j-1] = 0;
    					}
       					for(int k=1;k<=n;k++) {
    						matrix[i-1][k-1] = 0;
    					}
    					
    					j=n+1;
    				}
    			}
    			j++;
    		}
    	}
    	
    }	

    
    public void setZeroes(int[][] matrix) {
        
    	boolean hasZeroFirstRow = false, hasZeroFirstCol = false;
    	
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	for (int i=0;i<m;i++) {
    		if (matrix[i][0] == 0) {
    			hasZeroFirstCol = true;
    			break;
    		}
    	}
    	
    	for (int j=0;j<n;j++) {
    		if (matrix[0][j] == 0) {
    			hasZeroFirstRow = true;
    			break;
    		}
    	}    	
    	
    	for (int i=1;i<m;i++) {
    		for (int j=1;j<n;j++) {
    			if (matrix[i][j] == 0) {
    				matrix[i][0] = 0;
    				matrix[0][j] = 0;
    			}
    		}
    	}
    	
    	for (int i=1;i<m;i++) {
    		if (matrix[i][0] == 0) {
    			for(int j=1;j<n;j++) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	
    	for (int j=1;j<n;j++) {
    		if (matrix[0][j] == 0) {
    			for(int i=1;i<m;i++) {
    				matrix[i][j] = 0;
    			}
    		}
    	}    	
    	
    	if (hasZeroFirstRow) {
    		for (int j=0;j<n;j++) {
    			matrix[0][j] = 0;
    		}
    	}

    	
    	if (hasZeroFirstCol) {
    		for (int i=0;i<m;i++) {
    			matrix[i][0] = 0;
    		}
    	}    	
    }	    
    
	public static void main(String[] args) {


		Solution  su = new Solution();
		
		int[][] mat = {{1,2,3}, {4,0,5}, {6,7,8}};
		
		su.setZeroes(mat);
		
    	int m = mat.length;
    	int n = mat[0].length;
    	for (int i=1;i<=m;i++) {
    		for (int j=1;j<=n;j++) {
    			System.out.print(mat[i-1][j-1]+",");
    		}
    		System.out.println();
    	}
	}

}
