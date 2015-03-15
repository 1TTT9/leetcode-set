package sortColors;

public class Solution {
	
	
	public void sortColors(int[] A) {
     
		
		int i=0,j=0,k=A.length+1;		
		int x = 1;
		while (true) {
			
			if (A[x-1] == 2) {
				swap(A, x, k-1);				
				k--;
			} else {
				
				if (A[x-1] == 0) {
					
					if (i+1 < x) {
						swap(A, x, i+1);						
					}

					i++;
				} else if (A[x-1] == 1) {
					if (i>j) {
						j=i;
					} 
					if (j+1 < x) {
						swap(A, x, j+1);						
					}					
					j++;
				} 
				x++;
			}
			if (x==k) {
				break;
			}
		}
    }
	
	public void swap(int[] A, int m, int n) {
		int temp = A[m-1];
		A[m-1] = A[n-1];
		A[n-1] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution su = new Solution();
		
		//int[] A = {1,1,2,2,3};
		//int[] A = {3,3,2,2,1};		
		//int[] A = {2,2,3,3,1};				
		//int[] A = {2,2,1,1,3};
		int[] A = {1,1,2,2};
		
		for (int a:A) {
			System.out.print(a+",");
		}
		System.out.println();		
		
		su.sortColors(A);
		
		for (int a:A) {
			System.out.print(a+",");
		}
		System.out.println();
	}

}
