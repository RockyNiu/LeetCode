package leetcode.java;
/* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

*/
public class ZigZagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		Solution006 solution = new Solution006();
		String output = solution.convert(s, 3);
		System.out.println(output);
	}
}

class Solution006{
    public String convert(String s, int nRows) {
    	
    	int len = s.length();
    	
    	if ((nRows==1)||(len<nRows)) return s;
        
        int block = nRows*2-2;
        int nBlock = (len+block-len%block)/block;
        int[][] location = new int[nRows][nBlock*(nRows-1)];
        
        // reseting the location of each char
        main:
        for (int i = 0; i < nBlock; i++) {
        	for (int j = 0; j < block; j++) {
        		int num = i*block+j;
        		if (num >= len) break main;
				if (j < nRows){
					location[j][i*(nRows-1)] = num;
				}
				else{
					location[2*(nRows-1)-j][i*(nRows-1)+j-nRows+1] = num;
				}
			}
		}
        
        // output string
        StringBuilder builder = new StringBuilder();
        builder.append(s.charAt(0));
        for (int i = 0; i < nRows; i++) {
        	for (int j = 0; j < nBlock*(nRows-1); j++) {
        		int locOld = location[i][j];
        		if (locOld!=0){
        			builder.append(s.charAt(locOld));
        		}
			}
		}
        return builder.toString();
    }
}
