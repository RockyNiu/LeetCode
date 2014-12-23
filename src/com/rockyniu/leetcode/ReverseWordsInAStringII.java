package com.rockyniu.leetcode;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * The input string does not contain leading or trailing spaces and the words
 * are always separated by a single space. Could you do it in-place without
 * allocating extra space?
 * 
 * @author RockyNiu
 *
 */
public class ReverseWordsInAStringII {

	public static void main(String[] args) {
		String str = "the sky is blue";
		Solution151_2 solution = new Solution151_2();
		char[] array = str.toCharArray();
		solution.reverseWords(array);
		String reversed = String.copyValueOf(array);
		assert (reversed.equals("blue is sky the")) : "Wrong: output is \\"
				+ reversed + "\\";
		System.out.println(array);
	}
}

/**
 * O(n) runtime, O(1) space
 * 
 * @author RockyNiu
 *
 */
class Solution151_2 {
	/**
	 * @param s
	 * @return
	 */
	public void reverseWords(char[] s) {
		reverseWords(s, 0, s.length);
		for (int i = 0, j = 0; j <= s.length; j++) {
			if (j == s.length || s[j] == ' ') {
				reverseWords(s, i, j);
				i = j + 1;
			}
		}
	}

	private void reverseWords(char[] s, int begin, int end) {
		for (int i = begin; i < (begin + end) / 2; i++) {
			char temp = s[i];
			s[i] = s[begin + end - i - 1];
			s[begin + end - i - 1] = temp;
		}
	}
}