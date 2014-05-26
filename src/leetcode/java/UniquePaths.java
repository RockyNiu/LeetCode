package leetcode.java;

public class UniquePaths {
	/*
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 */
}

class Solution061{
    public int uniquePaths(int m, int n) {
	    int[] paths = new int[n];
	    paths[0] = 1;
    	
	    for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				paths[j] = paths[j-1]+paths[j];				
			}
		}
    	
    	return paths[n-1];
    }
	
	
}