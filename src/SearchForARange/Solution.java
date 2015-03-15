package SearchForARange;

public class Solution {
	
    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[]{-1,-1};
        
        if (A.length==0) 
        	return ret;
        
        int bp=0, ep=A.length;
        int lbp = 0, lep = 0;
        int rbp = 0, rep = ep;        
        int mid = 0;
        while (true) {
        	mid = (bp+ep)/2;
        	if (bp == mid)
        		break;
        	
        	if (A[mid] == target)
        		break;        		
        	else {
        		if (A[mid] < target) { 
        			bp = mid;
        			lbp = bp;
        		} else { 
        			ep = mid;
        			rep = ep;
        		}
        	}
        }
        
        if (A[mid] != target) 
        	System.out.println("N/A");
        else
        	System.out.println(mid);        	
                
        if (A[mid] != target) 
        	return ret;
        

        lep = mid;
        int lmid = 0;        
        while (true) {      	
        	lmid = (lbp+lep)/2;
        	if (lbp == lmid)
        		break;
	        if (A[lmid] < target)
	        	lbp = lmid;
	        else 
	        	lep = lmid;        	
	    }
        if (A[lmid] == target) {
        	lep = lmid;
        }
        
        rbp = mid;
        int rmid = 0;
        while (true) {
        	rmid = (rbp+rep)/2;
        	if (rbp == rmid)
        		break;
	        if (A[rmid] <= target)
	       		rbp = rmid;
	       	else 
	       		rep = rmid;        	
	    }

        ret = new int[]{lep, rbp};
        return ret;
    }
    
    
    public static void main(String...args){
    	Solution su = new Solution();
    	
    	int[] A = new int[]{8,8};
    	int target = 8;
    	
    	int[] ret = su.searchRange(A, target);
    	
		System.out.println("====================");
    	for (int s:ret) {
    		System.out.println(new Integer(s));
    	}
    	
    }
}
