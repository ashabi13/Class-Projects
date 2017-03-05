/**
 * file: driver_proj1.java
 * author: Mutiat Alagbala
 * course: CMPT 220
 * assignment: project 1
 * due date: Wendsday, September 9th, 2015
 * version: 1.0
 * 
 * This file contains the declaration of the driver_proj1 abstract data
 * type.
 */

import java.io.*;
import java.util.*;

/**
 * driver_proj1
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

public class driver_proj1{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the number of elements in the first array? ");
        //The first arrays length
        int ArrayLen1=scan.nextInt();
        System.out.println("Input the number of elements in the second array? ");
        //The second arrays length
        int ArrayLen2=scan.nextInt();
        double[] Vector1 = new double[ArrayLen1];
        double[] Vector2 = new double[ArrayLen2];
        System.out.println( Vector1.length + "  " + Vector2.length);
        double[] Result = new double[ArrayLen1+ArrayLen2-1];
       /* System.out.println("The first Vectors length is "+ Vector1.length);
        System.out.println("The second Vectors length is "+ Vector2.length);
        System.out.println("The result Vectors length is "+ Result.length);
        */
        //String input = scan.nextLine();
        //String[] tempArray = input.split(" ")
        System.out.println("Moving on...Enter the first vectors data.");
        for(int i=0; i<Vector1.length; i++){
            
            System.out.println("index: " + i);
            System.out.println("Enter a number");
            Vector1[i]=(scan.nextInt());
        }
        System.out.println("Moving on...Enter the second vectors data.");
        for(int i=0; i<Vector2.length; i++){
            
            System.out.println("index: " + i);
            System.out.println("Enter a number");
            Vector2[i]=(scan.nextInt());
        }
        System.out.println("convolution time...");
        convolution(Vector1,Vector2, Result);
        System.out.println("DONE!!!");
        //for(int i=0; i<Vector2.length; i++){
        //    Vector2[i]=scan.nextInt();
        //}
        /*input = scan.nextLine();
        tempArray = input.split(" ");
        for(int i=0; i<tempArray.length; i++){
            Vector2[i]=Integer.parseInt(tempArray[i].trim());
        }*/
        //Result = convolution(Vector1,Vector2, Result);
        


	}

    public static void convolution(double[] Vector1, double[] Vector2, 
            double[] Result){
        double[] v1 = Vector1;
        double[] v2 = Vector2;
        if(Vector1.length!=Vector2.length){
            v1 = maximumVec(Vector1,Vector2);//to fix the issue that arises when the 
            v2 = minimumVec(Vector1,Vector2);//1st vector is smaller than the 2nd
        }
        double[] r = Result;
        for(int index=0;index<r.length; index++){
            for (int shift=0; shift<v1.length; shift++) {
                    r[index]=0;
                    if(!(index<0||index>v1.length)&&(shift<0||shift>v2.length)){
                        System.out.println("index " + index + " is out of bounds.");
                        System.out.println("shift " + shift + " is not out of bounds.");
                        r[index]+=(0*v2[shift]); 
                    }
                    else if((index<0||index>v1.length)&&!(shift<0||shift>v2.length)){
                        System.out.println("index " + index + " is not out of bounds.");
                        System.out.println("shift " + shift + " is out of bounds.");
                        r[index]+=(v1[index-shift]*0); 
                    }
                    else if(((index<0||index>v1.length)&&(shift<0||shift>v2.length))){
                        System.out.println("index " + index + " is out of bounds.");
                        System.out.println("shift " + shift + " is out of bounds.");
                        r[index]+=(v1[index-shift]*v2[shift]);
                    }
                    else if(!((index<0||index>v1.length)&&(shift<0||shift>v2.length))){    
                        System.out.println("index " + index + " is not out of bounds.");
                        System.out.println("shift " + shift + " is not out of bounds.");
                        r[index]+=(0*0);
                    } 
            }
        }
        // Iteration 1.3 idx = 0, shift = 2:
        //cResult[0] = 0;    // initialize to zero
        //cResult[0] += vFirst[-2] * vSecond[2] == 0 * 1 = 0  // careful: out of bounds!
        // cResult[0] should be equal to 1
        System.out.println(Arrays.toString(v1) + "\n" + Arrays.toString(v2) + "\n" + Arrays.toString(r));

    }

    public static double[] maximumVec(double[] firstVector, double[] secondVector){
        int maxLength = Math.max(firstVector.length,secondVector.length);
        if(firstVector.length==maxLength) 
            return firstVector;
        else 
            return secondVector;
    }

    public static double[] minimumVec(double[] firstVector, double[] secondVector){
        int minLength = Math.min(firstVector.length,secondVector.length);
        if(firstVector.length==minLength) 
            return firstVector;
        else 
            return secondVector;
    }

}





