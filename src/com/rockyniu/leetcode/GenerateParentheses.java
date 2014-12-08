package com.rockyniu.leetcode;

import java.util.ArrayList;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of 
 * well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
	public static void main(String[] args) {
		int n = 3;
		Solution021 solution = new Solution021();
		present(solution.generateParenthesis(n));
	}
	
	static void present(ArrayList<String> strs){
		for (int i = 0; i < strs.size(); i++) {
			System.out.print(strs.get(i)+"\t");
		}
	}
}

class Solution021{
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> strs = new ArrayList<String>();
    	StringBuilder builder = new StringBuilder();
    	generate(strs, builder, n, 0,0,0);
        return strs;
    }
    
    void generate(ArrayList<String> strs, StringBuilder builder, int n,
    		int left, int right, int place){
    	if (place == n*2){
    		strs.add(builder.toString());
    		return;
    	}
    	
    	if (left < n){
    		builder.append('(');
    		generate(strs, builder, n, left+1, right, place+1);
    		builder.deleteCharAt(place);
    	}
    	
    	if (right < left){
    		builder.append(')');
    		generate(strs, builder, n, left, right+1, place+1);
    		builder.deleteCharAt(place);
    	}
    }
}