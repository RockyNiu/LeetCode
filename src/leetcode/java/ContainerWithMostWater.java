package leetcode.java;

import java.util.Random;

public class ContainerWithMostWater {

	/*
	 * Given n non-negative integers a1, a2, ..., an, where each represents a
	 * point at coordinate (i, ai). n vertical lines are drawn such that the two
	 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
	 * together with x-axis forms a container, such that the container contains
	 * the most water.
	 * 
	 * Note: You may not slant the container.
	 */
	public static void main(String[] args){
		Random generator = new Random(20140102);
		int N = 10;
		int[] height = new int[N];
		for (int i = 0; i < N; i++) {
			height[i] = generator.nextInt(Integer.MAX_VALUE/N);
			System.out.println(i+":\t"+height[i]);
		}
		
		Solution011 solution = new Solution011();
		System.out.println(solution.maxArea(height));
	}
}

class Solution011{
	public int maxArea(int[] height) {
		int n = height.length;
		int left = 0, right = n-1;
		int max = 0;
        
		while (left < right){
			max = Math.max(max, (right-left)*Math.min(height[left], height[right]));
			if (height[left] < height[right]){
				left ++;
			}
			else{
				right --;
			}
			
		}
		
        return max;
    }
}