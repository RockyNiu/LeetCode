package com.rockyniu.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

	/**
	 * Evaluate the value of an arithmetic expression in Reverse Polish
	 * Notation.
	 * 
	 * Valid operators are +, -, *, /. Each operand may be an integer or another
	 * expression.
	 * 
	 * Some examples:
	 * 
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	 * ["4", "13", "5", "/","+"] -> (4 + (13 / 5)) -> 6
	 */
	public static void main(String[] args) {
		String[] tokens = { "4", "13", "5", "/", "+" };
		Solution150 solution = new Solution150();
		System.out.println(solution.evalRPN(tokens));
	}

}

class Solution150 {
	public int evalRPN(String[] tokens) {
		assert (tokens != null && tokens.length != 0) : "Please input right tokens!";
		
		Stack<String> stack = new Stack<String>();
		Set<String> operators = new HashSet<String>() {
			{
				add("+");
				add("-");
				add("*");
				add("/");
			}
		};
		
		
		int index = 1;
		stack.push(tokens[0]);
		int result = Integer.parseInt(tokens[0]);
		while (index < tokens.length && !stack.isEmpty()){
			if (operators.contains(tokens[index])){
				String second = stack.pop();
				String first = stack.pop();
				result = calculate(first, second, tokens[index]);
				stack.push(Integer.toString(result));
			} else {
				stack.push(tokens[index]);
			}
			index++;
		}
		
		return result;
	}
	
	private int calculate(String first, String second, String operator) {
		assert (!isNullOrEmpty(first) && !isNullOrEmpty(second) && !isNullOrEmpty(operator)) : "Please check input!";
		int a = Integer.parseInt(first);
		int b = Integer.parseInt(second);
		int result = 0;
		switch (operator){
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			result = a / b;
			break;
		}
		return result;
	}

	private boolean isNullOrEmpty(String str) {
		return (str == null || str.isEmpty());
	}
}