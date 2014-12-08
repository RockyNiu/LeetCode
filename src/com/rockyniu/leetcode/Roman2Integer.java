package com.rockyniu.leetcode;
/* Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class Roman2Integer {
	public static void main (String[] args){
		String roman = "DCXXI";
		Solution013 solution = new Solution013();
		System.out.println(solution.romanToInt(roman));
	}
}

class Solution013{
	public int romanToInt(String s) {
        int sum, thousands=0, hundreds=0, tens=0, ones=0;
        int index=0;
        int len = s.length();
        int[] output = new int[2]; 
        
        if (len==0) return 0;
        
        if (s.charAt(0) == 'M'){
        	thousands ++;
        	index ++;
        	while (index<len && s.charAt(index)=='M'){
        		thousands ++;
        		index ++;
        	}
        }
        
        output = this.translate(s, index, 'C', 'D', 'M');
        hundreds = output[0];
        index = output[1];
        
        output = this.translate(s, index, 'X', 'L', 'C');
        tens = output[0];
        index = output[1];
        
        output = this.translate(s, index, 'I', 'V', 'X');
        ones = output[0];
        
        sum = thousands*1000 + hundreds*100 + tens*10 + ones;
        return sum;
    }
	
	int[] translate (String s, int index, char num1, char num5, char num10){
		int[] output = new int[2];
		int n = 0;
		int len = s.length();
		
		if (index<len && s.charAt(index)==num1){
        	n ++;
        	index ++;
        	while (index<len && s.charAt(index)==num1){
        		n ++;
        		index ++;
        	}
        	
        	if (index<len && n==1){
        		if  (s.charAt(index)==num5){
        			n = 4;
        			index ++;
        		}
        		else if (s.charAt(index)==num10){
        			n = 9;
        			index ++;
        		}
        	} 
        }
        else if (index<len && s.charAt(index)==num5){
        	n = 5;
        	index ++;
        	while (index<len && s.charAt(index)==num1){
        		n ++;
        		index ++;
        	}
        }
		
		output[0] = n;
		output[1] = index;
		return output;
	}
}