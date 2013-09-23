import java.math.BigInteger;

/*
 * Project Euler Problem 15
 * Starting in the top left corner of a 2x2 grid, and only being able to move to the right and 
 * down, there are exactly 6 routes to the bottom right corner
 * 
 * How many such routes are there through a 20x20 grid?
 */

public class LatticePaths {

	public static void main(String[] args) throws Exception {
		//To solve this problem, use combinations; n things taken k at a time without repetition 
		//40 choose 20= 40!/20!(40-20)! (40 moves in the 20x20 grid)
		
		System.out.println(combinationCalc(BigInteger.valueOf(40),BigInteger.valueOf(20)));
	}
	
	/**
	 * Method to calculate the combination of two numbers (BigIntegers) using the
	 * formula n!/k!(n-k)!
	 * @param n
	 * @param k
	 * @return n choose k 
	 */
	public static BigInteger combinationCalc(BigInteger n, BigInteger k){
		BigInteger denominator = (factorial(k).multiply(factorial(n.subtract(k))));
		return factorial(n).divide(denominator);
	}
	
	/**
	 * Recursive method to calculate the factorial of a BigInteger
	 * @param n
	 * @return
	 */
	public static BigInteger factorial(BigInteger n){
		if(n.intValue() <=1)
			return BigInteger.valueOf(1);
		else
			return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
	}
}
