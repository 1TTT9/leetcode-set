package swapNodesinPairs;

public class Solution {

	
	public ListNode swapPairs(ListNode head) {
        
		
		ListNode cur = head;
		ListNode temp = null, paren = null;
		int i = 1;
		while (true) {
			if (cur == null) {
				break;
			}
			if (i%2==1) {
				if (cur.next != null) {
					temp = cur.next;
					cur.next = temp.next;
					temp.next = cur;
					if (i>1) {
						paren.next = temp;
					} else {
						paren = temp;
					}
				} else {
					paren = cur;
				}
			} else {
				paren = cur;									
				cur = cur.next;
			}
			if (i==1) {				
				head = paren;
			}
			i++;
		}
		
		return head;
		
    }	
	
	public static void main(String[] args) {

		ListNode root = new ListNode(1);		
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		//ListNode n3 = new ListNode(4);
		//ListNode n4 = new ListNode(5);		
		
		root.next = n1;
		n1.next = n2;
		//n2.next = n3;
		//n3.next = n4;

		ListNode k = root;
		while (true) {
			if (k == null) {
				break;
			}
			System.out.println(k.val);
			k = k.next;
		}
		System.out.println("------------------");		
		
		
		Solution su = new Solution();
		k = su.swapPairs(root);
		
		while (true) {
			if (k == null) {
				break;
			}
			System.out.println(k.val);
			k = k.next;
		}		

	}

}
