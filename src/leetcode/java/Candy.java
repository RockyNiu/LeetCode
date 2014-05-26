package leetcode.java;

public class Candy {

	/**
	 * There are N children standing in a line. Each child is assigned a rating
	 * value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * 1) Each child must have at least one candy. 2) Children with a higher
	 * rating get more candies than their neighbors.
	 * 
	 * What is the minimum candies you must give?
	 */
	public static void main(String[] args) {
		int[] ratings = new int[] { 1, 0, 2, 3 };
		Solution135 solution = new Solution135();
		System.out.println(solution.candy(ratings));
	}

}

class Solution135 {
	public int candy(int[] ratings) {
		assert (ratings != null) : "Please input ratings!";

		int len = ratings.length;
		if (len == 0 || len == 1)
			return len;

		int[] dp = new int[len];

		// left -> right
		for (int i = 1; i < len; i++) {
			if (ratings[i] > ratings[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			}
		}

		// right -> left
		for (int i = len - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && dp[i] < dp[i + 1] + 1) {
				dp[i] = dp[i + 1] + 1;
			}
		}

		int result = len;
		for (int i = 0; i < dp.length; i++) {
			result += dp[i];
		}

		return result;
	}

}