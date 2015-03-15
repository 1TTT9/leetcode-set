package singlenumber;

public class Solution {
	
	
	public int singleNumber(int[] A) {
		
		return singleNumber2(A, 0, A.length-1);
	}
	
	public int singleNumber2(int[] A, int first, int last) {

		int i=first, j=last;
		for (;i<=j;i++) {
			if (A[i] == A[j]) {
				break;
			}
		}
		//found it
		if (i==j) {
			return A[i];
		}

		//otherwise, always replace i with first
		A[i] = A[first];
		
		return singleNumber2(A,first+1, last-1);
	}

	
	public int singleNumber3(int[] A) {
		
		int first = 0, last = A.length-1;
		while (true) {
	
			int i = first;
			for (;i<last;i++) {
				if (A[i] == A[last]) {
					break;
				}
			}
			
			if (i == last) {
				break;
			}
			A[i] = A[first];
			first++;
			last--;			
		}
		return A[last];
	}
	
	public int singleNumber4(int[] A) {
		
		int left,right;
		for (int i=A.length;i>1;i--) {
			
			for (int j=i/2;j>=1;j--) {
				
				left = j*2;
				right = j*2+1;
				
				if (A[j-1]<A[left-1] && left <= i) {
					swap(A, j-1, left-1);
				}
				if (A[j-1]<A[right-1] && right <= i) {
					swap(A, j-1, right-1);
				}
			}
			swap(A, 0, i-1);
			
			/*
			for (int x=0;x<A.length;x++) {
				System.out.print(A[x]);
			}
			System.out.println();
			*/
		}	
		
		int i = 1;
		while (true) {
			if (i>=A.length) {
				i = A.length;
				break;
			}
			if (A[i-1] != A[i]) {
				break;
			}
			i+=2;
		}
		return A[i-1];
	}	
	
	
	public int singleNumber5(int[] A) {
		
		int left,right, ret = A[0];
		for (int i=A.length;i>1;i--) {
			
			for (int j=i/2;j>=1;j--) {
				
				left = j*2;
				right = j*2+1;
				
				if (A[j-1]<A[left-1] && left <= i) {
					swap(A, j-1, left-1);
				}
				if (A[j-1]<A[right-1] && right <= i) {
					swap(A, j-1, right-1);
				}
			}
			swap(A, 0, i-1);
			
			if ( i%2==0 ) {
				if ( A[i-1] != A[i] ) {
					ret = A[i];
					break;
				}
			}
		}
		return ret;
	}	
		
	public int singleNumber6(int[] A) {
		
		int left, right, ret = A[0];
		for (int i=A.length;i>1;i--) {
			
			for (int j=i/2;j>=1;j--) {
				
				left = j*2;
				right = j*2+1;
				
				if (A[j-1]<A[left-1] && left <= i) {
					swap(A, j-1, left-1);
				}
				if (A[j-1]<A[right-1] && right <= i) {
					swap(A, j-1, right-1);
				}
			}
			swap(A, 0, i-1);
			
			if ( i%2==0 ) {
				if ( A[i-1] != A[i] ) {
					ret = A[i];
					break;
				}
			}
		}
		return ret;
	}	
	
	public int singleNumber7(int[] A) {
		
		for (int i=A.length/2; i>=1;i--) {
			heapify(A, i, A.length);
		}
		
		int ret = A[0];
		for (int i=A.length;i>=2;i--) {
			swap(A, 0, i-1);			
			heapify(A, 1, i-1);			
			ret = A[0];
			if (i%2==0) {
				if(A[i-1]!=A[i]) {
					ret = A[i];
					break;
				}	
			}
		}
		return ret;
	}	
	
	public void heapify(int[] A, int root, int size) {
		
		int left = root*2, right = left+1;
		
		int max = root;
		if (A[max-1] < A[left-1]  && left <= size){
			max = left;
		}
		if (A[max-1] < A[right-1] && right <= size){
			max = right;
		}
		
		if (max != root) {
			swap(A, root-1, max-1);
			if (max*2 <= size) {
				heapify(A, max, size);
			}
		}
	}
	
	
	public void swap(int[] A, int x, int y) {
		int t = A[x];
		A[x] = A[y];
		A[y] = t;
	}
}
