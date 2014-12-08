package com.rockyniu.leetcode;

/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
	public static void main(String[] args) {
		int[] A = { 0,2, 3 };
		int elem = 2;
		Solution026_2 solution = new Solution026_2();
		System.out.println("length:" + solution.removeElement(A, elem));
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

}

// Albert Chen's solution
class Solution026_2 {
	public int removeElement(int[] A, int elem) {
		int end = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[end] = A[i];
				end++;
			}
		}
		return end;
	}
}

class Solution026 {
	public int removeElement(int[] A, int elem) {
		// if (A.length==0) return 0;
		int n = -1;
		for (int i = 0; i < A.length; i++) {
			while (i < A.length && A[i] == elem) {
				i++;
			}
			if (i < A.length && A[i] != elem) {
				n = n + 1;
				A[n] = A[i];
			}
		}
		return n + 1;
	}
}