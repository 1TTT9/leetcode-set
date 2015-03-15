package uniquePaths;

public class Solution {

    public int uniquePaths(int m, int n) {
        
    	int[] prev = new int[n];
    	int[] cur = new int[n];    
    	// S(1,1)
    	cur[0] = 1;
    	for (int j=1;j<=m;j++) {    		
    		for (int i=1;i<=n;i++) {    			
    			if (i==1 && j==1) {
    				cur[i-1] = 1;
    			}
    			else {
		    		cur[i-1] = 0;
		    		//s(j-1,i)
		    		if (j-1>=1) {
		    			cur[i-1] += prev[i-1];
		    		}
		    		//s(j,i-1)
		    		if (i-1>=1) {
		    			cur[i-1] += cur[i-2];
		    		}
    			}
	    		prev[i-1] = cur[i-1];    			
    		}
    	}    	
    	
    	return cur[n-1];
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		
		System.out.println(su.uniquePaths(2,5));
	}

}
