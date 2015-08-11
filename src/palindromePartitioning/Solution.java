package palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	
	List<List<String>> iterPA(String n) {
		
		List<List<String>> ret = new ArrayList<List<String>>();
		
		if (n == null || n.length() == 0) {
			return ret;
		}
		
		int[][] paTBL = new int[n.length()][n.length()];

		List<String> temp = new ArrayList<String>();
		for (int len=1;len<=n.length();len++) {
			temp.clear();
			for (int i=0;i<n.length()-len+1;i++) {
				int j = i+len-1;
				
				if (n.charAt(i) != n.charAt(j)) {
					paTBL[i][j] = 0;
				} else {
					if (len <=2) {
						paTBL[i][j] = 1;
					} else {
						paTBL[i][j] = paTBL[i+1][j-1];
					}
					if (paTBL[i][j] == 1) {
						//note: substring() doesn't include the endWith-th character.
						temp.add(n.substring(i, j+1));
					}
				}
			}
			if (temp.size()>0) {
				ret.add(new ArrayList<String>(temp));
			}
		}
		return ret;
	}
	
	boolean isPA(String s) {
		
		int p =0, q= s.length()-1;
		
		boolean isPAed = true;
		while (p<q) {
			if (s.charAt(p) == s.charAt(q)) {
				p+=1;
				q-=1;
			}else{
				isPAed = false;
				break;
			}
		}
		return isPAed;
	}
	
	void traverseDFS(String s, int idx, List<String> tmp, List<List<String>> ret) {
				
		if (idx == s.length()) {
			ret.add(new ArrayList<String>(tmp));
			return;
		}
		
		for (int j=idx;j<s.length();j++) {
			if (isPA(s.substring(idx, j+1))) {
				tmp.add(s.substring(idx, j+1));				
				traverseDFS(s, j+1, tmp, ret);
				tmp.remove(tmp.size()-1);
			}
		}
		
	}
	
	
	List<List<String>> findPA(String s) {
	
		List<List<String>> ret = new ArrayList<List<String>>();
		
		if (s == null || s.length() == 0) {
			return ret;
		}
				
		traverseDFS(s, 0, new ArrayList<String>(), ret); 
		
		return ret;
		
	}
	
	public List<List<String>> partition(String s) {

		//return iterPA(s);
		
		return findPA(s);
		
    }
	
	
	public static void main(String[] args) {
		Solution su = new Solution();
		
		List<List<String>> r = su.partition("aabc");
		
		
		for (List<String> ls:r) {
			for (String s:ls) {
				System.out.format("%s ", s);
			}
			System.out.println();
		}

	}

}
