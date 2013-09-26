/*
 * Project Euler Problem 7
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that 
 * the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 */

public class TenThousandFirstPrime {
	
	public static void main(String[] args) throws Exception {
		double start = System.currentTimeMillis();
		
		int primeCount =3;
		int num =3;
		while(primeCount < 10001){
			num++;
			if(isPrime(num)){
				primeCount++;
			}
		}
		
		System.out.println(System.currentTimeMillis() -start +"ms");
	}
	
	public static boolean isPrime(int n){
		boolean isPrime =false;
	
		return isPrime;
		
	}
}
