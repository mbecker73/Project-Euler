/*
 * Project Euler Problem 9
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * 
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

public class SpecialPythagoreanTriplet {
	
	//a^2 + b^2 = c^2
	//a + b + c = 1000
	//Algebra to combine these two equations -> a = (500000 - 1000 * b) / (1000 - b)
	
	public static void main(String args[]) {
		double start = System.currentTimeMillis();

		int limit = 1000;
		
		for(int i=0; i <= 500; i++){
			int b = i;
			int a = (500000 - 1000 * b) / (1000 - b);
			int c = limit - a - b;
			//find values of a, b, and c that meet requirements 
			if( (a*a + b*b == c*c) && a < b && b < c){
				System.out.println("a:" + a + ", b:"+ b +" c:"+ c);
				System.out.println(a*b*c);
				break;
			}
		}
		
		System.out.println(System.currentTimeMillis() -start +"ms");
		
	}
}
