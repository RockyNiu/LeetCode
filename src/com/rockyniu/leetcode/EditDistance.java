package com.rockyniu.leetcode;

public class EditDistance {

	/**
	 * Given two words word1 and word2, find the minimum number of steps
	 * required to convert word1 to word2. (each operation is counted as 1
	 * step.)
	 * 
	 * You have the following 3 operations permitted on a word:
	 * 
	 * a) Insert a character 
	 * b) Delete a character 
	 * c) Replace a character
	 */
	public static void main(String[] args) {
		String word1 = "hello, world!";
		String word2 = "I have a dream!";
		Solution072 solution = new Solution072();
		System.out.println(solution.minDistance(word1, word2));
	}

}

class Solution072 {
	public int minDistance(String word1, String word2) {
		int length1 = word1.length();
		int length2 = word2.length();

		if (length1 == 0) {
			return length2;
		}

		if (length2 == 0) {
			return length1;
		}
		
		// dp[i][j] is the edit distance between two strings with length i and
		// length j
		int[][] dp = new int[length1 + 1][length2 + 1];
		for (int i = 0; i <= length1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= length2; j++) {
			dp[0][j] = j;
		}
		
		for (int i = 0; i < length1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < length2; j++) {
				char c2 = word2.charAt(j);
				if (c1==c2){
					dp[i+1][j+1] = dp[i][j];
				}
				else{
					int insert = dp[i][j+1] + 1;
					int delete = dp[i+1][j] + 1;
					int replace = dp[i][j] + 1;
					int minDistance = insert < delete ? insert : delete;
					minDistance = minDistance < replace ? minDistance : replace;
					dp[i+1][j+1] = minDistance;
				}
			}
		}
		return dp[length1][length2];
	}
}