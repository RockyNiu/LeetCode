package com.rockyniu.leetcode;

import java.util.HashMap;
import java.util.Map;

/*Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, 
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 11, 7, 15}, target=9
 Output: index1=1, index2=3 
 */

public class TwoSum {

	public static void main(String[] args) {
		int[] numbers = { 2, 11, 7, 15 };
		int target = 9;
		Solution001 solution = new Solution001();
		int[] s = solution.twoSum(numbers, target);
		System.out.printf("index1=%d, index2=%d", s[0], s[1]);
	}
}

/**
 * O(n) runtime and O(n) space -- Hash
 */
class Solution001 {
	public int[] twoSum(int[] numbers, int target) {
		// init
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int j = numbers[i];
			if (map.containsKey(target - j)) {
				return new int[] { map.get(target - j) + 1, i + 1 };
			}
			map.put(j, i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}

/**
 * Old codes that is O(n2)
 */
class Solution001_1 {

	public int[] twoSum(int[] numbers, int target) {
		// init
		int[] solution = new int[2];

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if ((numbers[i] + numbers[j]) == target) {// find
					if (i > j) {// sort
						int temp = i;
						i = j;
						j = temp;
					}
					solution[0] = i + 1;
					solution[1] = j + 1;
				}
			}
		}
		return solution;
	}

}