/**
 * file: driver_proj0.java
 * author: Mutiat Alagbala
 * course: CMPT 220
 * assignment: project 0
 * due date: Wendsday, September 16th, 2015
 * version: 1.0
 * 
 * This file contains the declaration of the driver_proj0 abstract data
 * type.
 */

import java.io.*;

/**
 * driver_proj0
 * 
 * This class reads a plain text file and prints it into command line.
 * 
 * Parameters: none
 * However, in order for a file to be read it must be input using command 
 * line shell. 
 * 
 * Return value: none
 * However, if the shell outputs to a file the input file should be echoed back.
 */

public class driver_proj0{
    public static void main(String[] args){
        //reader is the character that reads the next line of the input file.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //nextLine is a place holder for the files next line but is initialized to an 
        //empty string to satisfy the while loop.
        String nextLine = " ";
        //while the next line does not exist 
        while(nextLine != null){
            //try to read the next line.
            try {
                nextLine = reader.readLine();
                
            }catch(IOException e){
                //stack trace will be printed so the cause of the exception can be 
                //determined.
                e.printStackTrace();
            }
            if(nextLine != null) // && nextLine !='\n' && nextLine!='\r')
                System.out.println(nextLine);
        }
    }    
} 