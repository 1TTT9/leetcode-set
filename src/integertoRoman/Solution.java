package integertoRoman;

public class Solution {

    public String intToRoman(int num) {
        
    	String ret = "";
    	
    	String five="", one="", ten="";
    	
    	int d = num, r = 0, delim = 1000;
    	for (int i=1;i<=4;i++) {
    		r = d%delim;
    		d = d/delim;
    		delim/=10;
    		
    		switch(i) {
    		case 4:
    			five = "V";
    			one = "I";
    			ten = "X";
    			break;
    		case 3:
    			five = "L";
    			one = "X";
    			ten = "C";
    			break;
    		case 2:
    			five = "D";
    			one = "C";
    			ten = "M";
    			break;
    		case 1:
    			one = "M";
    		}
    		
    		if (d == 0) {
    			//oass
    		} else if (d == 4) {    		
    			ret =  ret + one + five;
    			//ret = five + one + ret;
    	    } else if (d == 9) {
    	    	ret = ret + one + ten;
    	    	//ret = ten + one + ret;
    	    } else if (d<5) {  	    		
    	    	for (int j=1;j<=d;j++) {
    	    		ret = ret + one;
    	    	}
    	    } else{
    	    	ret = ret + five;
    	    	for (int j=6;j<=d;j++) {
    	    		ret += one;
    	    		//ret = one + ret;
    	    	}
    	    }      			
    		
    		d = r;
    	}    	
    	
    	return ret;
    	/*
    	d = num /1000;
    	r = num%1000;
    	
    	for (int i=1;i<=d;i++){
    		ret += "M";
    	}    	
    	
    	d = r /100;
    	r = r % 100;
    	
    	if (d == 4) {    		
    		ret += "CD";
    	} else if (d == 9) {
    		ret += "CM";
    	} else {
    		
    		if (d<5) {
    			for (int i=1;i<=d;i++) {
    				ret += "C";
    			}
    			ret += "D";
    		} else {
    			ret += "D";
    			for (int i=6;i<=d;i++) {
    				ret += "C";
    			}
    		}
    	}
    	
    	d = r /10;
    	r = r % 10;
    	
    	if (d == 4) {    		
    		ret += "XL";
    	} else if (d == 9) {
    		ret += "XC";
    	} else {
    		
    		if (d<5) {
    			for (int i=1;i<=d;i++) {
    				ret += "X";
    			}
    			ret += "L";
    		} else {
    			ret += "L";
    			for (int i=6;i<=d;i++) {
    				ret += "X";
    			}
    		}
    	}    	
    	

    	d = r;
    	
    	if (d == 4) {    		
    		ret += "IV";
    	} else if (d == 9) {
    		ret += "IX";
    	} else {
    		
    		if (d<5) {
    			for (int i=1;i<=d;i++) {
    				ret += "I";
    			}
    			ret += "V";
    		} else {
    			ret += "V";
    			for (int i=6;i<=d;i++) {
    				ret += "I";
    			}
    		}
    	}  
    	
    	return ret;
    	*/
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution su = new Solution();
		
		int[] arr = {1904, 1990, 2014,1,2,3,4,5,6,7,8,9,10,11,12,14,19,20,3999};
		
		for (int i:arr) {
			System.out.println( su.intToRoman(i)  );
		}

	}

}
