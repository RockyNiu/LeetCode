package leetcode.java;

import java.util.HashMap;
import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid 
but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public static void main(String[] args) {
		String str = "}()[]";
		Solution020 solution = new Solution020();
		System.out.println(solution.isValid(str));
	}
}

class Solution020{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
    	hm.put('(', ')');
    	hm.put('[', ']');
    	hm.put('{', '}');
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
			if (c=='(' || c=='[' || c=='{')
				stack.push(c);
			else{
				if(stack.empty() || c!=hm.get(stack.pop()))
					return false;
			}
		}

		if(!stack.empty())
			return false;
    	return true;
    }
}