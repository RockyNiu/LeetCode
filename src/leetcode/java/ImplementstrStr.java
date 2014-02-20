package leetcode.java;

public class ImplementstrStr {
/*
 * Implement strStr().
 * using Knuth-Morris-Pratt Algorithm
 * 
 * http://en.wikipedia.org/wiki/Knuth-morris-pratt
 * 
 * Returns a pointer to the first occurrence of needle in haystack, 
 * or null if needle is not part of haystack.
 */
	public static void main(String[] args) {
		String S = "aaaaaab";
		String W = "b";
		Solution027_2 solution = new Solution027_2();
		System.out.println(solution.strStr(S,W));
	}

}

class Solution027_2{
	public String strStr(String haystack, String needle){
		if (needle.isEmpty())
			return haystack;
		if (haystack.isEmpty())
			return null;
		
		int m = 0;
		int i = 0;
		while (m+i<haystack.length()){
			if (needle.charAt(i) == haystack.charAt(m+i)){
        		if (i == needle.length()-1)
        				return haystack.substring(m);
        		else
        			i++;
        	}
    		else{
    			m++;
    			i = 0;
        	}
		}
		return null;
	}
	
}

class Solution027{
	public String strStr(String haystack, String needle) {
		if (needle.isEmpty())
			return haystack;
		if (haystack.isEmpty())
			return null;
		
		int m = 0; // the beginning of the current match in S
        int i = 0; // the position of the current character in W
        int[] T = kmpTable(needle);
        
        while (m+i<haystack.length()){
        	if (needle.charAt(i) == haystack.charAt(m+i)){
        		if (i == needle.length()-1)
        				return haystack.substring(m);
        		else
        			i++;
        	}
    		else{
    			m = m+i-T[i];
    			if (T[i]>-1)
    				i = T[i];
    			else
    				i = 0;
        			
        	}
        }
        return null;
    }
	
	int[] kmpTable(String needle){
		if (needle.length() == 0)
			return null;
		
		if (needle.length() == 1){
			int[] T = new int[1];
			T[0] = -1;
			return T;
		}
		
		int[] T = new int[needle.length()];
		int pos = 2; // the current position we are computing in T
		int cnd = 0; // current candidate substring
		T[0] = -1;
		T[1] = 0;
		while (pos < needle.length()){
			if (needle.charAt(pos-1) == needle.charAt(cnd)){
				cnd++;
				T[pos] = cnd;
				pos++;
			}
			else if (cnd > 0){
				cnd = T[cnd];
			}
			else{
				T[pos] = 0;
				pos++;
			}
		}
		
		return T;
	}
}