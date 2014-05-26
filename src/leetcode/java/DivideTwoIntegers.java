package leetcode.java;

/*
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {

	public static void main(String[] args) {
		int a = 1;
		int b = -2147483648;
		Solution028 solution = new Solution028();
		System.out.println("max:" + Integer.MAX_VALUE);
		System.out.println("min:" + Integer.MIN_VALUE);
		System.out.println(a + " / " + b + " = " + solution.divide(a, b));
	}
}

class Solution028 {
	public int divide(int dividend, int divisor) {
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		int flag = (dividend ^ divisor) >> 31;

		int div = 0;
		if (a == 0)
			return 0;

		while (a >= b) {
			long c = b;
			for (int i = 0; a >= c; i++, c <<= 1) {
				a = a - c;
				div = div + (1 << i);
			}
		}

		if (flag == 0) {
			return div;
		} else {
			return -div;
		}
	}
}