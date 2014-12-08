package com.rockyniu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PalindromePartitioning {

	/**
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return all possible palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return
	 * 
	 * [ ["aa","b"], 
	 * ["a","a","b"] ]
	 */
	public static void main(String[] args) {
		String s = "bb";
		Solution131 solution = new Solution131();
		ArrayList<ArrayList<String>> partition = solution.partition(s);
		System.out.println(partition);

	}

}

class Solution131{
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
		ArrayList<String> row = new ArrayList<String>();
		int len = s.length();
		if (len == 0 || len == 1){
			row.add(s);
			rows.add(row);
		}
		Set<String> dict = getPalindromes(s);
		
//		String s2 = "$" + s;
//		len = len+1;
//		boolean[] possible = new boolean[len];
//		possible[0] = true;
		
		for (int i = 0; i < len; i++) {
			for (int j = i; j >=0; j--) {
				if (dict.contains(s.substring(j, i+1))){
					
				}
				
			}
			
			rows.add(row);
		}
		
		return rows;
    }
	
	
	// get all palindromes in s
	Set<String> getPalindromes(String s){
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < s.length(); i++) {
			int left = i;
			int right = i;
			while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
				set.add(s.substring(left,right+1));
				left--;
				right++;
			}
			
			left = i;
			right = i+1;
			while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
				set.add(s.substring(left,right+1));
				left--;
				right++;
			}
		}
		return set;
	}
}