/*
 * Project Euler Problem 14
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */


public class CollatzSequence {

	public static void main(String[] args) {
		//brute force solution
		double start = System.currentTimeMillis();
		System.out.println(collatzSeqCalc(1000000));
		System.out.println(System.currentTimeMillis() -start +"ms using brute force method \n");
		
		//caching solution (about 13x faster)
		start = System.currentTimeMillis();
		System.out.println(collatzSeqCacheCalc(1000000));
		System.out.println(System.currentTimeMillis() -start +"ms using caching method");
	}
	
	/**
	 * Finds which starting number under the given integer limit produces the longest Collatz Sequence
	 * (brute force method)
	 * @param limit integer for starting number
	 * @return the starting number that returns longest sequence
	 */
	public static long collatzSeqCalc(int limit){
		long sequence = 0;
		long maxSeqLength = 0;
		long startingNumber = 0;
		
		for(int i=2; i <= limit; i++){
			int tempLength = 0;
			sequence = i;
			
			//calculate sequence for each value of i
			while (sequence != 1) {
				if(sequence % 2 == 0) { //if even
					sequence /= 2;
				} else { //if odd
					sequence = sequence *3 + 1;
				}
				tempLength++;
			}
			
			//keep track of the longest sequence length and starting number
			if(maxSeqLength < tempLength){
				startingNumber = i;
				maxSeqLength = tempLength;
			}
		}
		
		return startingNumber;	
	}
	
	/**
	 * Finds which starting number under the given integer limit produces the longest Collatz Sequence
	 * Uses a cache to store sequence length for each number to limit redundant calculations
	 * Each time a number in the sequence is reached for which the length has already been calculated, 
	 * gets the length from the cache array and adds it to the calculated length
	 * @param limit integer for starting number
	 * @return the starting number that returns longest sequence
	 */
	public static long collatzSeqCacheCalc(int limit){
		long sequence = 0;
		long maxSeqLength = 0;
		long startingNumber = 0;
		int[] cache = new int[limit + 1];
		
		for(int i=2; i <= limit; i++){
			int tempLength = 0;
			sequence = i;
			
			//calculate sequence for each value of i
			while (sequence != 1 && sequence >= i) {
				if(sequence % 2 == 0) { //if even
					sequence /= 2;
				} else { //if odd
					sequence = sequence *3 + 1;
				}
				tempLength++;
			}
			cache[i] = tempLength + cache[(int)sequence]; //store in cache
			
			//keep track of the longest sequence length and starting number
			if(maxSeqLength < cache[i]){
				startingNumber = i;
				maxSeqLength = cache[i];
			}		
		}
		return startingNumber;
	}

	
}
