import java.io.*;
import java.util.*;

public class sortedNumbers{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the three numbers:");
        double num1 = scan.nextDouble();
        double num2 = scan.nextDouble();
        double num3 = scan.nextDouble();
        displayedSortedNumbers(num1, num2, num3);   
    }
    public static void displayedSortedNumbers(double num1, double num2, double num3){
        if(num1<=num3&&num1<=num2){ 
            System.out.print(num1 + ", ");
            if(num2<=num3){
                System.out.print(num2 +", ");
                System.out.println(num3);
            } 
            else if(num3<=num2){
                System.out.print(num3 +", ");
                System.out.println(num2);
            } 
        }
        else if(num2<=num3&&num2<=num1){
            System.out.print(num2 + ", ");
            if(num1<=num3){
                System.out.print(num1 +", ");  
                System.out.println(num3);
            } 
            else if(num3<=num1){
                System.out.print(num3 +", ");
                System.out.println(num1);
            } 
        }
        else if (num3<=num1&&num3<=num2) {
            System.out.print(num3 + ", ");
            if(num2<=num1){ 
                System.out.print(num2 +", ");
                System.out.println(num1);
            }
            else if(num1<=num2){ 
                System.out.print(num1 +", ");
                System.out.println(num2);
            }
        }
    }

}