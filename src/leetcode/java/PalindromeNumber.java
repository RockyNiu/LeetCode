package leetcode.java;
/*Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/
public class PalindromeNumber {

	public static void main(String[] args) {
		int num = -2147447412;
		Solution009 solution = new Solution009();
		System.out.println(solution.isPalindrome(num));
	}
}

class Solution009{
	boolean isPalindrome(int x){
		// first method
		if (x < 0) return false;
		long rev = reverse(x);
		if (rev==(long)x) 
			return true;
		else 
			return false;
		
		/*
		// second method
		int last, first, i;
		if (num >= 0) {
			while (num !=0){
				last = num % 10;
				first = num;
				i = 1;
				while (first > 9){
					first = first / 10;
					i = i*10 ;
				}
				if (last != first){
					return false;
				}
				num = (num - first*i)/10;
			}
			return true;
		}
		else {
			return false;
		}
		*/
	}	
	
	// reverse the integer
	long reverse (int num){	
//		assert (num >= 0):num + " < 0 !"; //for non-negative integers only
		long rev = 0;
		while (num !=0){
			rev = rev * 10 + num % 10;
			num = num / 10;		
			System.out.println(rev);
		}
		return rev;
	}
}
