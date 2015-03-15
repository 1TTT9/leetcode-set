package generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	
    public List<String> generateParenthesis0(int n) {
        
    	List<String> ret = new ArrayList<String>();
    	
    	if (n == 0) {
    		return ret;
    	}
 
    	int cur = 0, prev = 0;
    	String str = "";
    	for (int i=1;i<=n;i++) {
			prev = cur;
			cur = 0;
			
			if (prev == 0) {
				str = "";
				ret.add( "(" + str + ")");
				cur+=1;
			} else {			
				for (int j=1;j<=prev;j++) {
					str = ret.remove(0);
					ret.add( "(" + str + ")");
					cur+=1;					
					ret.add( "()" + str );
					cur+=1;																	
					if (j<prev) {
						ret.add( str + "()" );    				
						cur+=1;
					}
				}
			}
		}
    	return ret;
    }	
	
    
    public List<String> generateParenthesis(int n) {
    	
    	
    	List<String> ret = new ArrayList<String>(), tmp = null;
    	
    	if (n == 0) {
    		return ret;
    	}
 
    	int cur = 0, prev = 0;
    	String str = "";
    	for (int i=1;i<=n;i++) {
			prev = cur;
			cur = 0;
			
			tmp = new ArrayList<String>(ret);			
			//for (String s:tmp) { System.out.println("--" + s); }			
			ret.clear();
			//for (String s:tmp) { System.out.println("++" + s); }
						
			if (prev == 0) {
				str = "";
				ret.add( "(" + str + ")");
				cur+=1;
			} else {			
				for (int j=1;j<=prev;j++) {
					str = tmp.get(j-1);
					ret.add( "(" + str + ")");
					cur+=1;
				}
				for (int j=1;j<prev;j++) {
					str = tmp.get(j-1);
					ret.add(  str + "()");
					cur+=1;
				}				

				for (int j=1;j<prev;j++) {
					str = tmp.get(j-1);
					ret.add( "()" + str );
					cur+=1;
				}
				
				str = tmp.get(prev-1);
				ret.add( "()" + str );
				cur+=1;				
			}
		}
    	return ret;    	
    }
    
	public static void main(String[] args) {

		Solution su = new Solution();
		
		List<String> ret = su.generateParenthesis(3);
		
		
		for (int i=1;i<=ret.size();i++) {
			System.out.print(ret.get(i-1));
			if (i<ret.size()) {
				System.out.print(",");				
			}
		}

	}

}
