/*
 * Project Euler Problem 20
 * n! means n x (n - 1) x ... x 3 x 2 x 1
 * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 */

import java.math.BigInteger;

public class FactorialDigitSum {

	public static void main(String[] args) throws Exception {
		System.out.println(factorialDigitSum(BigInteger.valueOf(100)));
	}
	
	/**
	 * Method to convert BigInteger value to a String, loop through all characters, adding 
	 * them up as integers
	 * @param BigInteger n
	 * @return factorial digit sum integer
	 */
	public static int factorialDigitSum(BigInteger n){
		BigInteger factorial = factorial(n);
		//convert BigInteger to string
		char[] factorialArray = factorial.toString().toCharArray();
		int sum = 0;
		for(char c : factorialArray){
			sum += Integer.parseInt(String.valueOf(c));
		}
		return sum;
	}
	/**
	 * Recursive method to calculate the factorial of a BigInteger
	 * @param n
	 * @return factorial of n
	 */
	public static BigInteger factorial(BigInteger n){
		if(n.intValue() <=1)
			return BigInteger.valueOf(1);
		else
			return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
	}
}
