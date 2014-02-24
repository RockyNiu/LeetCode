package leetcode.java;

import java.util.ArrayList;
import java.util.Random;

public class CopyListwithRandomPointer {

	/**
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 */
	public static void main(String[] args) {
		int[] A = {5, 6, 8, 10, 12, 15, 16, 9}; // must be not empty 
		Random random = new Random();
		
		ArrayList<RandomListNode> list = new ArrayList<RandomListNode>();
		list.add(null);
		for (int i = 0; i < A.length; i++) {
			RandomListNode r = new RandomListNode(A[i]);
			list.add(r);
			list.get(i+1).next = list.get(i);
			list.get(i+1).random = null;
		}
				
		for (int i = 0; i < list.size(); i++) {
			RandomListNode pre = list.get(i);
			if (pre!=null){
				int k = random.nextInt(list.size()-1);
				RandomListNode rnd = list.get(k);
				
				findRandom: while (rnd != null){
					if (rnd.random == null){
						break findRandom;
					}
					else {
						RandomListNode temp = rnd;
						while ((temp != null) && (!temp.equals(pre)) && (!temp.equals(rnd))){
							temp = temp.random;
						}
						if (temp == null){
							break findRandom;
						}
						else{
							k = random.nextInt(list.size()-1);
							rnd = list.get(k);
						}
					}
				}
				pre.random = rnd;
			}
		}
		
		for (int i = 1; i < list.size(); i++) {
			System.out.print(list.get(i).label + "'s next: " + list.get(i).labelOfNext());
			System.out.println();
		}
		
		for (int i = 1; i < list.size(); i++) {
			System.out.print(list.get(i).label + "'s random: "+ list.get(i).labelOfRandom());
			System.out.println();
		}
		
		Solution138 solution = new Solution138();
		RandomListNode result = solution.copyRandomList(list.get(list.size()-1));
		
		System.out.println("*******result**********\nhead:"+result.label);
		RandomListNode node = result;
		while (node != null){
			System.out.println("label:"+node.label
					+" next:"+node.labelOfNext()+" random:"+node.labelOfRandom());
			node = node.next;
		}
	}

}
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
class Solution138{
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
        	return null;
    	
    	RandomListNode header = new RandomListNode(0);
        header.next = head;
    	
        RandomListNode index = head;
        
		while (index != null) {
    		RandomListNode node = new RandomListNode(index.label);
    		node.next = index.next;
    		node.random = index.random;
    		index.next = node;
    		index = node.next;
    	}

		index = head;
		while (index!=null){
			index = index.next;
			if( index.random != null){
				index.random = index.random.next;
			}
			index = index.next;
		}
		
        RandomListNode pre = header;
		index = head;
		while (index != null){
			pre.next = index.next;
			index.next = index.next.next;
			pre = pre.next;
			index = index.next;
		}
		
    	return header.next;
    }
}

class RandomListNode {
	public int label;
	public RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
	
	String labelOfNext(){
		if (this.next == null){
			return "null";
		}
		else{
			return Integer.toString(this.next.label);
		}
	}
	
	String labelOfRandom(){
		if (this.random == null){
			return "null";
		}
		else{ 
			return Integer.toString(this.random.label);
		}
	}
}