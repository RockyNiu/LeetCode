package leetcode.java;

public class Sqrt {

	/**
	 * Implement int sqrt(int x).
	 * 
	 * Compute and return the square root of x.
	 */
	public static void main(String[] args) {
		int x = 2147395599;
		Solution069 solution = new Solution069();
		int q = solution.sqrt(x);
		System.out.println(q + "\t*\t" + q + "\t=\t" + q*q);
		System.out.println("x\t\t\t=\t"+x);
		System.out.println((q+1) + "\t*\t" + (q+1) + "\t=\t" + (q+1)*(q+1));
	}
}

class Solution069 {
	public int sqrt(int x) {
		assert (x >= 0) : "x < 0!!";
		if (x == 0)
			return 0;
		
		long longX = (long) x;
		long q = longX;
		while (longX < q * q) {
			q = (q + longX / q) / 2;
		}
		return (int)q;
	}

}