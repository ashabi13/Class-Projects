import java.util.*;
import java.io.*;

public class printResults{
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        System.out.println("Enter a string: ");
        String inputStr = reader.readLine();
        System.out.println("Enter a char: ");
        char inputChar = reader.nextChar();
        count(inputStr, inputChar);
    }

    public static int count(String str, char a){
        System.out.println("count!!!");
        return 8;
    }
}