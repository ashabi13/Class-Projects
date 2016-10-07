import java.util.*;
import java.io.*;

public class countChars{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string:");
        String userString = scan.nextLine();
        System.out.print("Enter a character:");
        char userChar = scan.next().charAt(0);
        int charCount = count(userString,userChar);
        System.out.printf("%c occurs %d times in the string\n", 
            userChar, charCount);
    }
    public static int count(String str, char a){
        int count = 0;
        char stringChar = '.';
        for(int i = 0; i<str.length()-1; i++){
            stringChar = str.charAt(i);
            if(stringChar == a){
                count++;
            }
        }
        return count;
    }
}