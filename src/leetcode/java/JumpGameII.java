package leetcode.java;

public class JumpGameII {
	/*
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Your goal is to reach the last index in the minimum number of jumps.
	 * 
	 * For example: Given array A = [2,3,1,1,4]
	 * 
	 * The minimum number of jumps to reach the last index is 2. (Jump 1 step
	 * from index 0 to 1, then 3 steps to the last index.)
	 */
	public static void main(String[] args) {
//		int[] A = { 2, 3, 1, 1, 4 };
		int[] A = {1,2,0,1};
		Solution044 solution = new Solution044();
		System.out.println(solution.jump(A));
	}

}

class Solution044{
    public int jump(int[] A) {
        int minCount = 0;
        int maxRange = 0;
        int temp = maxRange;
        int i = 0;
        while (temp < A.length - 1 ) {
        	
			while (i<=temp){
				maxRange = Math.max(maxRange, A[i]+i);
				i++;
			}
			minCount++;
			temp = maxRange;
		}
        
        return minCount;
    }
	
}