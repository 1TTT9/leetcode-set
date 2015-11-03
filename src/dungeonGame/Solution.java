package dungeonGame;

public class Solution {

	public int calculateMinimumHP(int[][] dungeon) {

		int m = dungeon.length, n = dungeon[0].length;
		
		int[][] hp = new int[m][n];

		hp[m-1][n-1] = Math.max(-dungeon[m-1][n-1], 1);
		
		//last col;
		for (int i=0;i<m-1;i++) {
			
		}
		
		
    	return hp[0][0];
    }
	
    public int calculateMinimumHP0(int[][] dungeon) {
    	
    	int ret = 0;
    	
    	int N = dungeon[0].length;
    			
    	int[][] rest = new int[2][N];
    	
    	int curr = 0, next = curr;
    	int i =0, j = 0;    	
    	if (dungeon[i][j]>0) {
    		rest[curr][j] = dungeon[i][j];
    	} else {
    		rest[curr][j] = 1;    		
    		ret += 1 - dungeon[i][j];
    	}    	
    	for (j=1;j<N;j++) {
    		if (rest[curr][j-1]+dungeon[i][j]>0) {
    			rest[curr][j] = rest[curr][j-1]+dungeon[i][j];
    		} else {
    			rest[curr][j] = 1;
    			ret += 1 - (dungeon[i][j]+rest[curr][j-1]);
    		}
    	}
    	
    	for (i=1; i<dungeon.length; i++) {
    		next = (curr+1)%2;	
    		j = 0;	
        	if (rest[curr][j] + dungeon[i][j]>0) {
        		rest[curr][j] = rest[curr][j] + dungeon[i][j];
        	} else {
        		rest[curr][j] = 1;    		
        		ret += 1 - (dungeon[i][j]+rest[curr][j]);
        	}
        	
        	for (j=1;j<N;j++) {
        		
        		int top = rest[curr][j] + dungeon[i][j];
        		int left = rest[next][j-1] + dungeon[i][j];
        		
        		int max = Math.max(top, left);
        		
        		if (max>0) {
        			rest[curr][j] = max;
        		} else {
        			rest[curr][j] = 1;
        			ret += 1 - (dungeon[i][j]+max);
        		}
        	}
    		curr = (curr+1)%2;    		
    	}
    	return ret;
    }
	
    public int calculateMinimumHPA(int[][] dungeon) {

    	int ret = 0;
    	
    	int N = dungeon[0].length;
    	
    	int[][] sum = new int[2][N];
    	
    	int ci = 0, ni = ci;    	
    	int j = 0;
    	sum[ci][j] = Math.max(1,dungeon[ci][j]);
    	for (j=1;j<N;j++) {
    		sum[ci][j] =  Math.abs( sum[ci][j-1] + dungeon[ci][j] );
    	}    	
    	for (int i=1; i<dungeon.length; i++)
    	{
    		ni = (ci+1)%2;
    		j=0;
    		sum[ni][j] = sum[ci][j] + dungeon[i][j];
    		for (j=1; j<N; j++) {
    			int min = (int) Math.asin(  sum[ci][j]+dungeon[i][j]);
    			if (min > (int) Math.asin(sum[ni][j-1]+dungeon[i][j])) {
    				min = (int) Math.asin(sum[ni][j-j]+dungeon[i][j]);
    			}
    			sum[ni][j] = min;    			
    		}    		
    		ci = (ci+1)%2;
    	}
    	
    	ret = 1 - sum[ni][N-1];
    	if (ret <0) {
    		ret = 1;
    	}
    	return ret;    	
    }	
	
	
	public static void main(String[] args) {


	}

}
