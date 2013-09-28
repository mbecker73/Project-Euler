import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/*
 * Project Euler Problem 13
 * 
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * (Found in data/large-sum.txt)
 * 
 */

public class LargeSum {
	public static void main(String[] args) throws Exception {
		double start = System.currentTimeMillis();

		BigInteger sum = bigIntSumCalc("data/large-sum.txt");
		
		String summation = sum.toString();
		System.out.println(summation.substring(0,10)); //only need first 10 digits
		System.out.println(System.currentTimeMillis() -start +"ms");

	}
	
	/**
	 * Given a String filename of a file containing rows of large integers, finds sum of those numbers
	 * @param filename
	 * @return BigInteger sum of the integers in filename
	 * @throws IOException
	 */
	public static BigInteger bigIntSumCalc(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line="";
		BigInteger sum = BigInteger.valueOf(0L);
		int i=0;
		
		//loop through the file, convert line to BigInteger, and sum them all
		while (( line = br.readLine()) != null) {
			BigInteger number = new BigInteger(line);
			sum = sum.add(number);
			i++;
		}
		return sum;
	}
	
	public static int bigSumCalc(String filename){
		
		return 0;
	}

}
