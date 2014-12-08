package com.rockyniu.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add(input) Add the number input to an internal data structure.
 * find(value) Find if there exists any pair of numbers which sum is equal to the value.
 * For example,
 *	add(1); add(3); add(3); add(5); find(4)-> true; find(6)->true; find(7) -> false
 */

public class TwoSumIII {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 3, 5};
		Solution001_III solution = new Solution001_III();
		for (int i = 0; i < numbers.length; i++) {
			solution.add(numbers[i]);
		}
		System.out.println(solution.find(4));
		System.out.println(solution.find(6));
		System.out.println(solution.find(7));
	}
}

/**
 * O(1)add, O(n)find, and space O(n)
 */
class Solution001_III {
	private Map<Integer, Integer> table = new HashMap<Integer, Integer>();

	public void add(int input) {
		Integer count = table.get(input);
		if (count == null){
			count = 0;
		}
		table.put(input, count + 1);
	}

	public boolean find(int value) {
		for (int key : table.keySet()) {
			int sub = value - key;
			if (sub == key) {
				// duplicated?
				if (table.get(key) >= 2) {
					return true;
				}
			} else if (table.containsKey(sub)) {
				return true;
			}
		}
		return false;
	}
}