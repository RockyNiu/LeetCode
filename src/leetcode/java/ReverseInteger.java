package leetcode.java;
/*Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought 
through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
then the reverse of 1000000003 overflows. How should you handle such cases?

Throw an exception? Good, but what if throwing an exception is not an option? You would then have 
to re-design the function (ie, add an extra parameter).
*/
public class ReverseInteger {

	public static void main(String[] args) {
		Solution007 solution = new Solution007();
		int x = 10;
		System.out.println(solution.reverse(x));
	}

}

class Solution007{
	public int reverse(int x){
		int flag = 1;
		if (x<0){
			flag = -1;
			x = -x;
		}
		
		long rev = 0;
		while (x!=0){
//			assert (rev <= Integer.MAX_VALUE/10):"Overflow!";
			rev = rev*10 + x%10;
			x = x/10;
		}
		rev = rev*flag;
		assert ((rev <= Integer.MAX_VALUE)||(rev >= Integer.MIN_VALUE)):"Overflow!";
		return (int) rev;
	}
}