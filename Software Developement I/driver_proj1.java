/**
 * file: driver_proj1.java
 * author: Mutiat Alagbala
 * course: CMPT 220
 * assignment: project 1
 * due date: Wendsday, October 14th, 2015
 * version: 1.6
 * 
 * This file contains the declaration of the driver_proj1 abstract data
 * type.
 */

import java.io.*;
import java.util.*;

/**
 * driver_proj1
 * 
 * This class reads a file containing the sizes of and data for two vectors.
 * it then outputs the convolution 
 * 
 * Parameters: none
 * However, in order for a file to be read it must be input into the system  
 * using command line shell. 
 * 
 * Return value: none
 * However, if the shell outputs to a file that contains the convolved data.
 */
public class driver_proj1{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);//Set up the Scanner
    //The first arrays length
    int ARRAY_LEN1=scan.nextInt();
    //The second arrays length
    int ARRAY_LEN2=scan.nextInt();
    //Declare two vectors arrays with the two indicated lenghts/sizes
    double[] Vector1 = new double[ARRAY_LEN1];
    double[] Vector2 = new double[ARRAY_LEN2];
    //Declare a result array the size of the sum of the two array lengths minus 1
    double[] Result = new double[ARRAY_LEN1+ARRAY_LEN2-1];
    //Scans data into the first vector based on what the indicated length.
    for(int i=0; i<Vector1.length; i++){
      Vector1[i]=(scan.nextDouble());
    }
    //Scans data into the second vector based on what the indicated length.
    for(int i=0; i<Vector2.length; i++){
      Vector2[i]=(scan.nextDouble());
    }
    //Covolve the vertexes using the convolution method.
    convolution(Vector1,Vector2, Result);
     
    


  }
  /**
  * convolution
  * 
  * This method convolves two double arrays.
  * 
  * Parameters: 
  *   double[] Vector1: The first of two double arrays to be convolved.
  *   double[] Vector2: The second of two double arrays to be convolved.
  *   double[] Result: The array which is the correct size for a convolution and is empty
  * 
  * Return value: this method does not return any values however it does output
  * the Result array which cotains the convolution of the two vectors to the 
  * system.
  * 
  *
  */
  public static void convolution(double[] Vector1, double[] Vector2, double[] Result){
    double[] v1 = Vector1;//The first vector is assigned to v1 for brevity
    double[] v2 = Vector2;//The second vector is assigned v2 for brevity
    //If it is the case the 1st vector is smaller than the 2nd vector is the
    //maximumVec and minimumVec methods are implemented to make the first
    //vector automatically become the larger vector and the second vector 
    //automatically become the smaller vector.
    if(Vector1.length!=Vector2.length){

      v1 = maximumVec(Vector1,Vector2); 
      v2 = minimumVec(Vector1,Vector2);
    }
    for(int index=0;index<Result.length; index++){
      //initialize Result at each index to 0 so that it is not undefined when 
      //convolution is happening
      Result[index]=0;
      //The shift is determined by the length of the first and the largest
      //of the two vectors
      for (int shift=0; shift<v1.length; shift++) {
        //This IMS variable that is defined as a placeholder for the Index 
        //Minus the Shift
        int IMS= index-shift;
        if((IMS>=0)&&(IMS<v1.length)&&(shift<v2.length)){
          Result[index]+=(v1[IMS]*v2[shift]);
        }
      }
    }
    int lastIndex = Result.length-1;//the results last index
    //This prints the output of the convolution result
    for (int i = 0; i<lastIndex; i++) {
      Result[i]=Math.round(Result[i]);
      System.out.printf("%d ", (int)Result[i]);
    }
    Result[lastIndex]=Math.round(Result[lastIndex]);
    System.out.printf("%d",((int)(Result[lastIndex])));// print the last value without a space
    System.out.println("");//print a new line
  }

  /**
  * maximumVec
  * 
  * This method finds and returns the longer or larger of two double arrays
  * 
  * Parameters: 
  * double[] firstVector: The first of the arrays to be compared
  * double[] secondVector: The second of the arrays to be compared
  * 
  * Return value: This method returns the larger or longer array.
  *
  */
  public static double[] maximumVec(double[] firstVector, double[] secondVector){
    //Find the largest length between the two vectors.
    int maxLength = Math.max(firstVector.length,secondVector.length);
    //If the first vector is the one with the largest length return it.
    if(firstVector.length==maxLength) 
      return firstVector;
    //Otherwise the second vector is the one with the largest length; return it.
    else 
      return secondVector;
  }

  /**
  * minimumVec
  * 
  * This method finds and returns the shorter or smaller of two double arrays
  * 
  * Parameters: 
  * double[] firstVector: The first of the arrays to be compared
  * double[] secondVector: The second of the arrays to be compared
  * 
  * Return value: This method returns the smaller or shorter array.
  *
  */
  public static double[] minimumVec(double[] firstVector, double[] secondVector){
    //Find the smallest length between the two vectors.
    int minLength = Math.min(firstVector.length,secondVector.length);
    //If the first vector is the one with the smallest length return it.
    if(firstVector.length==minLength) 
      return firstVector;
    //Otherwise the second vector is the one with the smallest length; return it.
    else 
      return secondVector;
  }

}





