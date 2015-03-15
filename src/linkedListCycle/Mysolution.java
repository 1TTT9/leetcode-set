package linkedListCycle;

public class Mysolution {
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mysolution.ListNode head = new Mysolution.ListNode(1);

		Mysolution.ListNode cur = head;
		for (int i=1;i<=5;i++) {	
			cur.next = new Mysolution.ListNode(i);
			cur = cur.next;
		}
		
		cur.next = head.next;
		System.out.println("result - " + hasCycle(head));
	}
	
	public static void traverse(ListNode node) {
		
		if (node == null) {
			return;
		}		
		System.out.println("val - " + node.val +  node);
		traverse(node.next);		
	}

	public static void traverse2(ListNode pnode, ListNode node, int maxrun) {
		
		if (node == null) {
			return;
		}		
		
		if (maxrun==12) {
			return;
		}
		
		System.out.println("val - " + node.val + " pos - " + node.toString());
		
		ListNode temp = node.next;
		
		if (pnode != null) {
			pnode.next = null;
		}

		System.gc();
		traverse2(node, temp, maxrun+1);		
	}
	

	public static boolean hasCycle0(ListNode head, ListNode node) {
				
		if (node == null) {
			return false;
		} 
			
		if (node.next == null ) {
			return false;
		}
		
		ListNode next = node.next;
		
		//head
		if ( head == null ) {
			head = node;
			node.next = head;
		} else {
			if ( node == head ) {
				return true;
			}		
			node.next = head;
		}		
		return hasCycle0(head, next);
	}
	

	public static boolean hasCycle(ListNode head) {

		boolean ret = false;
		
		ListNode ref = null, node = head;
		ListNode next = node;
		while (true) {
			node = next;
			if (node == null) {
				break;
			} else if (node.next == null ) {
				break;
			}			
			//record next 
			next = node.next;			
			//head
			if ( ref == null ) {
				ref = node;
			} else if ( node == ref ) {
				ret = true;
				break;
			}		
			//erase node's next
			node.next = ref;
		}
		return ret;
	}
	
}
