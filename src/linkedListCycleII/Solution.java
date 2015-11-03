package linkedListCycleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	}	
	
	public ListNode detectCycle(ListNode head) {
		ListNode sn = head, fn = head;
		
		boolean hascycle = false;
		while (true){
			if (fn == null) {
				break;
			} else if (fn.next == null) {
				break;
			}
			
			sn = sn.next;
			fn = fn.next.next;
			
			if (sn == fn) {
				hascycle = true;
				break;
			}
		}
		
		if (!hascycle) {
			return null;
		}
		
		sn = head;
		while (true) {
			
			if (sn == fn) {
				break;
			}
			sn = sn.next;
			fn = fn.next;
		}
		
		return fn;
	}
	
	public ListNode detectCycle1(ListNode head) {
		
		ListNode curNode = head, jumpNode = head;
		
		while (true) {
			
			if (jumpNode == null)
				break;
			else if (jumpNode.next == null) {
				jumpNode = null;
				break;
			}
			
			curNode = curNode.next;
			jumpNode = jumpNode.next.next;
			
			if (curNode == jumpNode) {
				
				if (jumpNode != head) {
					jumpNode = jumpNode.next;
				}
				
				break;
			}
		}
		return jumpNode;
	}
	
	public ListNode detectCycle0(ListNode head) {
		
		ListNode ret = null, tmp = null;
		
		if (head == null || head.next == null) 
			return head;

		if (head.next == head) {
			return head;
		}
		ret = head.next;
		while (true) {
			if (ret == null || ret.next == null) {
				ret = null;
				break;
			}else if (ret.next == head) break;
			tmp = ret.next;
			ret.next = head;
			ret = tmp;
		}
		return ret;
    }	
	

	public static void main(String[] args) {

		Solution su = new Solution();
		
		//[-1,-7,7,-4,19,6,-9,-5,-2,-5], tail connects to node index 6
		
		Solution.ListNode root = new Solution.ListNode(-1);
		
		Solution.ListNode b = new Solution.ListNode(-7);
		Solution.ListNode c = new Solution.ListNode(7);
		Solution.ListNode d = new Solution.ListNode(-4);
		Solution.ListNode e = new Solution.ListNode(19);
		Solution.ListNode f = new Solution.ListNode(6);		
		Solution.ListNode g = new Solution.ListNode(-9);		
		Solution.ListNode h = new Solution.ListNode(-5);		
		Solution.ListNode i = new Solution.ListNode(-2);		
		Solution.ListNode j = new Solution.ListNode(-5);				
		
		root.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = b;
		f.next = g;
		g.next = h;
		h.next = i;
		i.next = j;
		j.next = h;
		
		
		Solution.ListNode ret = su.detectCycle(root);
		
		if (ret == null) {
			System.out.println("null");
		} else {
			System.out.println(ret.val);
		}
	}

}
