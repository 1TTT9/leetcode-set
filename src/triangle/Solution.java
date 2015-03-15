package triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        
    	int ret = 0;
    	// Everything in Java not explicitly set to something, is initialized to a zero value. 
    	// http://stackoverflow.com/questions/3426843/what-is-the-default-initialization-of-an-array-in-java
    	int [] last = null;
    	int [] curr = null;
    	List<int[]> buff = new ArrayList<int[]>(Arrays.asList(new int[triangle.size()], new int[triangle.size()]));
    	int idx = 0;    	
    	List<Integer> row = null;
    	int min = 0;
    	for (int i=0;i<triangle.size();i++) {
    		last = buff.get((idx+1)%buff.size());
    		curr = buff.get(idx);   		
    		row = triangle.get(i);
    		for (int j=0;j<row.size();j++) {
    			if (j>=1) {
    				min = last[j-1];    				
    				if (j<i-1) {
    					if (min > last[j])
    						min = last[j];
    				}
    			} else {
    				min = last[j];
    			}
    			curr[j] = min + row.get(j).intValue();
    		}
    		idx = (idx+1) % buff.size();    		
    		for(int x:curr) {
    			System.out.print(x);
    			System.out.print(",");
    		}
    		System.out.println();
    	}
    	last = buff.get((idx+1)%buff.size());
    	min = last[0];
    	for (int i=1;i<last.length;i++) {
    		if (last[i]<min) 
    			min = last[i];
    	}
    	ret = min;
    	return ret;
    	
    }
    
    public int minimumTotal2(List<List<Integer>> triangle) {
        
    	int ret = 0;
    	int [] last = new int[triangle.size()];
    	List<Integer> row = null;
    	int min = 0;
    	int c0 = 0, c1 = 0;
    	for (int i=0;i<triangle.size();i++) {    		
    		row = triangle.get(i);
    		for (int j=0;j<row.size();j++) {		
    			if (j==0) {
    				c0 = 0;
    			} else {
    				c0 = c1;
    			}    			
    			if (j<i) {
    				c1 = last[j];
    			}    			
    			if (j==0) {
    				min = c1;
    			} else {
    				min = c0;
    				if (min>c1)
    					min = c1;
    			}
				last[j] = min + row.get(j).intValue();
    		}
    	}
    	min = last[0];
    	for (int i=1;i<last.length;i++) {
    		if (last[i]<min) 
    			min = last[i];
    	}
    	ret = min;
    	return ret;    	
    }    
    
	public static void main(String[] args) {
		
		Solution su = new Solution();
		
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		triangle.add(new ArrayList<Integer>(Arrays.asList(2)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(3,4)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
		
		System.out.println(su.minimumTotal(triangle));
		System.out.println(su.minimumTotal2(triangle));
		
		triangle = new ArrayList<List<Integer>>();
		triangle.add(new ArrayList<Integer>(Arrays.asList(1)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(2,3)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(7,8,9,10)));
		
		System.out.println(su.minimumTotal(triangle));		
		System.out.println(su.minimumTotal2(triangle));
	}

}
