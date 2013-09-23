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
		BigInteger n = factorial(BigInteger.valueOf(100));
		String s = n.toString();
		char[] array = s.toCharArray();
		int sum = 0;
		for(char c : array){
			sum += Integer.parseInt(c +"");
		}
		System.out.println(sum);
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
