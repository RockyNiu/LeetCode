package leetcode.java;

/**
 * Given an array with 3n objects colored red, white or blue, sort them so that
 * objects in the order red, white, blue, red, white, blue, ...
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 */
public class SortColors_2 {
	/*
	 * Timeout happened when {switch case} was used.
	 */
	public static void main(String[] args) {
		int n = 10;
		int num = 3;
		int[] A = Utils.generateRandomMatrix(n,num);
		Utils.print(A);
		Solution075_2_1 solution = new Solution075_2_1();
		solution.reorder(A);
		Utils.print(A);
	}

}

// 弱猴风之子算法 
class Solution075_2_1 {
	
	public void reorder(int[] nums) {
		int i0 = 0, i1 = 1, i2 = 2;
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == 0) {
				swap(nums, i, i0);
				i0 += 3;
			} else if (nums[i] == 1) {
				swap(nums, i, i1);
				i1 += 3;
			} else {
				swap(nums, i, i2);
				i2 += 3;
			}
			i = Math.min(Math.min(i0, i1), i2);
		}
	}

	void swap(int[] A, int n1, int n2) {
		int temp = A[n1];
		A[n1] = A[n2];
		A[n2] = temp;
	}

}