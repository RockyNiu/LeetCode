package leetcode.java;

public class SortList {

	/**
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 * /** Definition for singly-linked list. 
	 * class ListNode {
	 *  int val; 
	 *  ListNode next; 
	 *  ListNode(int x) {
	 *   val = x; 
	 *   next = null; 
	 *  } 
	 * }
	 */
	public static void main(String[] args) {
		int[] list = {5, 2, 3, 7};

		ListNode head = ListNode.parse(list);
		if (head != null)
			head.print();

		Solution148 solution = new Solution148();
		ListNode result = solution.sortList(head);
		if (result != null)
			result.print();
	}

}

class Solution148 {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

//		ListNode half = splitList(head);
		ListNode half = partion(head);
		
		head = sortList(head);
		half = sortList(half);

		head = mergeSortedList(head, half);

		return head;
	}
	
	// Albert Chen's solution
	private ListNode partion(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		while(true){
			fast = fast.next;
			if (fast == null)
				break;
			fast = fast.next;
			if (fast == null)
				break;
			slow = slow.next;			
		}
		ListNode half = slow.next;
		slow.next = null;		
		return half;
		
	}

	private ListNode splitList(ListNode head) {

		ListNode half = head;
		int count = 0;
		while (half != null) {
			count++;
			half = half.next;
		}
		int index = count / 2;
		half = head;
		ListNode pre = half;
		while (index > 0) {
			pre = half;
			half = half.next;
			index--;
		}
		pre.next = null;
		return half;
	}

	private ListNode mergeSortedList(ListNode head, ListNode half) {
		ListNode header = new ListNode(0);
		ListNode pre = header;
		ListNode node1 = head;
		ListNode node2 = half;

		while ((node1 != null) && (node2 != null)) {
			if (node1.val < node2.val) {
				pre.next = node1;
				node1 = node1.next;
			} else {
				pre.next = node2;
				node2 = node2.next;
			}
			pre = pre.next;
		}

		if (node2 == null)
			pre.next = node1;
		else
			pre.next = node2;

		return header.next;
	}

}