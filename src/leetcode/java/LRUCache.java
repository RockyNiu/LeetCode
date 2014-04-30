package leetcode.java;

import java.util.ArrayList;
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
	HashMap<Integer, Integer> map;
	ArrayList<Integer> list;
	
	public Solution146(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, Integer>();
		this.list = new ArrayList<Integer>();
    }
    
	public int get(int key) {
		if (map.get(key) == null)
			return -1;
		else {
			int value = map.get(key);
			int first = list.get(0);
			list.set(0, value);
			list.set(key, first);
			return value;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			map.put(key, value);
		} else if (this.capacity > map.size()) {
			map.put(key, value);
			list.add(0, key);
		} else {
			map.put(key, value);
			list.remove(list.size()-1);
			list.add(0,key);
		}

	}
}