package leetcode.java;

import java.util.ArrayList;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want. 
 */
public class LetterCombinationsofPhoneNumbers {

	public static void main(String[] args) {
		String digits = "23";
		Solution018 solution = new Solution018();
		present(solution.letterCombinations(digits));
	}

	static void present(ArrayList<String> strs){
		for (int i = 0; i < strs.size(); i++) {
			System.out.print(strs.get(i)+"\t");
		}
	}
}

class Solution018{
    public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> strs = new ArrayList<String>();
    	StringBuilder builder = new StringBuilder();    	
    	String[] key = new String[10];
    	key[0]=" ";
    	key[1]="1";
    	key[2]="abc";
        key[3]="def";
        key[4]="ghi";
        key[5]="jkl";
        key[6]="mno";
        key[7]="pqrs";
        key[8]="tuv";
        key[9]="wxyz";
        
        combination(strs, builder, key, digits,0);
        return strs;
    }
    
    void combination(ArrayList<String> strs, StringBuilder builder, 
    		String[] key, String digits, int place){
    	if (place == digits.length()){
    		strs.add(builder.toString());
    		return;
    	}
    	
    	String s = key[digits.charAt(place)-'0'];
    	
    	for (int i = 0; i < s.length(); i++) {
			builder.append(s.charAt(i));
			combination(strs, builder, key, digits, place+1);
			builder.deleteCharAt(place);
		}
    	
    }
}