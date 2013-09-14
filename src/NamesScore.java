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
import java.util.List;
import java.util.ArrayList;

public class NamesScore {
	
	public static void main(String[] args) throws Exception {
		List<String> list = createListFromFile();
		
	}
	
	public static List<String> createListFromFile() throws Exception{
		List<String> list = new ArrayList<String>();
		
	    BufferedReader br = new BufferedReader(new FileReader("data/names.txt"));
	    StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        System.out.println(line);
		return list;
	}
}
