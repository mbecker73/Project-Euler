/*
 * Project Euler Problem 17
 *  If the numbers 1 to 5 are written out in words: one, two, three, four, five, then 
 *  there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *  
 *  If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
 *  how many letters would be used?
 */

import java.util.HashMap;
import java.util.Map;

public class NumberLetterCounts {
	/*
	 * Populates the HashMap lookup map where the key is an integer and value is the string/word for that number
	 * Included 0-19 by hand, after that can use number patterns to shorten length of map
	 */
	public static Map<Integer, String> createMapLookup(){
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "zero");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");
		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(15, "fifteen");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "nineteen");
		map.put(20, "twenty");
		map.put(30, "thirty");
		map.put(40, "forty");
		map.put(50, "fifty");
		map.put(60, "sixty");
		map.put(70, "seventy");
		map.put(80, "eighty");
		map.put(90, "ninety");
		map.put(100, "hundred");
		map.put(1000, "thousand");

		return map;
	}
	
	/*
	 * Given an integer and HashMap, uses the appropriate function and map lookup to 
	 * return it's written out String representation; only handles numbers less than 10000
	 */
	public static String convertNumberToWord(int number, Map<Integer, String> map){
		if(number >=0 && number < 20){
			return map.get(number);
		}
		else if(number >= 20 && number< 100){
			return convertTens(number, map);
		}
		else if(number >= 100 && number < 1000){
			return convertHundreds(number, map);
		}
		else if(number >=1000 && number < 10000){
			return convertThousands(number, map);
		}
		else{ //if the number is not within the valid range
			return null;
		}
	}
	
	/*
	 * Given an integer between 20 <= n < 100, converts it to String representation
	 */
	public static String convertTens(int number, Map<Integer, String> map){
		//break down the number into it's respective digits
		int tens = (number/10)*10;
	    int ones = number%10;
	    
	    if(tens == 0) //e.g. 04
			return map.get(ones);
	    else if(ones > 0) //e.g. 73
	    	return map.get(tens) + map.get(ones);
	    else //e.g. 40
	    	return map.get(tens);
	}
	
	/*
	 * Given an integer between 100 <= n < 1000, converts it to String representation
	 */
	public static String convertHundreds(int number, Map<Integer, String> map){
		if(number/100 == 0) //e.g. 034
			return convertTens(number%100,map);
		else{
			if(number%100 == 0) //if tens and ones digit are both zero
				return map.get(number/100) + map.get(100);
			else if(number%100 <20) //if a number is less than 20, use inserted map value
				return map.get(number/100) + map.get(100) + "and" + map.get(number%100);
			else //if all digits are not zero
				return map.get(number/100) + map.get(100) + "and" + convertTens(number%100,map);
		}
	}
	
	/*
	 * Given an integer between 1000 <= n < 10000, converts it to String representation
	 */
	public static String convertThousands(int number, Map<Integer, String> map){
		if(number%1000==0)
			return map.get(number/1000) + map.get(1000);
		else
			return map.get(number/1000) + map.get(1000) + convertHundreds(number%1000, map);
		
	}
	
	public static void main(String[] args) {
		Map<Integer, String> map = createMapLookup();
		int sum = 0;
		String temp = "";
		//loop to convert numbers to words, then finds sum of the strings lengths
		for(int i=1; i <= 1000; i++ ){
			temp = convertNumberToWord(i, map);
			sum += temp.length();
		}
		System.out.println(sum);
	}
	
}
