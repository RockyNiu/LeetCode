package leetcode.java;

import java.util.ArrayList;

public class GrayCode {

	/**
	 * The gray code is a binary numeral system where two successive values
	 * differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of bits in
	 * the code, print the sequence of gray code. A gray code sequence must
	 * begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 
	 * 00 - 0 
	 * 01 - 1 
	 * 11 - 3 
	 * 10 - 2 
	 * Note: For a given n, a gray code sequence is not uniquely defined.
	 * 
	 * For example, [0,2,3,1] is also a valid gray code sequence according to
	 * the above definition.
	 * 
	 * For now, the judge is able to judge based on one instance of gray code
	 * sequence. Sorry about that.
	 */
	public static void main(String[] args) {
		int n = 3;
		Solution089 solution = new Solution089();
		ArrayList<Integer> grayCode = solution.grayCode(n);
		Utils.print(grayCode, "\n");
	}

}

class Solution089 {
	public ArrayList<Integer> grayCode(int n) {
		int BITS = 32;
		assert (n >= 0 && n < BITS) : "n<0 or n >= " + Integer.toString(BITS)
				+ " !";
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (n == 0) {
			list.add(0);
			return list;
		}

		for (int i = 0; i < Math.pow(2, n); i++) {
			list.add(getCode(i));
		}
		return list;
	}

	int getCode(int n) {
		String strCode = "";
		String str = Integer.toString(n, 2);
		int len = str.length();

		char flag = '0';
		int i = 0;
		while (i < len) {
			char c = str.charAt(i);

			if (i > 0) {
				if (flag == '1') {
					if (c == '0') {
						c = '1';
					} else {
						c = '0';
					}
				}
			}
			strCode = strCode + c;
			flag = str.charAt(i);
			i++;
		}
		return Integer.parseInt(strCode, 2);
	}
}