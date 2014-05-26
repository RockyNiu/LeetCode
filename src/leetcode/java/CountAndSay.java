package leetcode.java;

public class CountAndSay {

	/**
	 * The count-and-say sequence is the sequence of integers beginning as
	 * follows: 1, 11, 21, 1211, 111221, ...
	 * 
	 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is
	 * read off as "one 2, then one 1" or 1211. Given an integer n, generate the
	 * nth sequence.
	 * 
	 * Note: The sequence of integers will be represented as a string.
	 */
	public static void main(String[] args) {
		int n = 5;
		Solution037 solution = new Solution037();
		System.out.println(solution.countAndSay(n));

	}

}

class Solution037 {
	public String countAndSay(int n) {
		assert (n >= 0) : "n<0!";
		if (n == 0)
			return "";
		
		String result = "1";
		for (int i = 1; i < n; i++) {
			result = countNext(result);
		}

		return result;

	}

	// generate the next string
	String countNext(String s) {
		if (s.isEmpty())
			return "";

		int len = s.length();
		char c = s.charAt(0);
		String result = "";

		int index = 1;
		int num = 1; // for each different char
		while (index < len) {
			if (s.charAt(index) != c) {
				result = result + Integer.toString(num) + c;
				c = s.charAt(index);
				num = 1;
			} else {
				num++;
			}
			index++;
		}
		result = result + Integer.toString(num) + c;
		return result;
	}

}