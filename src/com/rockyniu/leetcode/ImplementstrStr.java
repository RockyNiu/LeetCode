package com.rockyniu.leetcode;

public class ImplementstrStr {
	/*
	 * Implement strStr(). using Knuth-Morris-Pratt Algorithm
	 * 
	 * http://en.wikipedia.org/wiki/Knuth-morris-pratt
	 * 
	 * Returns a pointer to the first occurrence of needle in haystack, or null
	 * if needle is not part of haystack.
	 */
	public static void main(String[] args) {
		String S = "aaaaaab";
		String W = "b";
		Solution027_3 solution = new Solution027_3();
		System.out.println(solution.strStr(S, W));

		Solution027_4 solution4 = new Solution027_4();
		System.out.println(solution4.strStr(S, W));
	}

}

/**
 * O(nm) runtime, O(1) space
 * 
 * @author RockyNiu
 *
 */
class Solution027_4 {
	public int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}
}

// 20140404
class Solution027_3 {
	public String strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return haystack;
		if (haystack.length() == 0)
			return null;

		int m = 0; // pos in haystack
		int i = 0; // pos in needle
		int[] T = kmpTable(needle);

		while (m + i < haystack.length()) {
			if (needle.charAt(i) == haystack.charAt(m + i)) {
				if (i == needle.length() - 1) {
					return haystack.substring(m);
				} else {
					i++;
				}
			} else {
				m = m + i - T[i];
				if (T[i] > -1) {
					i = T[i];
				} else {
					i = 0;
				}

			}
		}
		return null;
	}

	int[] kmpTable(String needle1) {
		int len = needle1.length();
		if (len == 0)
			return null;
		if (len == 1) {
			int[] T = new int[len];
			T[0] = -1;
			return T;
		}

		int[] T = new int[len];
		T[0] = -1;
		T[1] = 0;

		int pos = 2; // position in needle
		int cnd = 0; // candidate
		while (pos < len) {
			if (needle1.charAt(pos - 1) == needle1.charAt(cnd)) { // start from
				cnd++;
				T[pos] = cnd;
				pos++;
			} else if (cnd > 0) {
				cnd = T[cnd];
			} else { // cnd == 0
				T[pos] = 0;
				pos++;
			}
		}
		return T;
	}
}

class Solution027_2 {
	public String strStr(String haystack, String needle) {
		if (needle.isEmpty())
			return haystack;
		if (haystack.isEmpty())
			return null;

		int m = 0;
		int i = 0;
		while (m + i < haystack.length()) {
			if (needle.charAt(i) == haystack.charAt(m + i)) {
				if (i == needle.length() - 1)
					return haystack.substring(m);
				else
					i++;
			} else {
				m++;
				i = 0;
			}
		}
		return null;
	}
}

class Solution027 {
	public String strStr(String haystack, String needle) {
		if (needle.isEmpty())
			return haystack;
		if (haystack.isEmpty())
			return null;

		int m = 0; // the beginning of the current match in haystack
		int i = 0; // the position of the current character in needle
		int[] T = kmpTable(needle);

		while (m + i < haystack.length()) {
			if (needle.charAt(i) == haystack.charAt(m + i)) {
				if (i == needle.length() - 1)
					return haystack.substring(m);
				else
					i++;
			} else {
				m = m + i - T[i]; // it is good to set T[0] = -1;
				if (T[i] > -1)
					i = T[i];
				else
					i = 0;

			}
		}
		return null;
	}

	int[] kmpTable(String needle) {
		if (needle.length() == 0)
			return null;

		if (needle.length() == 1) {
			int[] T = new int[1];
			T[0] = -1;
			return T;
		}

		int[] T = new int[needle.length()];
		int pos = 2; // the current position we are computing in T
		int cnd = 0; // current candidate substring
		T[0] = -1;
		T[1] = 0;
		while (pos < needle.length()) {
			if (needle.charAt(pos - 1) == needle.charAt(cnd)) {
				cnd++;
				T[pos] = cnd;
				pos++;
			} else if (cnd > 0) {
				cnd = T[cnd];
			} else { // cnd == 0
				T[pos] = 0;
				pos++;
			}
		}

		return T;
	}
}