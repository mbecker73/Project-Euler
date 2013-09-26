/*
 * Project Euler Problem 7
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that 
 * the 6th prime is 13.
 * 
 * What is the 10,001st prime number?
 */

public class TenThousandFirstPrime {
	
	public static void main(String[] args) throws Exception {
		double start = System.currentTimeMillis();
		
		int primeCount =1;
		int testNumber =1;
		
		while(primeCount < 10001){
			testNumber += 2; //only need to try odd numbers
			if(isPrime(testNumber)) {
				primeCount++;
			}
		}
		
		System.out.println(testNumber);
		
		System.out.println(System.currentTimeMillis() -start +"ms");
	}
	
	/*
	 * Method to return boolean indicating if an integer is a prime number or not
	 */
	public static boolean isPrime(int n){

		//all even numbers and numbers less than 2 are not prime
		if(n % 2 == 0 || n < 2){
			return false;
		}
		for (int i=3; i*i<=n; i = i + 2) {
			//check if number i divides evenly into n
			if (n % i == 0) {
				return false;
			}
		}
		
		//otherwise it is a prime number
		return true;
		
	}
}
