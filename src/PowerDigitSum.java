import java.math.BigInteger;

/*
 * Project Euler Problem 16
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 * 
 * Solution is pretty straightforward when using the BigInteger Java class
 */

public class PowerDigitSum {
	public static void main(String[] args) {
		int result = 0;
		
		//compute 2^1000
		BigInteger number = BigInteger.valueOf(2L);
		number = number.pow(1000);

		//loop through the number and sum digits
		while (number.compareTo(BigInteger.valueOf(0L)) > 0) {
		    result += (number.mod(BigInteger.valueOf(10L)) ).intValue();
		    number = number.divide(BigInteger.valueOf(10L));
		}
		System.out.println(result);
	}
}
