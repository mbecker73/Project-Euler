/*
 * Project Euler Problem 8
 * Find the greatest product of five consecutive digits in the 1000-digit number.
 */

public class LargestProduct {
	public static void main(String[] args) {
		
		String largeNum = "73167176531330624919225119674426574742355349194934" +
				"96983520312774506326239578318016984801869478851843" +
				"85861560789112949495459501737958331952853208805511" +
				"12540698747158523863050715693290963295227443043557" +
				"66896648950445244523161731856403098711121722383113" +
				"62229893423380308135336276614282806444486645238749" +
				"30358907296290491560440772390713810515859307960866" +
				"70172427121883998797908792274921901699720888093776" +
				"65727333001053367881220235421809751254540594752243" +
				"52584907711670556013604839586446706324415722155397" +
				"53697817977846174064955149290862569321978468622482" +
				"83972241375657056057490261407972968652414535100474" +
				"82166370484403199890008895243450658541227588666881" +
				"16427171479924442928230863465674813919123162824586" +
				"17866458359124566529476545682848912883142607690042" +
				"24219022671055626321111109370544217506941658960408" +
				"07198403850962455444362981230987879927244284909188" +
				"84580156166097919133875499200524063689912560717606" +
				"05886116467109405077541002256983155200055935729725" +
				"71636269561882670428252483600823257530420752963450";
		System.out.println(findProduct(largeNum));
    }
	
	//given a string of numbers, finds the greatest product of 5 consecutive digits 
	public static int findProduct(String largeNum){
		int[] numArray = convertToIntArray(largeNum); //converts the string into an int array
		int maxProduct = 0;
		int prod = 0;
		//loops through the array once, testing five consecutive digits as it loops
		for(int x=0; x < largeNum.length()-4; x++){
			prod = numArray[x]*numArray[x+1]*numArray[x+2]*numArray[x+3]*numArray[x+4];
			if(prod > maxProduct)
				maxProduct = prod;
		}
		/*could test product of last 4 digits here but from 
		  looking at number it won't be the largest product*/
		return maxProduct;
	}
	
	//method to convert a string of numbers into an array of those numbers
	public static int[] convertToIntArray(String s){
		int[] array = new int[s.length()];
		for(int i=0; i < s.length(); i++)
			array[i] = Integer.parseInt(s.substring(i, i+1));
		return array;
	}
}
