package leetcode.java;
/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, 
only nodes itself can be changed.

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
public class SwapNodesInPairs {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		int n = 2;
		
		ListNode pre = head;
		for (int i = 2; i < n+1; i++) {
			ListNode node = new ListNode(i);
			pre.next = node;
			pre = pre.next;
		}
		
		Solution023 solution = new Solution023();
		ListNode newHead = solution.swapPairs(head);
		newHead.present();
	}

}

class Solution023{
	public ListNode swapPairs(ListNode head) {
        ListNode header = new ListNode(0);
        header.next = head;
        
//        assert (head!=null && head.next!=null):"the number of nodes in list < 2";

        if (head==null || head.next==null)
        	return head;
        
        ListNode pre = header;
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        while (p1!=null && p2!=null){
        	ListNode temp = p2.next;
        	pre.next = p2;
        	p2.next = p1;
        	p1.next = temp;
        	pre = p1;      
        	p1 = pre.next;
        	if (p1==null)
        		break;
        	else
        		p2=p1.next;
        }
        
        if(p2==null){
        	pre.next = p1;
        }
        
        return header.next;
    }
}