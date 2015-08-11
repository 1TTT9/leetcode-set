package letterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	
	public void goDFSA(String digits, int idx, LinkedList<Integer> path, List<String> ret) {
		
		/*
		 * 48:1
		 * 65:A
		 * 97:a
		 */
		
		if (idx == digits.length()) {
			String tmp = "";
			for (Integer t:path) {
				tmp += (char)(t.intValue());
				
			}
			ret.add(tmp);
			return;
		}

		int p = (int)(digits.charAt(idx))-48;
		
		int shift = 0, d = 3;
		if (p==7) {
			d = 4;
		} else if (p==8) {
			shift = 1;
		} else if (p==9) {
			shift = 1; d = 4;
		}

		for (int j=0;j<d;j++) {
			int q = (p-2)*3+j+97+shift;
			path.add(q);
			goDFSA(digits, idx+1, path, ret);
			path.removeLast();
		}			
				
		/*
		if (p<7) {			
			for (int j=0;j<3;j++) {
				int q = (p-2)*3+j+97;
				path.add(q);
				goDFS(digits, idx+1, path, ret);
				path.removeLast();
			}			
		} else {
			
			if (p==7) {
				for (int j=0;j<4;j++) {
					int q = (p-2)*3+j+97;
					path.add(q);
					goDFS(digits, idx+1, path, ret);
					path.removeLast();
				}							
			} else if (p==8) {
				for (int j=0;j<3;j++) {
					int q = (p-2)*3+j+97+1;
					path.add(q);
					goDFS(digits, idx+1, path, ret);
					path.removeLast();
				}											
			} else if (p==9) {
				for (int j=0;j<4;j++) {
					int q = (p-2)*3+j+97+1;
					path.add(q);
					goDFS(digits, idx+1, path, ret);
					path.removeLast();
				}															
			}
		}
		*/
	}
	
	public List<String> letterCombinationsA(String digits) {
		
		List<String> ret = new ArrayList<String>();
		
		if (digits.length() == 0) {
			return ret;
		}
		
		LinkedList<Integer> path = new LinkedList<Integer>();
		goDFSA(digits, 0, path, ret);
		
		return ret;
        
    }	
	
	public void goDFS(List<String> tbl, String digits, int idx, LinkedList<Character> path, List<String> ret) {
		
		if (idx == digits.length()) {
			String t = "";
			for (char c:path) {
				t += c;
			}
			ret.add(t);
			return;
		}
		
		int j = (int)digits.charAt(idx)-48;
		
		String str = tbl.get(j);
		for (int i=0;i<str.length();i++) {
			
			path.add(str.charAt(i));
			
			goDFS(tbl, digits, idx+1, path, ret);
			
			path.removeLast();			
		}
		
	}
	
	public List<String> letterCombinations(String digits) {
		
		List<String> ret = new ArrayList<String>();
		
		if (digits.length() == 0) {
			return ret;
		}
		
		
		List<String> tbl = new ArrayList<String>(
				Arrays.asList("", "", "abc","def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
		
		LinkedList<Character> path = new LinkedList<Character>();
		goDFS(tbl, digits, 0, path, ret);
		
		return ret;
        
    }		
	

	public static void main(String[] args) {
		
		Solution su = new Solution();
		
		List<String> ret = su.letterCombinations("89");
		
		for (String s:ret) {
			System.out.println(s);
		}
		

	}

}
