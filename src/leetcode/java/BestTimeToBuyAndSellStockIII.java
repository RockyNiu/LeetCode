package leetcode.java;

public class BestTimeToBuyAndSellStockIII {

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 */
	public static void main(String[] args) {
		int[] A = {1,2,3,5,0,7,6,5,8};
		Solution123 solution = new Solution123();
		System.out.println(solution.maxProfit(A));
	}

}

class Solution123{
	
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		
		int[] maxProfits = new int[prices.length]; // save the max profits
		maxProfits[0] = 0;
		
		// ordered search
		int minPrice = prices[0];
		int maxProfit = 0;
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			profit = prices[i] - minPrice;
			if (profit > maxProfit){
				maxProfit = profit;
			}
			maxProfits[i] = maxProfit;
			if (prices[i] < minPrice){
				minPrice = prices[i];
			}
		}
		
		// reversed order search
		int both = maxProfits[prices.length-1];
		int maxPrice = prices[prices.length-1];
		maxProfit = 0;
		int temp = 0;
		for (int i = prices.length-2; i>=0; i--) {
			profit = maxPrice - prices[i];
			if (profit > maxProfit){
				maxProfit = profit;
			}
			temp = maxProfit + maxProfits[i];
			if (temp > both){
				both = temp;
			}
			if (prices[i] > maxPrice){
				maxPrice = prices[i];
			}			
		}
		
		return both;
	}
}
