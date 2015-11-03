package combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	
	public void swap(int[] a, int p, int q) {
		int temp = a[p];
		a[p] = a[q];
		a[q] = temp;				
	}
	
	public void heapify(int[] a, int i, int len) {
		
		int imax = i, left = 2 * i, right = left + 1;
		
		if (left<=len && a[imax]<a[left]) imax = left;
		if (right<=len && a[imax]<a[right]) imax = right;
		if(imax != i) {
			swap(a, imax, i);			
			heapify(a, imax, len);
		}
		
	}
	
	public void heapSort(int[] a) {
		
		for (int i=a.length/2;i>=0;i--) {
			heapify(a, i, a.length-1);
		}
		
		for (int i=a.length-1;i>0;i--) {
			swap(a, 0, i);
			heapify(a, 0, i-1);
		}

	}
	
	public void goDFS(int[] a, int target, int idx, LinkedList<Integer> path, List<List<Integer>>ret) {
		
		if (target == 0) {
			ret.add(new LinkedList<Integer>(path));
			return;
		}
		
		int resTarget = 0;
		for (int i=idx; i<a.length; i++) {
			
			resTarget = target - a[i];
			
			if (resTarget<0) {
				break;
			}
			
			if (i>=idx+1 && a[i] == a[i-1]) {
				continue;
			}
			
			path.addLast(a[i]);
			
			goDFS(a, resTarget, i+1, path, ret);
			
			path.removeLast();
		}
		
	}
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	if (target == 0 || candidates.length == 0) {
    		return ret;
    	}
    	
    	boolean isAscending = true;    	
    	for (int i=1; i<candidates.length; i++) {
    		if (candidates[i-1]>candidates[i]) {
    			isAscending = false;
    			break;
    		}    		
    	}
    	if (!isAscending) {
    		heapSort(candidates);
    	}
   	
    	LinkedList<Integer> path = new LinkedList<Integer>();	
  		goDFS(candidates, target, 0, path, ret);
    	return ret;
    }

    public List<List<Integer>> combinationSum2E(int[] candidates, int target) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	if (target == 0 || candidates.length == 0) {
    		return ret;
    	}
    	
    	boolean isAscending = true;    	
    	for (int i=1; i<candidates.length; i++) {
    		if (candidates[i-1]>candidates[i]) {
    			isAscending = false;
    			break;
    		}    		
    	}
    	if (!isAscending) {
    		heapSort(candidates);
    	}
   	
    	HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
    	
    	List<int[]> lcur = new ArrayList<int[]>();
    	List<Integer> icur = new ArrayList<Integer>();
    	List<Integer> scur = new ArrayList<Integer>();
    	
    	
    	for (int i=0; i<candidates.length; i++) {
    		if (candidates[i]>target) {
    			break;
    		}
    		
    		int j = i-1;    		
    		if (j>=0 && candidates[j] == candidates[i]) {
    			continue;
    		}
    		
    		if (candidates[i] == target) {
    			hs.add(Arrays.asList(candidates[i]));
    		} else {
    			lcur.add(new int[]{candidates[i]});
    			icur.add(i);
    			scur.add(candidates[i]);
    		}
    	}
    	
    	int[] tl = null;
    	int ti = 0, sum=0;
    	while (!lcur.isEmpty()) {
    		tl = lcur.remove(0);
    		ti = icur.remove(0);
   		
    		sum=0;
    		for (int c:tl) {
    			sum += c;
    		}
    		        		
    		for (int j=ti+1; j<candidates.length; j++) {
    			if (sum+candidates[j] > target) {
    				break;
        		}
    			
        		if (j>ti+1 && candidates[j] == candidates[j-1]) {
        			continue;
        		}  			
    			
    			int[] tj = Arrays.copyOf(tl, tl.length+1);
    			tj[tj.length-1] = candidates[j];
    			
    			if (sum + candidates[j] == target) {
    		    	List<Integer> t = new ArrayList<Integer>();
    		    	for(int c:tj) {
    		    		t.add(new Integer(c));
    		    	}    				
    				hs.add(t);
        		} else {
        			lcur.add(tj);
        			icur.add(j);
        		}
    		}
    	}
    	ret.addAll(hs);    	
    	return ret;
    }

    public List<List<Integer>> combinationSum2D(int[] candidates, int target) {
        
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	if (target == 0 || candidates.length == 0) {
    		return ret;
    	}
    	
    	boolean isAscending = true;    	
    	for (int i=1; i<candidates.length; i++) {
    		if (candidates[i-1]>candidates[i]) {
    			isAscending = false;
    			break;
    		}    		
    	}
    	
    	if (!isAscending) {
    		heapSort(candidates);
    	}
   	
    	//HashSet<int[]> hs = new HashSet<int[]>();
    	HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
    	
    	List<int[]> lcur = new ArrayList<int[]>();
    	List<Integer> icur = new ArrayList<Integer>();
    	
    	for (int i=0; i<candidates.length; i++) {
    		if (candidates[i]>target) {
    			break;
    		} else if (candidates[i] == target) {
    			//hs.add(new int[]{candidates[i]});
    			hs.add(Arrays.asList(candidates[i]));
    		} else {
    			lcur.add(new int[]{candidates[i]});
    			icur.add(i);
    		}
    	}
    	
    	int[] tl = null;
    	int ti = 0, sum=0;
    	while (!lcur.isEmpty()) {
    		tl = lcur.remove(0);
    		ti = icur.remove(0);
    		
    		sum=0;
    		for (int c:tl) {
    			sum += c;
    		}
        		
    		for (int j=ti+1; j<candidates.length; j++) {
    			if (sum+candidates[j] > target) {
    				break;
        		}
    			int[] tj = Arrays.copyOf(tl, tl.length+1);
    			tj[tj.length-1] = candidates[j];
    			
    			if (sum + candidates[j] == target) {
    		    	List<Integer> t = new ArrayList<Integer>();
    		    	for(int c:tj) {
    		    		t.add(new Integer(c));
    		    	}    				
    				hs.add(t);
        		} else {
        			lcur.add(tj);
        			icur.add(j);
        		}
    		}
    	}
    	ret.addAll(hs);
    	
    	return ret;
    }
    
	
    public List<List<Integer>> combinationSum2C(int[] candidates, int target) {
    
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	if (target == 0 || candidates.length == 0) {
    		return ret;
    	}
    	
    	boolean isAscending = true;    	
    	for (int i=1; i<candidates.length; i++) {
    		if (candidates[i-1]>candidates[i]) {
    			isAscending = false;
    			break;
    		}    		
    	}
    	
    	if (!isAscending) {
    		heapSort(candidates);
    	}
   	
    	HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
    	
    	List<List<Integer>> lcur = new ArrayList<List<Integer>>();
    	List<Integer> icur = new ArrayList<Integer>();
    	
    	for (int i=0; i<candidates.length; i++) {
    		if (candidates[i]>target) {
    			break;
    		} else if (candidates[i] == target) {
    			hs.add(Arrays.asList(candidates[i]));
    		} else {
    			lcur.add(Arrays.asList(candidates[i]));
    			icur.add(i);
    		}
    	}
    	
    	List<Integer> tl = null;
    	int ti = 0, sum=0;
    	while (!lcur.isEmpty()) {
    		tl = lcur.remove(0);
    		ti = icur.remove(0);
    		
    		sum=0;
    		for (int c:tl) {
    			sum += c;
    		}
        		
    		for (int j=ti+1; j<candidates.length; j++) {
    			if (sum+candidates[j] > target) {
    				break;
        		}
        			
    			List<Integer> tj = new ArrayList<>();
    			
    			/*
    			for (int c:tl) {
    				tj.add(c);
        		}
        		*/
    			for (int k=0; k<tl.size(); k++) {
    				tj.add(tl.get(k));
    			}
    			
    			tj.add(candidates[j]);
    			if (sum + candidates[j] == target) {
    				hs.add(tj);
        		} else {
        			lcur.add(tj);
        			icur.add(j);
        		}
    		}
    	}
    	    	
    	for (List<Integer> e:hs) {
    		ret.add(e);
    	}
    	
    	return ret;
    }
	
    public List<List<Integer>> combinationSum2B(int[] candidates, int target) {	
    	
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	// always check the boundary first
    	if (target == 0 || candidates.length == 0) {
    		return ret;
    	}
    	
    	boolean isAscending = true;    	
    	for (int i=1; i<candidates.length; i++) {
    		if (candidates[i-1]>candidates[i]) {
    			isAscending = false;
    			break;
    		}    		
    	}
    	
    	if (!isAscending) {
    		heapSort(candidates);
    	}
   	
    	HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
    	
    	List<List<Integer>> lcur = new ArrayList<List<Integer>>();
    	List<Integer> icur = new ArrayList<Integer>();

    	
    	for (int i=0; i<candidates.length; i++) {
    		lcur.add(Arrays.asList(candidates[i]));
    		icur.add(i);
    	}
    	
    	List<Integer> tl = null;
    	int ti = 0;
    	while (!lcur.isEmpty()) {
    		tl = lcur.remove(0);
    		ti = icur.remove(0);
        		
    		int sum = 0;
    		for (int c:tl) {
    			sum += c;
        	}
        		
    		for (int j=ti+1; j<candidates.length; j++) {
    			if (sum+candidates[j] > target) {
    				break;
        		}
        			
    			List<Integer> tj = new ArrayList<>();
        			
    			for (int c:tl) {
    				tj.add(c);
        		}
    			tj.add(candidates[j]);
        			
    			if (sum+candidates[j] == target) {
    				hs.add(tj);
        		} else {
        			lcur.add(tj);
        			icur.add(j);
        		}
    		}
    	}
    	    	
    	for (List<Integer> e:hs) {
    		ret.add(e);
    	}
    	
    	return ret;
    }
	
    public List<List<Integer>> combinationSum2A(int[] candidates, int target) {
    	
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	boolean isAscending = true;
    	for (int i = 1; i < candidates.length; i++) {
    		if (candidates[i-1]>candidates[i]) {
    			isAscending = false;
    			break;
    		}
    	}
    	
    	if (!isAscending) {
    		heapSort(candidates);
    	}    	
    	
    	List<List<Integer>> tmp = new ArrayList<List<Integer>>();
    	List<Integer> itmp = new ArrayList<Integer>();
    	
    	for (int i = 0; i< candidates.length; i++) {
    		tmp.add(Arrays.asList(candidates[i]));
    		itmp.add(i);
    	}
    	
    	do {
    		for (int i = 0; i < tmp.size(); i++) {    			
    			List<Integer> cur = tmp.remove(0);
    			int icur = itmp.remove(0);
    			
    			int sum = 0;
    			for (int ii =0; ii<cur.size();ii++) {
    				sum += cur.get(ii);
    			}
    			
    			for (int j = icur+1; j < candidates.length; j++) {
    				if (sum + candidates[j] > target) {
    					break;
    				}   					
   					List<Integer> ncur = new ArrayList<>();
   					for (int jj=0;jj<cur.size();jj++) {
   						ncur.add(cur.get(jj));
   					}
   					ncur.add(candidates[j]);
   					if (sum + candidates[j] == target) {
   						ret.add(ncur);
   					} else {
   						tmp.add(ncur);
   						itmp.add(j);
   					}
     			}
    		}
    		
    	} while (itmp.size()>0);
    	
    	return ret;        
    }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution su = new Solution();
		
		int[] testArray = new int[] {10,1,2,7,6,1,5};
		int[] testArray2 = new int[] {1};
		int[] testArray3 = new int[] {8,7,4,3};
		
		
		for (int i=0;i<testArray.length;i++) {
			System.out.format(" %d", testArray[i]);
		}
		System.out.println();
		
		
		su.heapSort(testArray);

		for (int i=0;i<testArray.length;i++) {
			System.out.format(" %d", testArray[i]);
		}
		System.out.println();
		
		
		List<List<Integer>> ret = su.combinationSum2(testArray, 8);
	
		for (int i =0 ; i<ret.size(); i++) {
			List<Integer> sub = ret.get(i);
			
			for (int c:sub) {
				System.out.format("%d ", c);
			}
			System.out.println();
		}
		
		System.out.println("=================================");

		ret = su.combinationSum2(testArray2, 1);
		
		for (int i=0 ; i<ret.size(); i++) {
			List<Integer> sub = ret.get(i);
			
			for (int c:sub) {
				System.out.format("%d ", c);
			}
			System.out.println();
		}		

		System.out.println("=================================");

		/*
		su.heapSort(testArray3);

		for (int i=0;i<testArray3.length;i++) {
			System.out.format(" %d", testArray3[i]);
		}
		System.out.println();
		*/
		
		ret = su.combinationSum2(testArray3, 11);
		
		for (int i=0 ; i<ret.size(); i++) {
			List<Integer> sub = ret.get(i);
			
			for (int c:sub) {
				System.out.format("%d ", c);
			}
			System.out.println();
		}				
		
	}

}
