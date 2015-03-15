package containerWithMostWater;

public class Solution {

	public int maxArea0(int[] height) {
        		
		if (height.length<=1) {
			return 0;
		}
		
		int max = 0;
		int h = 0;
		for (int i=1;i<=height.length-1;i++) {
			for (int j=i+1;j<=height.length;j++) {
				h = height[i-1];
				if(h>height[j-1]){
					h = height[j-1];
				}
				if (max<h*(j-i)){
					max = h*(j-i);
				}
			}
		}
		return max;
    }	
	
	public int maxArea(int[] height) {
		int n = height.length;
		if (n<=1) {
			return 0;
		}
		int max = 0;
		int h = 0;
		int j = 0, pj = 0;
		for (int i=1;i<=n-1;i++) {
			
			if (height[i-1]<1) {
				continue;
			}
			
			j=i+1;
			while (true) {
				pj = max/height[i-1]+i;
				if (pj>j) {
					j=pj;
				}
				if (j>n) {
					break;
				}				
				h = height[i-1];
				if(h>height[j-1]) {
					h = height[j-1];
				}
				if (max<h*(j-i)){
					max = h*(j-i);
				}				
				j++;
			}
		}
		return max;
    }	
	
	
	public static void main(String[] args) {
	
		int ret[] = {0,6};
		
		Solution su = new Solution();
		
		System.out.println(su.maxArea(ret));

	}

}
