package grayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> grayCode(int n) {
    	
    	List<Integer> ret = new ArrayList<Integer>();    	
    	
    	if (n==0) {
    		return ret;
    	}
    	
    	ret.add(0);

    	int k=1;    
    	int gc = 0;
    	while (true) {
    		if (k>n) {
    			break;
    		}
    		int m = 1<<(k-1);
    		for(int i=m;i>=1;i--) {
    			gc = m + ret.get(i-1);
    			ret.add(gc);
    		}
    		k++;
    	}
    	return ret;        
    }	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();

		List<Integer> m = su.grayCode(4);
		
		for (Integer i:m) {
			System.out.println(i);
		}
	}

}
