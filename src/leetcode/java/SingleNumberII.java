package leetcode.java;

/*
 * Given an array of integers, every element appears three times except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 1, 1, 3, 3, 3, 2 };
		Solution137 solution = new Solution137();
		System.out.println(solution.singleNumber(A));
	}

}

class Solution137 {
	public int singleNumber(int[] A) {
		int ones = 0; //the bits with repeated 3k+1 "1";
		int twos = 0; //the bits with repeated 3k+2 "1";
		int xthrees = 0; // for clear the bits in ones and twos where 3k "1" repeatedly
		
		for (int i = 0; i < A.length; i++) {
			twos = twos | (ones&A[i]); // renew twos
			ones = ones^A[i]; //renew ones
			xthrees = ~(ones&twos); // the bits without repeated 3k "1"
			ones = ones&xthrees; // clear bits with repeated 3k "1" in ones
			twos = twos&xthrees; // clear bits with repeated 3k "1" in twos			
		}
		return ones;
	}
}