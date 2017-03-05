import java.io.*;
import java.util.*;

public class sumTheDigits{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long integer = scan.nextLong();
        int sum = sumDigits();
        System.out.println("The sum of the digits in "+integer+" is "+sum);
    }
    public static int sumDigits(long n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }

}