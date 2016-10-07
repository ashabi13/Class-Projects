import java.util.*;
import java.lang.*;
import java.io.*;

public class WiFi{
    private static int[] myArray;

    public static void main(String[] args) {
        File f;
        Scanner input = new Scanner(System.in);
        try{
            f = new File("array1.txt");
            input = new Scanner(f);
        }
        catch(FileNotFoundException ex){
            System.out.println("The file was not found.");
        }
        myArray = new int[input.nextInt()];
        for(int i = 0; i<myArray.length;i++){
            myArray[i] = input.nextInt();
        }
        for(int i = 0; i<myArray.length;i++){
            System.out.println(myArray[i]);
        }
    }

    WiFi(){}

    int getValue(int index){
        return 0;
    }

}