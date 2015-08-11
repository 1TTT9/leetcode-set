package validPalindrome;

public class Solution {

	
    public boolean isPalindrome(String s) {
        
        if (s == null) {
            return true;
        }
        
        boolean isPA = true;
        //A-Z 65-90   a-z 97-122  0-9 48-57
        int p = 0, q = s.length()-1;
        int left = 0, right = 0;
        while (p<q) {
        	left = (int)s.charAt(p);
        	
        	if ((left<=90 && left>=65) || (left<=122 && left>=97) || (left<=57 && left>=48)) {
        	} else {
        		p++;
       			continue;
        	}
        	right = (int)s.charAt(q);
        	if ((right<=90 && right>=65) || (right<=122 && right>=97) || (right<=57 && right>=48)) {
        	} else {
        		q--;
       			continue;
        	}        	

        	if (right<=57 && right>=48) { //digit
        		if (left == right) {
        			q-=1;
        			p+=1;
        		} else {
        			isPA =false;
        			break;
        		}
        	}    
        	else if (left == right || left+32 == right || left == right+32) { //alphabet
        		q-=1;
        		p+=1;
        	} else {
        		isPA = false;
        		break;
        	}
        }        
        return isPA;
    }
}
