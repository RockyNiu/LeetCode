package leetcode.java;

public class ValidPalindrome {

	/**
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 */
	public static void main(String[] args) {
		String S = "A man, a plan, a canal: Panama";
		Solution125 solution = new Solution125();
		System.out.println(solution.isPalindrome(S));
	}

}

class Solution125{
	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
				left++;
			};
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
				right--;
			};
			if (Character.toLowerCase(s.charAt(left)) != Character
					.toLowerCase(s.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
    }
}