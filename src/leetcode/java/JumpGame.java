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
}

class Solution054{
	public boolean canJump(int[] A) {
        int n = A.length;
        int isTouchable = 0;
        for (int index=0; index<=isTouchable && index < n; index++){
            if (A[index]+index > isTouchable){
                isTouchable = A[index]+index;
            }
            if (isTouchable >= n-1){
                return true;
            }
        }
        return false;
    }
}

