package rotateImage;

public class Solution {

	public void rotate(int[][] matrix) {
		int i = 1;
		int n = matrix.length;
		int j = i, m = n;
		while (true) {
						
			if (j>=m) {
				i++;
				m--;
				j = i;				
			}
			
			if (i>m) {
				break;
			}			
			
			int temp = matrix[i-1][j-1]; 				//p1
			matrix[i-1][j-1] = matrix[n-j+1-1][i-1];  		 //p4->p1
			matrix[n-j+1-1][i-1] = matrix[n-i+1-1][n-j+1-1]; //p3->p4
			matrix[n-i+1-1][n-j+1-1] = matrix[j-1][n-i+1-1]; //p2->p3
			matrix[j-1][n-i+1-1] = temp; 				 //p1->p2												
			j++;
		}
    }	
	
	public static void main(String[] args) {

		int n = 5;
		int[][] arr = new int[n][n];
		
		int c = 1;
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=n;j++) {
				arr[i-1][j-1] = c;
				c++;
			}
		}
		
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=n;j++) {
				System.out.print(arr[i-1][j-1]+",");
			}
			System.out.println();
		}
		
		Solution su = new Solution();

		su.rotate(arr);
		
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=n;j++) {
				System.out.print(arr[i-1][j-1]+",");
			}
			System.out.println();
		}		
		
		n=2;
		arr = new int[n][n];
		c = 1;
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=n;j++) {
				arr[i-1][j-1] = c;
				c++;
			}
		}
		
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=n;j++) {
				System.out.print(arr[i-1][j-1]+",");
			}
			System.out.println();
		}
		
		su.rotate(arr);
		
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=n;j++) {
				System.out.print(arr[i-1][j-1]+",");
			}
			System.out.println();
		}				
		
	}

}
