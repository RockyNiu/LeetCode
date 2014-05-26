package leetcode.java;

import java.util.Arrays;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 */
public class FindMedianSortedArrays {

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, B = { 3, 5, 6 };
		Solution002_3 solution = new Solution002_3();
		double s = solution.findMedianSortedArrays(A, B);
		System.out.println(s);
	}

}

// add first index of a and b
class Solution002_3 {
	public double findMedianSortedArrays(int[] A, int[] B) {
		int sizeA = A.length;
		int sizeB = B.length;
		if ((sizeA + sizeB) % 2 == 1) {
			return getKth(A, 0, B, 0, (sizeA + sizeB + 1) / 2);
		} else {
			return (getKth(A, 0, B, 0, (sizeA + sizeB) / 2) + getKth(A, 0, B,
					0, (sizeA + sizeB) / 2 + 1)) / 2.0;
		}
	}

	// a, first index of int[] a
	// b, first index of int[] b
	double getKth(int[] A, int a, int[] B, int b, int k) {
		// let A.length < B.length
		int m = A.length;
		int n = B.length;
		if (m > n) {
			return getKth(B, b, A, a, k);
		}

		// if a.length == 0 return the kth in B
		if (a == m) {
			return B[k - 1 + b];
		}

		// if k == 1
		if (k == 1) {
			return (Math.min(A[a], B[b]));
		}

		// ak, k/2 th index of int[] a
		int ak = Math.min(k / 2, m - 1 - a);
		// bk, the k/2 index of int[] b
		int bk = k - ak;
		if (A[ak - 1 + a] == B[bk - 1 + b]) {
			return A[ak - 1 + a];
		} else if (A[ak - 1 + a] < B[bk - 1 + b]) {
			return getKth(A, a + ak, B, b, k - ak);
		} else {
			return getKth(A, a, B, b + bk, k - bk);
		}

	}
}

// Kai's solution 2014/05/05
class Solution002_2 {
	public double findMedianSortedArrays(int[] A, int[] B) {
		int sizeA = A.length;
		int sizeB = B.length;
		if ((sizeA + sizeB) % 2 == 1) {
			return getKth(A, sizeA, B, sizeB, (sizeA + sizeB + 1) / 2);
		} else {
			return (getKth(A, sizeA, B, sizeB, (sizeA + sizeB) / 2) + getKth(A,
					sizeA, B, sizeB, (sizeA + sizeB) / 2 + 1)) / 2.0;
		}
	}

	double getKth(int[] A, int m, int[] B, int n, int k) {
		// let A.length < B.length
		if (m > n) {
			return getKth(B, n, A, m, k);
		}

		// if a.length == 0 return the kth in B
		if (m == 0) {
			return B[k - 1];
		}

		// if k == 1
		if (k == 1) {
			return (Math.min(A[0], B[0]));
		}

		int ak = Math.min(k / 2, m);
		int bk = k - ak;
		if (A[ak - 1] == B[bk - 1]) {
			return A[ak - 1];
		} else if (A[ak - 1] < B[bk - 1]) {
			return getKth(Arrays.copyOfRange(A, ak, m), m - ak, B, n, k - ak);
		} else {
			return getKth(A, m, Arrays.copyOfRange(B, bk, n), n - bk, k - bk);
		}

	}
}

class Solution002 {
	public double findMedianSortedArrays(int[] A, int[] B) {
		int sizeA = A.length;
		int sizeB = B.length;
		if ((sizeA + sizeB) % 2 == 1) {
			return getKth(A, B, (sizeA + sizeB + 1) / 2);
		} else {
			return (getKth(A, B, (sizeA + sizeB) / 2) + getKth(A, B,
					(sizeA + sizeB) / 2 + 1)) / 2.0;
		}
	}

	double getKth(int[] a, int[] b, int k) {
		int m = a.length;
		int n = b.length;

		if (n == 0)
			return a[k - 1];
		if (m == 0)
			return b[k - 1];
		if (k == 1)
			return Math.min(a[0], b[0]);

		// divide k into two parts
		int p1 = Math.min(k / 2, m);
		int p2 = Math.min(k - p1, n);

		if (a[p1 - 1] < b[p2 - 1])
			return getKth(Arrays.copyOfRange(a, p1, m), b, k - p1);
		else if (a[p1 - 1] > b[p2 - 1])
			return getKth(a, Arrays.copyOfRange(b, p2, n), k - p2);
		else
			return a[p1 - 1];
	
	}
}