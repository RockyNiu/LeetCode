/*Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
package leetcode.java;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String str="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		Solution003 solution = new Solution003();
		int n = solution.lengthOfLongestSubstring(str);
		System.out.println(n);
	}
}

class Solution003{
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		int i = 0;
		int j = 0;
		boolean[] visited = new boolean[256];
		int maxLen = 0;
		while (j < len){
			if (visited[s.charAt(j)]){//if already visited
				maxLen = Math.max(maxLen, j-i);
				while (s.charAt(i) != s.charAt(j)){
					visited[s.charAt(i)] = false;
					i++;
				}
				i++;
			}
			else{//if not visited
				visited[s.charAt(j)] = true;
			}
			j++;
		}
		maxLen = Math.max(maxLen, len - i);
		return maxLen;        
    }
}
