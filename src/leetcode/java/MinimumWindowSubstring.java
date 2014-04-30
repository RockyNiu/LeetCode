package leetcode.java;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	/**
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
	 * 
	 * Note: If there is no such window in S that covers all characters in T,
	 * return the emtpy string "".
	 * 
	 * If there are multiple such windows, you are guaranteed that there will
	 * always be only one unique minimum window in S.
	 */
	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		Solution076 solution = new Solution076();
		System.out.println(solution.minWindow(S,T));

	}

}

class Solution076{
	public String minWindow(String S, String T) {
        if (S == null|| T == null){
        	return null;
        }
        
        if (S.length()==0 && T.length()==0){
        	return "";
        }
        
        if (S.length() < T.length()){
        	return "";
        }
        
        if (S.equals(T)){
        	return T;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
        	found.put(c, 0);
			if (map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
        
        int minStart = -1;
        int minEnd = S.length();
        int start = 0;
        int len = 0;
        for (int i = 0; i < S.length(); i++) {
        	char c = S.charAt(i);
			if (found.containsKey(c)){
				found.put(c, found.get(c)+1);
				if(found.get(c)<= map.get(c)){
					len++;
				}
				if (len == T.length()){
					while ((!map.containsKey(S.charAt(start)) || found.get(S
									.charAt(start)) > map.get(S.charAt(start)))) {
						if (map.containsKey(S.charAt(start))){
							found.put(S.charAt(start), found.get(S.charAt(start))-1);
						}
						start++;
					}
					if (i-start<minEnd-minStart){
						minStart = start;
						minEnd = i;
					}
				}
			}
		}
        if (minStart==-1){
        	return "";
        }
        return S.substring(minStart, minEnd+1);
    }
}