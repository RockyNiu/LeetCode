package leetcode.java;
/* Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest 
 * palindromic substring.
 */

public class LongestPalindrome {

	public static void main(String[] args) {
		String s = "bb";
		Solution005_2 solution = new Solution005_2();
		String longest = solution.longestPalindrome(s);
		System.out.println(longest);
	}

}

// 20140409
class Solution005_2{
	String longestPalindrome (String s){
		int len = s.length();
		if (len == 0 || len == 1){
			return s;
		}
		
		String longest = s.substring(0);
		for (int i = 0; i < len; i++) {
			String s1 = expandCenter(s,i,i);
			if (s1.length() > longest.length()){
				longest = s1;
			}
			
			String s2 = expandCenter(s,i,i+1);
			if (s1.length() > longest.length()){
				longest = s2;
			}
		}
		return longest;
	}
	
	String expandCenter(String s, int left, int right){
		while (left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		return s.substring(left+1,right);
	}
}

class Solution005 {
	String longestPalindrome (String s){
		String longest;
		
		int l = s.length();
		if (l==0) return "";
		
		longest = s.substring(0,1); // a single char itself is a palindrome
		for (int i = 0; i < l-1; i++) {
			String s1 = expandCenter(s,i,i);
			if (s1.length() > longest.length()) longest = s1;
			
			String s2 = expandCenter(s,i,i+1);
			if (s2.length() > longest.length()) longest = s2;
		}
		
		return longest;
	} 
	
	String expandCenter(String s, int c1, int c2){
		int left = c1, right = c2+1;
		int l = s.length();
		while ((left>=0) && (right<= l) && (s.charAt(left)==s.charAt(right-1))){
			left--;
			right++;
		}
		return s.substring(left+1, right-1);
	}
}