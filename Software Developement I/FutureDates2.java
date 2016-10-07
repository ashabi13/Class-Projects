import java.io.*;
import java.util.*;

public class FutureDates2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter todays day:");
        int today = scan.nextInt();
        String todayText = "";
        String nextDay = "";
        System.out.println("Enter the number of days elapsed since today:");
        int daysLater = scan.nextInt();
        // if(today<0||today>6) {
        // 	System.out.println("Today is an invalid starting day. Today's day must be 0-6.");
        // 	today = scan.nextInt();
        // }    
        int newDay = today;
          
        switch(today){
		       	case 0:todayText="Sunday";
		       		newDay=today+daysLater;
	        		break;
	        	case 1:todayText="Monday";
	        		newDay=(today+daysLater)%7;
	        		break;
	        	case 2:todayText="Tuesday";
	        		newDay=(today+daysLater)%7;
	        		break;
	        	case 3:todayText="Wednesday";
	        		newDay=(today+daysLater)%7;
	        		break;
	        	case 4:todayText="Thursday";
	        		newDay=(today+daysLater)%7;
	        		break;
	        	case 5:todayText="Friday";
	        		newDay=(today+daysLater)%7;
	        		break;
	        	case 6:todayText="Saturday";
	        		newDay=(today+daysLater)%7;
	        		break;
	        	default:
        			todayText = "an invalid starting day. Today's day must be 0-6.";
        }
        switch(newDay){
	        	case 0:nextDay="Sunday";
	        	break;
	        	case 1:nextDay="Monday";
	        	break;
	        	case 2:nextDay="Tuesday";
	        	break;
	        	case 3:nextDay="Wednesday";
	        	break;
	        	case 4:nextDay="Thursday";
	        	break;
	        	case 5:nextDay="Friday";
	        	break;
	        	case 6:nextDay="Saturday";
	        	break;
	        	default: System.out.println("something went wrong");
        }
        System.out.println("Today is "+todayText + " and the future day is " + nextDay);
    }    
} 