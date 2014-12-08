package com.rockyniu.leetcode;

/*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and 
ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are 
responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace 
character is found. Then, starting from this character, takes an optional initial plus or minus sign 
followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored
 and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no 
such sequence exists because either str is empty or it contains only whitespace characters, no conversion
 is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the
 range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/
public class String2Integer {
	public static void main(String[] args){
		String str = "-2147483648**";
		Solution008 solution = new Solution008();
		System.out.println(solution.atoi(str)+"");
	}
}

class Solution008{
	public int atoi(String str) {
		long num = 0;
		str = str.trim(); // discards the whitespace at beginning and ends
        if (str.isEmpty()) return 0; // if str is empty or only contains whitespace

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[-+]?\\d+.*");
        java.util.regex.Matcher matcher = pattern.matcher(str);
		int flag = 1;
		int i = 0;
		
		if (matcher.matches()){
			if (str.charAt(0)=='-'){ // if str starts with -
				flag = -1;
				i = 1;
			}
			else if (str.charAt(0)=='+'){ // if str starts with +
				flag = 1;
				i = 1;
			}
			
			// main loop
			while (i<str.length()&&(java.lang.Character.isDigit(str.charAt(i)))){
				num = num*10 + Long.valueOf(String.valueOf(str.charAt(i)))*flag;
				i++;
				if (num > Integer.MAX_VALUE){
						num = Integer.MAX_VALUE;
						return (int) num;
				}
				else if (num < Integer.MIN_VALUE){
						num = Integer.MIN_VALUE;
						return (int) num;
				}
			}
		}
		return (int) num;
    }
	
}