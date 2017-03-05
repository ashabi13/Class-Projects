import java.io.*;
import java.util.*;
import java.lang.*;

public class countLetters{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string of letters, numbers, spaces and symbols:");
        String string = scan.nextLine();
        System.out.println("The number of letters in the string is "
            + countLetters(string));
    }

    public static int countLetters(String string){
        int count = 0;
        for(int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(Character.isLetter(c)) count++;
        }
        return count;
    }
}