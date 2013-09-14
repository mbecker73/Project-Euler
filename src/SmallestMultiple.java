/*
 * Project Euler Problem 5
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 
 * without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class SmallestMultiple {

	/**
	 * Given two numbers, finds the least common multiple between the two 
	 * @param a
	 * @param b
	 * @return the LCM of a and b
	 */
	public static long LCM(long a,long b) {
		long num1 = a;
		long num2 = b;
		
		while(a != b) {
			if(a < b)
				a += num1;
			else
				b += num2;
		}
		return a;
	}
	
	public static void main(String args[]) {
		
		long num = 1;
		//find LCM as you loop through numbers 1-20 
		for(int i=1; i <= 20; i++)
			num = LCM(num,i);
		System.out.println(num);
		
	}
}
