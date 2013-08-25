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
    	//calculate summation of all numbers less than the limit and greater than 1
    	long sum =  ((limit)*(limit+1) / 2) -limit -1;	
    	    	
    	//create boolean array holding if number at index is prime or not
    	boolean[] primeArray = new boolean[(int) (limit)];
    	for (int i = 2; i < limit; i++) {
    		primeArray[i] = true; //init all as true
    	}
    	
    	//Sieve of Eratosthenes implementation
    	for (int i = 2; i*i < limit; i++) {
            if (primeArray[i]) { //if the number is marked as a possible prime
            	//mark every "i"th number as false (all multiples of i)
                for (int j = i; i*j < limit; j++) {
                	if(primeArray[i*j] ){ //to prevent duplicating subtraction from total
                		primeArray[i*j] = false;
                		sum -= i*j; //subtract value that is not prime from total sum
                	}
                }
            }
        }

    	return sum;
    }

}