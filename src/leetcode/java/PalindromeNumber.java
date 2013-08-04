package leetcode.java;

public class PalindromeNumber {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
			
		// first method
		System.out.println("First Method:");
		if (num == reverse (num)){
			System.out.println(num + " is a palindrome number.");
		}
		else{
			System.out.println(num + " is not a palindrome number.");
		}
		
		//second method
		System.out.println("\nSecond Method:");
		if (isPalindromeNumber(num)){
			System.out.println(num + " is a palindrome number.");
		}
		else{
			System.out.println(num + " is not a palindrome number.");
		}
		
	}

	static int reverse (int num){	
		assert (num >= 0):num + " < 0 !"; //for non-negative integers only
		int rev = 0;
		while (num !=0){
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		return rev;
	}
	
	static boolean isPalindromeNumber(int num){
		int last, first, i;
		if (num >= 0) {}
		else {
			return false;
		}
		
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
}
