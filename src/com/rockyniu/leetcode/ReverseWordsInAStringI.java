package com.rockyniu.leetcode;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Clarification: What constitutes a word? A sequence of non-space characters
 * constitutes a word. Could the input string contain leading or trailing
 * spaces? Yes. However, your reversed string should not contain leading or
 * trailing spaces. How about multiple spaces between two words? Reduce them to
 * a single space in the reversed string.
 * 
 * https://oj.leetcode.com/problems/reverse-words-in-a-string/
 * 
 * @author RockyNiu
 *
 */
public class ReverseWordsInAStringI {

	public static void main(String[] args) {
		String str = "the  sky  is  blue  ";
		Solution151 solution = new Solution151();
		String reversed = solution.reverseWords(str);
		assert (reversed.equals("blue is sky the")) : "Wrong: output is \\"
				+ reversed + "\\";
		System.out.println(reversed);
	}
}

/**
 * O(n) runtime, O(n) space
 * 
 * @author RockyNiu
 *
 */
class Solution151 {
	/**
	 * will trim the blanks to single blank
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = j - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}
}