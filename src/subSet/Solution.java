package subSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	
    public List<List<Integer>> subsets(int[] S) {
    	
    	ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
       	    	
    	List<int[]> R = new ArrayList<int[]>();
    	   	
    	for (int i=0;i<S.length;i++) {
    		R.add(new int[]{S[i]});
    	}
 
    	List<Integer> tmp = null;
    	while (true) {
    		
    		tmp = new ArrayList<Integer>();    		
    		if (R.isEmpty()) {
    	     	ret.add(tmp);
    			break;
    		}
    		int[] s = R.remove(0);

    		for (int i:s) {
    			tmp.add(new Integer(i));
    		}
    		ret.add(tmp);
    		
        	for (int j=0;j<S.length;j++) {
        		
        		for (int k:s){
        			if (S[j] == k) {
        				continue;
        			}
        		}
        		        		
        		if(S[j] > s[s.length-1]) {
        			int[] t = new int[s.length+1];
        			t = Arrays.copyOf(s, s.length+1);
        			t[s.length] = S[j];
        			R.add(t);
        		}
        	}
    	}
    	
    	return (List<List<Integer>>)ret;
    }
	
	public static void main(String[] args) {
		
		int[] s = new int[]{};
		
		Solution su = new Solution();
		List<List<Integer>> ret = su.subsets(s);
		
		System.out.println(ret);
	}

}
