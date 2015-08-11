package isPalindrome;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode sn = head, fn = head;
        
        while (fn.next != null && fn.next.next != null) {
            sn = sn.next;
            fn = fn.next.next;
        }
        
        ListNode head2 = sn.next;
        sn.next = null;
        
        ListNode p1 = head2, p2 = p1.next;
        while (p1 != null && p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        
        head2.next = null;
        
        p2 = head;
        boolean isPA = true;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                isPA = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return isPA;
    }
	
}
