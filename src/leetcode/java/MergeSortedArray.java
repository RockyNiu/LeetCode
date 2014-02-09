package leetcode.java;

/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note:
 You may assume that A has enough space to hold additional elements from B. The number of elements 
 initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 4, 5, 6, 0, 0, 0, 0 };
		int m = 6;
		int[] B = new int[] { 2, 4, 6 };
		int n = 3;
		Solution088 solution = new Solution088();
		solution.merge(A, m, B, n);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

}

class Solution088 {
	public void merge(int A[], int m, int B[], int n) {
		int a = n;
		int b = 0;
		int c = 0;

		for (int i = m; i > 0; i--) {
			A[i + n - 1] = A[i - 1];
		}

		while (a < m + n && b < n) {
			if (A[a] < B[b]) {
				A[c] = A[a];
				a++;
			} else {
				A[c] = B[b];
				b++;
			}
			c++;
		}

		while (c < m + n) {
			if (b < n) {
				A[c] = B[b];
				b++;
			} else {
				A[c] = A[a];
				a++;
			}
			c++;
		}

	}
}