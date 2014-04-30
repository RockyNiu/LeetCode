package leetcode.java;

import java.util.HashMap;

public class LRUCache {

	/**
	 * Design and implement a data structure for Least Recently Used (LRU)
	 * cache. It should support the following operations: get and set.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key
	 * exists in the cache, otherwise return -1. 
	 * 
	 * set(key, value) - Set or insert
	 * the value if the key is not already present. When the cache reached its
	 * capacity, it should invalidate the least recently used item before
	 * inserting a new item.
	 */
	public static void main(String[] args) {

	}

}

class Solution146 {
	int capacity;
	int len;
	HashMap<Integer, DoubleLinkedNode> map;
	DoubleLinkedNode head;
	DoubleLinkedNode end;
	
	public Solution146(int capacity) {
		this.capacity = capacity;
		this.len = 0;
		this.map = new HashMap<Integer, DoubleLinkedNode>();
    }
    
	public int get(int key) {
		if (map.get(key) == null)
			return -1;
		else {
			DoubleLinkedNode visit = map.get(key);
			removeNode(visit);
			setHead(visit);
			return visit.value;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			DoubleLinkedNode oldNode = map.get(key);
			oldNode.value = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else if (this.len < this.capacity) {
			DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
			setHead(newNode);
			map.put(key, newNode);
			this.len++;
		} else {
			DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
			map.remove(this.end.key);
			removeEnd();
			setHead(newNode);
			map.put(key, newNode);
		}

	}
	
	void setHead(DoubleLinkedNode node){
		node.next = this.head;
		node.pre = null;
		
		if (this.head!=null){
			this.head.pre = node;
		}
		this.head = node;
		
		if (this.end == null){
			this.end = node;
		}
	}
	
	void removeNode(DoubleLinkedNode node){
		DoubleLinkedNode pre = node.pre;
		DoubleLinkedNode post = node.next;
		
		// set pre.next = post
		if (pre == null){
			this.head = post;
		} else {
			pre.next = post;
		}
		
		// set post.pre = pre
		if (post == null){
			this.end = pre;
		} else {
			post.pre = pre;
		}
	}
	
	void removeEnd(){
		this.end = this.end.pre;
		if (this.end != null){
			this.end.next = null;
		}
	}
	
	class DoubleLinkedNode{
		int key;
		int value;
		DoubleLinkedNode pre;
		DoubleLinkedNode next;
		DoubleLinkedNode(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
}