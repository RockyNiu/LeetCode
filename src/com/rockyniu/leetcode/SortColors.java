package com.rockyniu.leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 */
public class SortColors {
	/*
	 * Timeout happened when {switch case} was used.
	 */
	public static void main(String[] args) {
		int[] A = new int[] { 1, 0, 2, 1, 0, 2, 2, 0, 1, 1 };
		Solution075_2 solution = new Solution075_2();
		solution.sortColors(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}

// Albert Chen's solution
class Solution075_2 {
	public void sortColors(int[] A) {
		int zeros = 0; // the end of zeros
		int twos = A.length; // the start of twos;
		int index = 0; // iterator

		while (index < twos) {
			if (A[index] == 0) {
				swap(A, index, zeros);
				index++;
				zeros++;
			} else if (A[index] == 1) {
				index++;
			} else {
				twos--;
				swap(A, index, twos);
			}
		}
	}

	void swap(int[] A, int n1, int n2) {
		int temp = A[n1];
		A[n1] = A[n2];
		A[n2] = temp;
	}

}

class Solution075 {
	public void sortColors(int[] A) {
		int zeros = 0;
		int ones = 0;
		int[] B = new int[A.length];
		// B = A.clone();
		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
			if (A[i] == 0) {
				zeros++;
			} else if (A[i] == 1) {
				ones++;
			}
		}

		int red = 0;
		int white = zeros;
		int blue = zeros + ones;
		for (int i = 0; i < B.length; i++) {
			if (B[i] == 0) {
				A[red] = 0;
				red++;
			} else if (B[i] == 1) {
				A[white] = 1;
				white++;
			} else {
				A[blue] = 2;
				blue++;
			}
		}
	}
}