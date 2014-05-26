package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	/**
	 * Given an array of strings, return all groups of strings that are
	 * anagrams.
	 * 
	 * Note: All inputs will be in lower-case.
	 */
	public static void main(String[] args) {
		String[] strs = {"abc","bc","acb","add"};
		Solution048 solution = new Solution048();
		ArrayList<String> anagrams = solution.anagrams(strs);
		for (int i = 0; i < anagrams.size(); i++) {
			System.out.println(anagrams.get(i));
		}
	}

}

class Solution048{
	public ArrayList<String> anagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<String> anagrams = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
        	String s = strs[i];
        	
        	// sort s
        	char[] cArray = s.toCharArray();
        	Arrays.sort(cArray);
        	s = String.valueOf(cArray);
        	
        	if(map.get(s)==null){
        		map.put(s, i);
        	}
        	else {
        		int index = map.get(s);
        		if (index >= 0){
        			anagrams.add(strs[index]);
        			map.put(s, -1);
        		}
        		anagrams.add(strs[i]);        		
        	}
        	
		}
        return anagrams;
    }
}