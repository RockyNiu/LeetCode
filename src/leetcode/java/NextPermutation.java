package leetcode.java;

public class NextPermutation {

	/*
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
	 * 1,2,3 1,1,5 → 1,5,1
	 */
	public static void main(String[] args) {
		int[] num = new int[] { 1, 4, 3, 2 };
		Solution030 solution = new Solution030();
		solution.nextPermutation(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}

}

class Solution030 {
	public void nextPermutation(int[] num) {
		for (int i = num.length - 1; i > 0; i--) { // find the most big
													// descending subarray
			if (num[i - 1] < num[i]) {
				for (int j = num.length - 1; j >= i; j--) {
					if (num[i - 1] < num[j]) {
						swap(num, i - 1, j);
						reverse(num, i, num.length - 1);
						return;
					}
				}
			}
		}
		reverse(num, 0, num.length - 1);
	}

	void swap(int[] num, int n1, int n2) {
		int temp = num[n1];
		num[n1] = num[n2];
		num[n2] = temp;
	}

	void reverse(int[] num, int n1, int n2) {
		for (int i = n1; i <= n1 + (n2 - n1) / 2; i++) {
			swap(num, i, n2 + n1 - i);
		}

	}
}
