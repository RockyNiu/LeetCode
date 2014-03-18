package leetcode.java;

public class JumpGame {
	/*
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * For example: A = [2,3,1,1,4], return true.
	 * 
	 * A = [3,2,1,0,4], return false.
	 */
	public static void main(String[] args) {
		int[] A = {2,3,1,1,4};
		Solution054 solution = new Solution054();
		System.out.println(solution.canJump(A));
	}
}

public class Solution054 {
    public boolean canJump(int[] A) {
    
    	if (A.length <=1)
    		return true;
    	
    	return canJumpToCurrent(A,A.length-2);    
    	
    }

	boolean canJumpToCurrent(int[] a, int i) {
		
		
		return false;
	}
    
    
}