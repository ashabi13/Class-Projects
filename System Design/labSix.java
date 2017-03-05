/**
* file: labSix.java
* author: Pablo Rivas and Class CMPT 220L-111 
* course: CMPT 220
* assignment: Lab 6
* 
* 
* 
* 
* 
*/
import java.io.*;

public class labSix{
	public static void main(String[] args
		){
		double years = 0.0;
		double months = 0.0;
		double weeks = 0.0;
		double days = 0.0;
		double hours = 0.0;
		double minutes = 0.0;
		double seconds = 0.0;
		if(printResults(years, months, weeks, days, hours, minutes, seconds)==true){
			System.out.println("Dude, with all due respect, just give up! \n");
		}
	}

	/**
	* printResult
	* 
	* This method prints the results for labe for and five in a single separated
	* function.
	* 
	* Parameters:
	*    years: The years it thaks to hack.
	*    weeks: The weeks it thaks to hack.
	*    days: The days it thaks to hack.
	*    hours: The hours it thaks to hack.
	*	 ...
	* Return value:
	*	boolean. The function returns a boolean if the number of years is greater
	* 	than 1.0.
	*/
	public static boolean printResults(double years, double months, double weeks, double days, double hours, double minutes, double seconds){
		boolean YearsGreaterThan1 = false;
		System.out.print("It will take you ");
		System.out.printf("%.0f years", years);
		System.out.printf("%.0f months", months);
		System.out.printf("%.0f weeks", weeks);
		System.out.printf("%.0f days", days);
		System.out.printf("%.0f hours", hours);
		System.out.printf("%.0f minutes", minutes);
		System.out.printf("%.0f seconds", seconds);
		System.out.print(" to Hack");
		if (years > 1.0) 
			YearsGreaterThan1 = true;
		return YearsGreaterThan1;

		
	}
}