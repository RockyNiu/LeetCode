package com.rockyniu.leetcode;

public class ClimbingStairs {
	/*
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 */
	public static void main(String[] args) {
		int n = 6;
		Solution070 solution = new Solution070();
		System.out.println(solution.climbStairs(n));
	}
}

class Solution070{
	public int climbStairs(int n) {
        if (n < 4) return n;
        int a = 2; // n = 2 
        int b = 3; // n = 3
        int c = 5; // n = 4
        for (int i = 5; i <= n; i++) {
			a = c;
			c = b + c;
			b = a;
		}
        return c;
    }
	
}