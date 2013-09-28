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

		//BigInteger summation method
		double start = System.currentTimeMillis();
		BigInteger bigIntSum = bigIntSumCalc("data/large-sum.txt");
		String summation = bigIntSum.toString();
		System.out.println(summation.substring(0,10)); //only need first 10 digits
		System.out.println(System.currentTimeMillis() -start +"ms to complete BigInteger method");
		
		System.out.println();
		//String summation method
		start = System.currentTimeMillis();
		String stringSum = bigSumCalc("data/large-sum.txt");
		System.out.println(stringSum.substring(0,10)); //only need first 10 digits
		System.out.println(System.currentTimeMillis() -start +"ms to complete String summation method");

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
		
		//loop through the file, convert line to BigInteger, and sum them all
		while (( line = br.readLine()) != null) {
			BigInteger number = new BigInteger(line);
			sum = sum.add(number);
		}
		return sum;
	}
	
	/**
	 * Given a String filename of a file containing rows of large integers, finds sum of those numbers
	 * @param filename
	 * @return String sum of the integers in the file
	 * @throws IOException
	 */
	public static String bigSumCalc(String filename) throws IOException{

		String[] array = createStringArray(filename);		
		int value = 0;
		int tempSum = 0;
		int carryOver = 0;
		String sum = "";

		//loops through all the values in the String array and sums them 
		for(int y=array[0].length()-1; y >= 0; y--){
			tempSum += carryOver;
			for(int x = 0; x < array.length; x++){
				value = Integer.parseInt(String.valueOf(array[x].charAt(y)));
				tempSum += value;
			}
			String digit = String.valueOf(tempSum);
			sum = digit.substring(digit.length() - 1) + sum;
			carryOver = Integer.parseInt(digit.substring(0,digit.length() - 1));
			tempSum = 0;
			value = 0;
			
		}
		//add on the carry over integers after last column
		sum = carryOver + sum;
		return sum;
	}
	
	/**
	 * Given a file, converts the rows of numbers to a String array
	 * @param filename
	 * @return String array of numbers from file
	 * @throws IOException
	 */
	public static String[] createStringArray(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line="";
		String[] array = new String[100];
		int i=0;
		while (( line = br.readLine()) != null) {
			array[i] = line;
			i++;
		}
		return array;
	}

}
