/*
 * Project Euler Problem 22
 *
 * Using names.txt, a 46K text file containing over five-thousand first names, begin by 
 * sorting it into alphabetical order. Then working out the alphabetical value for each name, 
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 
 * 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 
 * 938 x 53 = 49714.
 * 
 * What is the total of all the name scores in the file.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class NamesScore {
	
	public static void main(String[] args) throws Exception {
		TreeSet<String> sortedNames = createSetFromFile("data/names.txt");
		int count=1; //start index count of names at 1
		int total=0; //total of all name scores
		
		for(String name: sortedNames){
			total += count * calculateScore(name);
			count++;
		}
		
		System.out.println(total);
	}
	
	/**
	 * Given a filename, creates a list containing names from the file
	 * @param filename
	 * @return List<String>
	 * @throws Exception
	 */
	public static TreeSet<String> createSetFromFile(String filename) throws Exception{
	    BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        line = line.replace("\"", "");
        List<String> names = Arrays.asList(line.split(","));
        //returns TreeSet of names after removing quotes and splitting on commas
		return new TreeSet<String>(names);
	}
	
	/**
	 * Given a String name calculates its integer score 
	 * @param name
	 * @return score integer value
	 */
	public static int calculateScore(String name){
		int score = 0;
		for (int i = 0; i < name.length(); i++)
			//gets each character's ASCII value and subtracts 64 to get alphabet position
		    score += (int)(name.charAt(i)) - 64;
		return score;
	}
}
