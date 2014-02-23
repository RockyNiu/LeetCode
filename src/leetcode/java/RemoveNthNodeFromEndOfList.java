package leetcode.java;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		int first = 1;
		int last = 5;
		ListNode head = new ListNode(first); 
		ListNode pre = head;
		for (int i = first+1; i <= last; i++) {
			ListNode node = new ListNode(i);
			pre.next = node;
			pre = node;
		}
		head.print();
		
		Solution019 solution = new Solution019();
		ListNode newHead = solution.removeNthFromEnd(head,2);
		newHead.print();
	}
		
}

class Solution019{
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode header = new ListNode(0);
    	header.next = head;
    	
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
			p2 = p2.next;
		}
    	
        ListNode pre = header;
        while (p2!=null){
        	p2 = p2.next;
        	pre = p1;
        	p1 = p1.next;
        }
        
        pre.next = p1.next;
    	return header.next;
    }	
}