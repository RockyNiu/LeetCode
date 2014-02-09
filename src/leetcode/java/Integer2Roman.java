package leetcode.java;

import java.util.Random;

/*Given an integer, convert it to a roman numeral.
 * I 	1
V 	5
X 	10
L 	50
C 	100
D 	500
M 	1,000

the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern
 * 

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Integer2Roman {
	
	public static void main(String[] args){
		Random generator = new Random();
		int num = generator.nextInt(3999);
		Solution012 solution = new Solution012();
		System.out.println(num+":\t"+solution.intToRoman(num));
	}
}

class Solution012{
	public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        int thousands, hundreds, tens, ones;
        
        thousands = num/1000;
        for (int i = 0; i < thousands; i++) {
			sb.append('M');
		}
        
        hundreds = num/100 - thousands*10;
        sb.append(this.translate(hundreds,'C','D','M'));
        
        tens = num/10 - thousands*100 - hundreds*10;
        sb.append(this.translate(tens,'X','L','C'));
        
        ones = num%10;
        sb.append(this.translate(ones, 'I', 'V', 'X'));        
        
        return sb.toString();
    }
	
	StringBuffer translate (int n, char num1, char num5, char num10){
		StringBuffer sb = new StringBuffer();
		
		if (n > 0){
			if (n < 4){
				for (int i = 0; i < n; i++) {
					sb.append(num1);
				}
			}
			else if (n==4){
				sb.append(num1);
				sb.append(num5);
			}
			else if (n==9){
				sb.append(num1);
				sb.append(num10);
			}
			else{
				sb.append(num5);
				for (int i = 0; i < n-5; i++) {
					sb.append(num1);
				}
			}
        }
		
		return sb;
	}
}