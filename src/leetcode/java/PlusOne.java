package leetcode.java;

public class PlusOne {

	/**
	 * Given a non-negative number represented as an array of digits, plus one
	 * to the number.
	 * 
	 * The digits are stored such that the most significant digit is at the head
	 * of the list.
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Solution067 solution = new Solution067();
		Utils.print(solution.plusOne(input));
	}

}

class Solution067 {
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		if (len == 0) {
			return digits;
		}

		if (digits[len - 1] != 9) {
			digits[len - 1] = digits[len - 1] + 1;
			return digits;
		}

		int index = len - 1;
		while (index >= 0 && digits[index] == 9) {
			index--;
		}

		if (index == -1) {
			// digits == 9999...
			int[] newDigits = new int[len + 1];
			newDigits[0] = 1;
			return newDigits;
		} else {
			digits[index] = digits[index] + 1;
			for (int i = index + 1; i < len; i++) {
				digits[i] = 0;
			}
			return digits;
		}
	}
}