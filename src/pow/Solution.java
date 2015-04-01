package pow;

public class Solution {

	
	public double pow2(double x, int n) {
		
		if (n==0) {
			return 1;
		} else if (n==1) {
			return x;
		}
		
		double res = pow2(x, n/2);		
		res *=res;
		if (n%2!=0)		
			res *= x;

		return res;
	}
	
	public double pow(double x, int n) {
		
		if(n<0) 
			return 1/pow2(x, -n);
		else 
			return pow2(x,n);
	}
	
	public static void main(String[] args) {
		Solution su = new Solution();
		
		System.out.println( su.pow(2,3));
		System.out.println( su.pow(2,-3));		
		
		System.out.println( su.pow(2,10));
		System.out.println( su.pow(2,-10));				

	}

}
