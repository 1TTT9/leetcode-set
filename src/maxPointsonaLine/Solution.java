package maxPointsonaLine;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {


	
    public int maxPoints(Point[] points) {
    	
    	int max = 0;
    	
    	HashMap<Double, Integer> hs = new HashMap<Double, Integer>();
    	
    	for (int i=0; i<points.length; i++) {
    		
    		hs.clear();
    		
    		Point m1 = points[i];
    		int duplicated = 1;
    		int vertical = 0;
    		
    		for (int j=i+1; j<points.length; j++) {
    			Point m2 = points[j];
    			
    			if (m1.x == m2.x) {
    				if (m1.y == m2.y) {
    					duplicated += 1;
    				} else {
    					vertical += 1;
    				}
    			} else {
    				
    				//double slope = 1.0 * (m1.y - m2.y) / (m1.x - m2.x);
    				
    				
    				double slope = 0;
    				if (m1.y != m2.y) {
    					slope = 1.0 * (m1.y - m2.y) / (m1.x - m2.x);
    				}
    				
    				if (hs.containsKey(slope)) {
    					hs.put(slope, hs.get(slope)+1);
    				} else {
    					hs.put(slope, 1);
    				}    				
    			}
    			
    		}
    		
    		if (max<vertical+duplicated) {
    			max = vertical+duplicated;
    		}
    		
    		for (int c:hs.values()) {
    			if (max<c+duplicated) 
    				max = c+duplicated;
    		}
    	}    	
    	return max;        
    }	
	
	public static void main(String[] args) {

		
		Solution su = new Solution();
		
		//[[2,3],[3,3],[-5,3]]
		Point[] pts = new Point[]{new Point(2,3), new Point(3,3), new Point(-5,3)};
		
		System.out.println(su.maxPoints(pts));
	}

}
