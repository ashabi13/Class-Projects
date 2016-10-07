import java.io.*;
import java.util.*;
import java.lang.*;

public class checkPassword{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scan.nextLine();
        checkPassword(password);
    }

    public static void checkPassword(String password){
        boolean valid = true;
        //char[] passChars = password.
        if(password.length()<8) 
            valid=false;
        else{
            char cChar = ' '; //defined here for efficiancy
            int digitCount = 0; //defined here for efficiancy
            //for the length of the password
            for ( int i=0; i<password.length()-1; i++){
                cChar = password.charAt(i);//get each char
                //charVal = (int)cChar;//and its integer value
                //If the character is a digit or a letter
                if(!Character.isLetterOrDigit(cChar))
                    valid = false;
                //If the character is a digit
                else if(Character.isDigit(cChar)){
                    digitCount++;
                }
            }
            //if there is less than 2 digits in password
            if(digitCount<2)
                valid = false;
            
        }
        
        //Print whether the password is valid or not.
        if(valid) System.out.println("Valid Password");
        else System.out.println("Invalid Password");
    }
}