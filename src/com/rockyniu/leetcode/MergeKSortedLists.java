package com.rockyniu.leetcode;

import java.util.ArrayList;

/*
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
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
public class MergeKSortedLists {
	public static void main(String[] args) {
		
	}

}

class Solution022{
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.isEmpty())
        	return null;
        
        if (lists.size()==1)
        	return lists.get(0);
        
        ListNode header = new ListNode(0);
        ListNode p = header;
        
        while(true){
        	int min = Integer.MAX_VALUE;
            int minList = 0;
            int count = 0;
            
        	for (int i = 0; i < lists.size(); i++) { // move one step for all lists
        		ListNode index = lists.get(i);
        		if (index!=null){
        			if (index.val < min){
            			min = index.val;
            			minList = i;
            		}
        		}
        		else{
        			count++;
        		}
        	}
        	if (count==lists.size())
        		break;
        	
        	ListNode add = lists.get(minList); // add one new node
        	p.next = add;
        	p = p.next;
        	lists.set(minList, add.next);
        }
        
        return header.next;
    }
	
}
