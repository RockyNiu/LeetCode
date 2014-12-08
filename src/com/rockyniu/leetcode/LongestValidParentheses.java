package com.rockyniu.leetcode;

import java.util.Stack;

public class LongestValidParentheses {
	/*
	 * Given a string containing just the characters '(' and ')', find the
	 * length of the longest valid (well-formed) parentheses substring.
	 * 
	 * For "(()", the longest valid parentheses substring is "()", which has
	 * length = 2.
	 * 
	 * Another example is ")()())", where the longest valid parentheses
	 * substring is "()()", which has length = 4.
	 */
}

class Solution031{
    public int longestValidParentheses(String s) {
        Stack stack = new Stack();
        int result = 0;
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='('){
				stack.push(i);
			}
			else if (stack.isEmpty()){ // no match left
				last = i;
			}
			else {
				stack.pop();
				if (stack.isEmpty()){
					result = Math.max(result,i - last);
				}
				else{
					result = Math.max(result, i - (int)stack.peek());
				}
			}
		}
        
        return result;
    }
	
}