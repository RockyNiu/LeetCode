package com.rockyniu.leetcode;
/*Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") â†?false
isMatch("aa","aa") â†?true
isMatch("aaa","aa") â†?false
isMatch("aa", "a*") â†?true
isMatch("aa", ".*") â†?true
isMatch("ab", ".*") â†?true
isMatch("aab", "c*a*b") â†?true
*/
public class RegularExpressionMatching {
	public static void main(String[] args){
		String s = "";
		String p = "c*c*";
		Solution010 solution = new Solution010();
		System.out.println(solution.isMatch(s, p));
	}
}

class Solution010{
	public boolean isMatch(String s, String p) {
        
		if (p.isEmpty()) return s.isEmpty();
		
		if (p.length() == 1) {
			if (s.isEmpty()) return p.isEmpty()||(p.charAt(0)=='*');
			return (p.charAt(0)==s.charAt(0) && s.length()==1)||
					(p.charAt(0)=='.' && s.length()==1) ||
					p.charAt(0)=='*';
		}
		
		// if next char of p is not *, then the current strings must match.
		if (p.length() > 1){
			if (s.isEmpty()) return p.charAt(1)=='*' && isMatch(s,p.substring(2));
			if (p.charAt(1)!='*'){
				assert (p.charAt(0)!='*'):"Repeating '*'!";
				return ( p.charAt(0)==s.charAt(0) || (p.charAt(0)=='.' && !s.isEmpty()) )
						&& isMatch(s.substring(1),p.substring(1));
			}
			
			// if next char of p is *
			while ( !s.isEmpty() && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')){
				if (isMatch(s,p.substring(2))) return true;
				s = s.substring(1);
			}
		}
		return (isMatch(s,p.substring(2)));
    }
}