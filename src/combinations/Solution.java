package combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	
	public void findC0(int n, int k, int i, int len, List<Integer> tmp, List<List<Integer>> ret) {
		
		tmp.add(i);			
		if (tmp.size() == k) {
			List<Integer> tmp2 = new ArrayList<Integer>();
			for (Integer a:tmp) {
				tmp2.add(a);
			}
			ret.add(tmp2);
		} else {
			for (int j=i+1;j<=n;j++) {
				findC0(n, k, j, len, tmp, ret);
			}	
		}
		tmp.remove(tmp.size()-1);
	}
	

	public void findC(int n, int k, int i, List<Integer> tmp, List<List<Integer>> ret) {
		
		if (tmp.size() == k) {
			ret.add(new ArrayList<Integer>(tmp));
		} else {
			
			for (int j=i;j<=n;j++) {
					tmp.add(j);			
					findC(n, k, j+1, tmp, ret);
					tmp.remove(tmp.size()-1);
			}
		}
		
	}	
	
	
    public List<List<Integer>> combine(int n, int k) {
    	
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	if (n<k) {
    		return ret;
    	}
    	
    	findC(n,k,1,new ArrayList<Integer>(), ret);

        return ret;
    }	

	public static void main(String[] args) {

		Solution su = new Solution();
		
		System.out.println(su.combine(5,5));
		
		

	}

}
