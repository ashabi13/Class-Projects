/**
 * file: anInputTest.java
 * author: Mutiat Alagbala
 * course: CMPT 220
 * assignment: project 0
 * due date: Wendsday, September 9th, 2015
 * version: 1.0
 * 
 * This file contains the declaration of the anInputTest abstract data
 * type.
 */

import java.io.*;

/**
 * anInputTest
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

public class anInputTest{
    public static void main(String[] args){
        //f is the character that reads the next line of the input file.
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //x is a place holder for the files next line but is initialized to an empty string to saticfy the while loop.
        String x = " ";
        while(x != null){
            try {
                x = f.readLine();
                
            }
            catch(IOException e){
                //stack trace will be printed so the cause of the exception can be determined.
                e.printStackTrace();
            }
            if(x != null && x !='\n' && x!='\r')
                System.out.println(x);
        }
    }    
} 