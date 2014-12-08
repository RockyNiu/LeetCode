package com.rockyniu.leetcode;


/*Given an sorted array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, 
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2 
 */

public class TwoSumII {

	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;
		Solution001_II solution = new Solution001_II();
		int[] s = solution.twoSum(numbers, target);
		System.out.printf("index1=%d, index2=%d", s[0], s[1]);
	}
}

/**
 * O(n) runtime and O(1) space
 */
class Solution001_II {
	public int[] twoSum(int[] numbers, int target) {
		// init
		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {

			if (numbers[i] + numbers[j] < target) {
				i++;
			} else if (numbers[i] + numbers[j] > target) {
				j--;
			} else {
				return new int[] { i+1, j+1 };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}