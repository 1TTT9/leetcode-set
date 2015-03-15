package minimumPathSum;

public class Solution {
	
	
    public int minPathSum(int[][] grid) {
     
    	int m = grid.length;
    	int n = grid[0].length;
    	    	
    	int[] cur = new int[n], prev = new int[n];
    	int i = 1, j = 1;
		cur[j-1] = grid[i-1][j-1];
    	for (j=2;j<=n;j++) {
    		cur[j-1] = cur[j-2] + grid[i-1][j-1] ;    			
    	}
    	prev = cur;
    	for (i=2;i<=m;i++) {
    		j=1;
    		cur[j-1] = prev[j-1] + grid[i-1][j-1];
    		for (j=2;j<=n;j++){
    			int min = prev[j-1];
    			if (min> cur[j-2] ) {
    				min = cur[j-2];
    			}
    			cur[j-1] = min + grid[i-1][j-1];
    		}
    		prev = cur;
    	}
    	return cur[n-1];
    }	

	public static void main(String[] args) {

		int[][] a = {{2,1,5}};
	
		
		Solution su = new Solution();
		
		System.out.println(su.minPathSum(a));		
	}

}
