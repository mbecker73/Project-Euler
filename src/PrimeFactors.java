/*
 * Project Euler Problem 3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

import java.util.Stack;

public class PrimeFactors {
    public static void main(String[] args) {
    	Stack<Long> f = findPrimeFactors((long) 600851475143.0);
    	//only have to peek at top of stack as they will be pushed onto stack in order
    	System.out.println(f.peek()); 
    }
    public static Stack<Long> findPrimeFactors(long n){
    	//need to use type long as the number asked for is too large for int primitive type
        Stack<Long> factors = new Stack<Long>();
        for(int i=2; i <= n; i++){
        	while(n%i ==0){
        		factors.push((long)i);
        		n = n /i;
        	}
        }
        return factors;
    }
}
