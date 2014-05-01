package leetcode.java;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 */
public class SingleNumber {

	public static void main(String[] args) {
		int[] A = { 1, 2, 1, 3, -3, -3, 3 };
		Solution136 solution = new Solution136();
		System.out.println(solution.singleNumber(A));
	}

}

class Solution136 {
	public int singleNumber(int[] A) {
		int xor = 0;
		for (int i = 0; i < A.length; i++) {
			xor = xor ^ A[i];
		}
		return xor;
	}
}