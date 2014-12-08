package com.rockyniu.leetcode;

public class BestTimeToBuyAndSellStock {

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 */
	public static void main(String[] args) {
		int[] A = {1,2,0,5};
		Solution121 solution = new Solution121();
		System.out.println(solution.maxProfit(A));
	}

}

class Solution121{
	
	public int maxProfit(int[] prices) {
		int max = 0;
		int minPrice = Integer.MAX_VALUE;
		int diff = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice){
				minPrice = prices[i];
			}
			diff = prices[i] - minPrice;
			if (max < diff){
				max = diff;
			}
		}
		
		return max;
	}
}
