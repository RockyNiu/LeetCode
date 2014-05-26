package leetcode.java;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

	/**
	 * Given n non-negative integers representing the histogram's bar height
	 * where the width of each bar is 1, find the area of largest rectangle in
	 * the histogram.
	 * 
	 * 
	 * Above is a histogram where width of each bar is 1, given height =
	 * [2,1,5,6,2,3].
	 * 
	 * 
	 * The largest rectangle is shown in the shaded area, which has area = 10
	 * unit.
	 * 
	 * For example, Given height = [2,1,5,6,2,3], return 10.
	 */
	public static void main(String[] args) {
		int[] A = {0};
		Solution084 solution = new Solution084();
		System.out.println(solution.largestRectangleArea(A));
	}

}

class Solution084{
	
	public int largestRectangleArea(int[] height) {
		if (height.length == 0)
			return 0;

		int maxArea = height[0];
		Stack<Integer> stack = new Stack<Integer>();
		int[] h = Arrays.copyOf(height, height.length + 1);
		int i = 0;
		while (i < h.length) {
			if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
				stack.push(i++);
			} else {
				int temp = stack.pop();
				maxArea = Math.max(maxArea, h[temp]
						* (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}

		return maxArea;
	}
}
