import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

/*
 * Project Euler Problem 67
 * 
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, 
 * the maximum total from top to bottom is 23.
 * 
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * Find the maximum total from top to bottom in triangle.txt, a 15K text file containing a 
 * triangle with one-hundred rows.
 * 
 */

public class MaxPathSum2 {
	
	public static void main(String[] args) throws Exception {
		double start = System.currentTimeMillis();
		
		int[][] triangle = createIntegerMatrix("data/triangle.txt");

		System.out.println(System.currentTimeMillis() -start +"ms");
		
	}
	
	/**
	 * Create integer matrix from text file of integers
	 * @param filename
	 * @return int[][] triangle
	 * @throws IOException
	 */
	public static int[][] createIntegerMatrix(String filename) throws IOException{
		
		//get number of rows in text file (given in problem but implemented for possible filename change)
		LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(filename)));
		lnr.skip(Long.MAX_VALUE);
		int size = lnr.getLineNumber();
		
		int[][] triangle = new int[size][size];
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		String line = "";
		int i =0, j = 0;
		while (( line = br.readLine()) != null) {
			String[] numStringArray = line.split(" ");
			for(String num : numStringArray){
				triangle[i][j++] = Integer.parseInt(num);
			}
			i++;
			j=0;
		}
        
		return triangle;
	}
	
	/*
	 * Method to find the maximum path sum of a given integer matrix.  Using dynamic programming, 
	 * the algorithm works its way up the triangle, creating a smaller and smaller triangle each 
	 * iteration by finding the maximum sum possible between the bottom two levels and contiuing this
	 * until only the top-most integer value is left, which will be the max path summation 
	 */
	public static int maxPathSum(int[][] triangle) {
		for (int i = triangle.length - 2; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
			}
		}
		return triangle[0][0];
	}

	
}
