package leetcode.java;

public class LinkedListCycleII {

	/**
	 * Given a linked list, return the node where the cycle begins. If there is
	 * no cycle, return null.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 */
	public static void main(String[] args) {
		int[] list = { 5, 2, 3, 7 };

		ListNode head = ListNode.parse(list);

		head.next.next.next.next = head.next;

		Solution142 solution = new Solution142();
		System.out.println(solution.detectCycle(head).val);
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
class Solution142 {
	public ListNode detectCycle(ListNode head) {
		
		if (head == null || head.next == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = head;
		
		while(true){
			slow = slow.next;
			if (fast.next == null)
				return null;
			else
				fast = fast.next.next;
			
			if ((slow == null) || (fast == null))
				return null;
			
			if (slow.equals(fast)){
				while (pre != slow) {
					slow = slow.next;
					while ((slow != pre) && (slow != fast)) {
						slow = slow.next;
					}
					if (slow == pre)
						break;
					else
						pre = pre.next;
				}
				return slow;
			}
		}
	}
}