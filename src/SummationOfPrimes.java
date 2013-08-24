/*
 * Project Euler Problem 10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */

public class SummationOfPrimes {

    public static void main(String[] args) {
    	System.out.println(sumOfPrimes(2000000)); //answer should be 142913828922
    }
    
    public static long sumOfPrimes(long limit){
    	long sum=0;

    	//create boolean array holding if number at index is prime or not
    	boolean[] primeArray = new boolean[(int) (limit + 1)];
    	for (int i = 2; i <= limit; i++) {
    		primeArray[i] = true; //init all as true
    	}
    	//Sieve of Eratosthenes implementation
    	for (int i = 2; i*i <= limit; i++) {
            if (primeArray[i]) { //if the number is marked as a possible prime
            	//mark every "i"th number as false (all multiples of i)
                for (int j = i; i*j <= limit; j++) {
                    primeArray[i*j] = false;
                }
            }
        }

    	//loop through all numbers 2 through 2 million
    	for(int x=2; x < limit; x++){
    		if(primeArray[x]) //if that number is prime then increment sum 
    			sum += x;
    	}

    	return sum;
    }

}