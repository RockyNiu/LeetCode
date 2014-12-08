package com.rockyniu.leetcode;


/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

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
public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		int n = 5;
		int k = 3;
		
		ListNode pre = head;
		for (int i = 2; i < n+1; i++) {
			ListNode node = new ListNode(i);
			pre.next = node;
			pre = pre.next;
		}
		
		Solution024_2 solution = new Solution024_2();
		ListNode newHead = solution.reverseKGroup(head,k);
		newHead.print();
	}

}

class Solution024_2{
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode header = new ListNode(0);
        header.next = head;
        
        int count = 0;
        ListNode pre = header;
        ListNode p = head;
        
        while (p!=null){
	        while(p!=null && count<k){
	        	p = p.next;    
	        	count++;
	        }
	        
	        if (p!=null || count==k){
	        	ListNode p2pre = pre;
	        	for (int i = 1; i < k; i++) {
	        		// initialize p1, p2, p2pre, p2post
	        		p2pre = pre;
	        		ListNode p1 = pre.next;
	        		for (int j = 0; j < i; j++) {
						p2pre = p2pre.next;
					}
	        		ListNode p2 = p2pre.next;		            
	            	ListNode p2post = p2.next;
	        		
	        		// swap move p2 to pre.next each step
	            	pre.next = p2;
	            	p2.next = p1;
	            	p2pre.next = p2post;
				}
	        	pre = p2pre;
	        }
	        count = 0;
        }
        
        return header.next;
    }
}


class Solution024{
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode header = new ListNode(0);
        header.next = head;
        
        ListNode[] nodes = new ListNode[k];
        
        int count = 0;
        ListNode pre = header;
        ListNode p = head;
        
        while (p!=null){
	        while(p!=null && count<k){
	        	nodes[count] = p;
	        	p = p.next;    
	        	count++;
	        }
	        
	        if (p!=null || count==k){
	        	ListNode temp = nodes[k-1].next;
	        	for (int i = k-1; i >= 0; i--) {
					pre.next = nodes[i];
					pre = pre.next;
				}
	        	pre.next = temp;
	        }
	        else{
	        	pre.next = nodes[0];
	        }
	        count = 0;
        }
        
        return header.next;
    }
}