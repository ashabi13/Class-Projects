import java.io.*;
import java.util.*;

public class FutureDates{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("what is todays day # (0 for Sunday, 1 for Monday etc. 6 Saturday)");
        int today = scan.nextInt();
        if(today<0) {
        	System.out.println("Do NOT try to input negative numbers! Please.");
        	today = scan.nextInt();
        }if(today>6) {
        	System.out.println("Do NOT use nubers greater than 6! Please.");
        	today = scan.nextInt();
        }
        System.out.println("what is the day # of the days from today. ");
        int daysLater = scan.nextInt();
        if(daysLater<0) {
        	System.out.println("Do NOT try to input negative numbers! Please.");
        	daysLater = scan.nextInt();
        }if(daysLater>6) {
        	System.out.println("Do NOT use nubers greater than 6! Please.");
        	daysLater = scan.nextInt();
        }

       
        int newDay = today;
        
        if(today<daysLater)
			newDay=today+daysLater;
    	else{   
    		switch(today){
	        	case 1: 
	        	case 2:
	        	case 3:
	        	case 4:
	        	case 5:
	        	case 6:newDay=today+daysLater%7;
        	}
        }
        switch(newDay){
	        	case 0:System.out.println("Sunday");
	        	break;
	        	case 1: System.out.println("Monday");
	        	break;
	        	case 2:System.out.println("Tuesday");
	        	break;
	        	case 3:System.out.println("Wednesday");
	        	break;
	        	case 4:System.out.println("Thursday");
	        	break;
	        	case 5:System.out.println("Friday");
	        	break;
	        	case 6:System.out.println("Saturday");
	        	break;
	        	default: System.out.println("something went wrong");
        	}
        System.out.println("day #" + newDay);
    }    
} 