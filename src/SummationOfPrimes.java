/*
 * Project Euler Problem 10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */

public class SummationOfPrimes {
    public static void main(String[] args) {
	System.out.println(sumOfPrimes(2000000));
    }
    public static int sumOfPrimes(int limit){
	int sum=0;
	int n=1;

	while(n < limit){
		n++;
		if(isPrime(n))
			sum += n;
	}
	return sum;
    }

    //boolean function to check if a number is prime
    public static boolean isPrime(int n) {
        for(int i =2; i < n; i++) {
            if(n % i == 0) //has a divisor besides 1 and itself
                return false;
        }
        return true;
    }
}
