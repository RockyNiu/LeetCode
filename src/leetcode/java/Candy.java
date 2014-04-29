package leetcode.java;

import java.util.HashSet;
import java.util.Set;

public class Candy {

	/**
	 * There are N children standing in a line. Each child is assigned a rating
	 * value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * 1) Each child must have at least one candy. 
	 * 2) Children with a higher rating get more candies than their neighbors.
	 * 
	 * What is the minimum candies you must give?
	 */
	public static void main(String[] args) {
		int[] ratings = new int[] { 2,0,1};
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
		
		int result = 0;
		
		// index for start and end
		int start = 0;
		int end = 0;
		int flag = 0; // increased 1 or decreased -1 or equal 0
		int highest = 0;
		
		int index = 1;
		if (ratings[1] > ratings[0]){
			flag = 1;
		} else if (ratings[1] == ratings[0]){
			flag = 0;
		} else {
			flag = -1;
		}
		
		print(start, end, index, flag, result);
		
		while (index < len){
			if (ratings[index] == ratings[index-1]){
				flag = 0;
				result = result + cal(end - start + 1);
				start = index;
				end = index;
				highest = 0;
			} else if (ratings[index] > ratings[index - 1]){
				if (flag == 1){
					end++;
				} else {
					result = result + cal(end - start) + highest;
					highest = end - start + 1;
					start = index - 1;
					end = index;
					flag = 1;
				}
			} else {
				if (flag == -1){
					end++;
				} else {
					result = result + cal(end - start) + highest;
					highest = end - start + 1;
					start = index - 1;
					end = index;
					flag = -1;

				}
			}
			print(start, end, index, flag, result);
			index++;
		}		
		return result + cal(end - start + 1);
	}

	private int cal(int n) {
		return (n + 1) * n / 2;
	}

	void print(int start, int end, int index, int flag, int result){
		System.out.print("\tstart:\t" + start);
		System.out.print("\tend:\t" + end);
		System.out.print("\tindex:\t" + end);
		System.out.print("\tflag:\t" + flag);
		System.out.print("\tresult:\t" + result + "\n");
	}
}