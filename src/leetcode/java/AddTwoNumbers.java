package leetcode.java;

import java.util.LinkedList;

/* You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
342 + 465 = 807;
*/
public class AddTwoNumbers {

	public static void main(String[] args) {
		int[] x1 = {2,4,5};
		int[] x2 = {5,6,4};
		LinkedList<ListNode> lists1 = newList(x1);
		LinkedList<ListNode> lists2 = newList(x2);
		ListNode l1 = lists1.element();
		ListNode l2 = lists2.element();
		Solution004 solution = new Solution004();
		ListNode l3 = solution.addTwoNumbers(l1, l2);
		while (l3 != null){
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}
	
	static LinkedList<ListNode> newList(int[] x){
		LinkedList<ListNode> nodes = new LinkedList<ListNode>();
		ListNode pre = new ListNode(x[0]);
		nodes.add(pre);
		for (int i = 1; i < x.length; i++) {
			ListNode post = new ListNode(x[i]);
			pre.next = post;
			nodes.add(post);
			pre = post;
		}
		return nodes;
	}
	
}

class Solution004 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	LinkedList<ListNode> lists3 = new LinkedList<ListNode>();
    	int flag = 0;
    	int sum = 0;
    	ListNode pre = new ListNode(0);
    	
    	// first step
    	sum = l1.val + l2.val;
    	if (sum > 9) {
    		flag = 1;
    	}
    	else{
    		flag = 0;
    	}
    	pre.val = sum - flag*10;
    	lists3.add(pre);
    	
    	// main loop
    	while ((l1.next != null)&&(l2.next != null)){
    		l1 = l1.next;
    		l2 = l2.next;
    		sum = l1.val + l2.val + flag;
    		if (sum > 9) {
        		flag = 1;
        	}
        	else{
        		flag = 0;
        	}
    		ListNode post = new ListNode(sum - flag*10);
			pre.next = post;
			lists3.add(post);
			pre = post;
    	}
    	
    	// last step
 		if (l2.next == null) l2 = l1;
		while (l2.next != null){
			l2 = l2.next;
			sum = l2.val + flag;
			if (sum > 9) {
        		flag = 1;
        	}
        	else{
        		flag = 0;
        	}
			ListNode post = new ListNode(sum - flag*10);
			pre.next = post;
			lists3.add(post);
			pre = post;
		}
		if (flag == 1){
			ListNode post = new ListNode(1);
			pre.next = post;
			lists3.add(post);
		}
    	return lists3.element();
    }
    
}

