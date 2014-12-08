package com.rockyniu.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	/**
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary
	 * words.
	 * 
	 * For example, given s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 */
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		String s = "leetcode";
		Solution139 solution = new Solution139();
		System.out.println(solution.wordBreak(s, dict));
	}

}

class Solution139{
	public boolean wordBreak(String s, Set<String> dict) {
		String s2 = "$" + s;
		int len = s2.length();
		boolean[] possible = new boolean[len];
		possible[0] = true;
		
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				possible[i] = possible[j] && dict.contains(s2.substring(j+1, i+1));
				if (possible[i]){
					break;
				}
			}
		}
        return possible[len-1];
    }
}