package com.rockyniu.leetcode;

public class LinkedListCycle {

	/**
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 */
	public static void main(String[] args) {
		int[] list = {5, 2, 3, 7};

		ListNode c = new ListNode(0);
		ListNode head = ListNode.parse(list);
		
		c.next = head.next;
		head.next.next.next= c;

		Solution141 solution = new Solution141();
		System.out.println(solution.hasCycle(head));
	}

}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution141 {
	public boolean hasCycle(ListNode head) {

		if (head == null || head.next == null)
			return false;

		ListNode slow = head;
		ListNode fast = head;

		while (true) {
			slow = slow.next;
			if (fast.next == null)
				return false;
			else
				fast = fast.next.next;

			if (slow.equals(fast))
				return true;

			if ((slow == null) || (fast == null))
				return false;
		}
	}
}