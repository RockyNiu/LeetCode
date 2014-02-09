package leetcode.java;

//Definition for singly-linked list.
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
	
	void present(){
		ListNode head = this;
		System.out.println();
		while(head!=null){
			System.out.print(head.val);
			if (head.next!=null)
				System.out.print("->");
			head = head.next;
		}
	}
}
