/*
 * Project Euler Problem 6
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural 
 * numbers and the square of the sum is 3025 − 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred 
 * natural numbers and the square of the sum.
 */

public class SumSquareDiff {
    public static void main(String[] args) {
       	System.out.println(squareOfSum(100) - sumOfSquares(100));
    }
    //calculates the sum of the squares of the first n natural numbers
    public static int sumOfSquares(int n){
    	int total =0;
    	for(int i=0; i <= n; i++){
    		total += Math.pow(i, 2);
    	}
		return total;
    }
    
    //calculates the square of the sum of the first n natural numbers
    public static int squareOfSum(int n){
    	int total =  (n)*(n+1) / 2; //summation formula
		return (int) Math.pow(total, 2);
    }
}
