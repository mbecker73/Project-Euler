/*
 * Project Euler Problem 19
 * You are given the following information, but you may prefer to do some research for yourself.
 * 
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

import java.util.Calendar;

public class CountingSundays {
	
	public static void main(String[] args) {
		
		//Java Calendar method
		double start = System.currentTimeMillis();
		System.out.println(countSundaysWithCal(1901, 2000));
		System.out.println(System.currentTimeMillis() -start +"ms using Java Calendar method \n");
		
		//Mathematical method
		start = System.currentTimeMillis();		
		System.out.println(countSundaysWithMath(1901, 2000));
		System.out.println(System.currentTimeMillis() -start +"ms using mathematical method \n");
	}

	/**
	 * Given a range of years, finds the number of Sundays that fall on the first of each month. 
	 * Makes use of Java Calendar setters and getters
	 * @param startYear (integer)
	 * @param endYear (integer)
	 * @return integer number of Sundays that fall on 1st of month
	 */
	public static int countSundaysWithCal(int startYear, int endYear){
		int sundayCount = 0;
		for (int y = startYear; y <= endYear; y++) {
		    for (int m = 1; m <= 12; m++) {
		        Calendar cal = Calendar.getInstance();
		        cal.set(Calendar.YEAR, y);
		        cal.set(Calendar.MONTH, m);
		        cal.set(Calendar.DAY_OF_MONTH, 1);
		        if (cal.get(Calendar.DAY_OF_WEEK) == cal.SUNDAY){
		        	sundayCount++;
		        }
		    }
		}
		return sundayCount;
	}
	
	/**
	 * Given a range of years, finds the number of Sundays that fall on the first of each month.
	 * Method uses mathematical calculations to determine when the first of the month is a Sunday.
	 * @param startYear (integer)
	 * @param endYear (integer)
	 * @return integer number of Sundays that fall on 1st of month
	 */
	public static int countSundaysWithMath(int startYear, int endYear){
		int sundayCount = 0;
		int daysInMonth = 0;
		int daysPassed = 0;
		
		for (int y = startYear; y <= endYear; y++) {
	        for (int m = 1; m <= 12; m++) {
	        	//if month is April, June, Sept, or Nov
	            if (m == 4 || m == 6 || m == 9 || m == 11) {
	            	daysInMonth = 30;
	            } else if (m == 2) { //if month is Feb
	            	//check if leap year	            	
	                if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
	                	daysInMonth = 29;
	                } else {
	                	daysInMonth = 28;
	                }
	            } else { //if month is Jan, March, May, July, Aug, Oct, Dec
	            	daysInMonth = 31;
	            }
	            //increment count if first of the month is a Sunday
	            if (daysPassed % 7 == 0) {
	            	sundayCount++;
	            }
	            //increment to the next month
	            daysPassed += daysInMonth;
	        }
	    }
		
		return sundayCount;
	}
}
