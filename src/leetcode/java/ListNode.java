package leetcode.java;

//Definition for singly-linked list.
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
	
	public static ListNode parse(int[] A){
		if (A.length == 0) return null;
		
		ListNode head = new ListNode(A[0]);
		if (A.length == 1) return head;
		
		ListNode pre = head;
		for (int i = 1; i < A.length; i++) {
			ListNode node = new ListNode(A[i]);
			pre.next = node;
			pre = pre.next;
		}
		return head;
	}
	
	void print(){
		ListNode head = this;
		System.out.println();
		while(head!=null){
			System.out.print(head.val);
			if (head.next!=null)
				System.out.print("->");
			head = head.next;
		}
		System.out.println();
	}
}
