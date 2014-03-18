package leetcode.java;
/*
 * Given a sorted array, remove the duplicates in place 
 * such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] A = {1,2,2,3};
		Solution054 solution = new Solution054();
		System.out.println(solution.removeDuplicates(A));
	}

}

class Solution054{
    public int removeDuplicates(int[] A) {
    	if (A.length == 0) return 0;
    	int n = 0;
        for (int i = 0; i < A.length; i++) {
			int num = A[n];
			while (i<A.length && A[i]==num){
				i++;
			}
			
			if (i<A.length && A[i]!=num){
				n = n+1;
				A[n] = A[i];
			}
		}
        return n+1;
    }
}