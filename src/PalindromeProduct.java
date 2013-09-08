/*
 * Project Euler Problem 4
 *  A palindromic number reads the same both ways. The largest palindrome made from the
 *  product of two 2-digit numbers is 9009 = 91 x 99.
 *  
 *  Find the largest palindrome made from the product of two 3-digit numbers
 */

public class PalindromeProduct {
	
	public static void main(String[] args) {
		int largestProduct = 0;
		//loops through all three digit numbers, checking if their product is a palindrome
		for(int i = 100; i < 1000; i++){
			for(int j = 100; j < 1000; j++){
				if(isPalindrome(i*j)){
					largestProduct = Math.max((i*j), largestProduct);
				}
			}
		}
		System.out.println(largestProduct);
	}
	
	//method that returns boolean if an integer is a boolean or not
	public static boolean isPalindrome(int number){
		int original =number; //store copy of original number
		int reverse =0;
		
        while (number != 0) {
			int temp = number %10; //gets last digit from number
			number = number/10; //removes last digit from number
			reverse = reverse*10+temp; //builds reverse of number
		}
        //return true if the reverse of the number is same as original 
		return reverse == original;
	}
}
