package uniqueBinarySearchTrees;

public class Mysolution {

	public static class Solution {
	    public int numTrees(int n) {
	    	
	    	if (n == 0) {
	    		return 1;
	    	} else if (n == 1) {
	    		return 1;
	    	} else if (n == 2) {
	    		return 2;
	    	} else {
	    		int sum = 0, left = 0;
	    		while ( left < n/2) {
	    			sum += numTrees(left) * numTrees(n-1-left);
	    			left++;
	    		}
	    		sum *= 2;
	    		if (n%2!=0) {
	    			sum += numTrees(left) * numTrees(n-1-left);
		    	}
	    		return sum;
	    	}	        
	    }
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mysolution.Solution su = new Mysolution.Solution();
		
		for(int i=0;i<10;i++) {
			System.out.println(i + ":" + su.numTrees(i));
		}
	}

}
