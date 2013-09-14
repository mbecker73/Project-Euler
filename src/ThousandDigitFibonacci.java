import java.math.BigInteger;

/*
 * Project Euler Problem 25
 *
 * The Fibonacci sequence is defined by the recurrence relation:
 * Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
 * 
 * The 12th term, F12, is the first term to contain three digits.
 * 
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 */

public class ThousandDigitFibonacci {
	public static void main(String[] args) throws Exception {

		BigInteger[] fibonacci = new BigInteger[8000]; //use arbitrarily long array length
		 
		//calculate the fibonacci sequence using BigInteger objects and store in array
		for(int i = 1; i < fibonacci.length; i++){
			if(i < 3)
				fibonacci[i] = BigInteger.valueOf(1);
			else
				fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
		}
		
		//find the first number in the array that is 1000 digits long
		int index=0;
		while(String.valueOf(fibonacci[index]).length()!=1000)
			index++;
		
		System.out.println(index);

	}
}
