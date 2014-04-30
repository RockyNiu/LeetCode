package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: 
 * (-1, 0, 0, 1) 
 * (-2, -1, 1, 2) 
 * (-2, 0, 0, 2)
 */
public class FourSum {
	public static void main(String[] args) {
		int[] num = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		Solution017 solution = new Solution017();
		ArrayList<ArrayList<Integer>> arrays = solution.fourSum(num, target);
		present(arrays);
	}

	static void present(ArrayList<ArrayList<Integer>> arrays) {
		for (int i = 0; i < arrays.size(); i++) {
			System.out.print("\n{");
			for (int j = 0; j < arrays.get(i).size() - 1; j++) {
				System.out.print(arrays.get(i).get(j) + ",\t");
			}
			System.out.print(arrays.get(i).get(arrays.get(i).size() - 1) + "}");
		}
	}
}

class Solution017 {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
		if (num.length < 4)
			return arrays;
		Arrays.sort(num);

		for (int i = 0; i < num.length - 3; i++) {

			if (i > 0 && num[i] == num[i - 1]) // move i;
				continue;

			for (int j = i + 1; j < num.length - 2; j++) {

				if (j > i + 1 && num[j] == num[j - 1]) // move j;
					continue;

				// main loop
				int i2 = j + 1;
				int j2 = num.length - 1;
				while (i2 < j2) {
					if (num[i] + num[i2] + num[j2] + num[j] < target)
						i2++;
					else if (num[i] + num[i2] + num[j2] + num[j] > target)
						j2--;
					else {
						arrays.add(this.array2List(new int[] { num[i], num[j],
								num[i2], num[j2] }));

						i2++;
						while (i2 < j2 && num[i2] == num[i2 - 1]) {
							i2++;
						}

						j2--;
						while (i2 < j2 && num[j2] == num[j2 + 1]) {
							j2--;
						}
					}
				}
			}
		}
		return arrays;
	}

	ArrayList<Integer> array2List(int[] nums) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			array.add(nums[i]);
		}
		return array;
	}
}