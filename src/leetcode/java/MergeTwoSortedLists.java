package leetcode.java;

public class MergeTwoSortedLists {

	/**
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 * 
	 * /** Definition for singly-linked list. 
	 * public class ListNode { 
	 * 	int val;
	 * 	ListNode next; 
	 * 	ListNode(int x) { 
	 * 		val = x; 
	 * 		next = null; 
	 * 	} 
	 * }
	 */
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		int n1 = 100;
		
		ListNode pre1 = head1;
		for (int i = 2; i < n1; i=i+5) {
			ListNode node = new ListNode(i);
			pre1.next = node;
			pre1 = pre1.next;
			
		}
		
		ListNode head2 = new ListNode(3);
		int n2 = 100;
		
		ListNode pre2 = head2;
		for (int i = 5; i < n2; i=i+6) {
			ListNode node = new ListNode(i);
			pre2.next = node;
			pre2 = pre2.next;
			
		}
		
		Solution064 solution = new Solution064();
		ListNode newHead = solution.mergeTwoLists(head1,head2);
		newHead.print();
	}

}

class Solution064 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode header = new ListNode(0);
		ListNode pre1 = l1;
		ListNode pre2 = l2;
		ListNode pre = header;

		while (pre1 != null && pre2 != null) {
			if (pre1.val < pre2.val) {
				pre.next = pre1;
				pre1 = pre1.next;
				pre = pre.next;
			} else {
				pre.next = pre2;
				pre2 = pre2.next;
				pre = pre.next;
			}
		}

		if (pre1 == null){
			pre.next = pre2;
		}
		else{
			pre.next = pre1;
		}
		
		return header.next;
	}
}