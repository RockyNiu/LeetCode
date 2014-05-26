package leetcode.java;
/* Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
	public static void main(String[] args){
		String[] strs = new String[]{};
		Solution014 solution = new Solution014();
		System.out.println("common:"+solution.longestCommonPrefix(strs));
	}
}

class Solution014{
	public String longestCommonPrefix(String[] strs) {
//        assert strs.length > 1 : "the length of strs < 2!";
		
		if (strs.length==0) return "";
		if (strs.length==1) return strs[0];
		
		String common = strs[0];
		int i = 1;
		while (!common.isEmpty() && i< strs.length){
			common = this.common(common, strs[i]);
			i++;
		}
		
		return common;
    }
	
	String common (String s1, String s2){
		String common = "";
		if (!s1.isEmpty()&&!s2.isEmpty()){
			int len = Math.min(s1.length(), s2.length());
			int i = 0;
			while (i < len && s1.substring(0,i+1).equals(s2.substring(0,i+1))){
				i++;
				common = s1.substring(0,i);
			}
		}
		
		return common;
	}
}