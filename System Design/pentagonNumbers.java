import java.io.*;
import java.util.*;

public class pentagonNumbers{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int colIdx = 1;
        for(int i=1; i<=num; i++){
            int pentagonNum = getPentagonalNumber(i);
            if(colIdx<10&&i<num){
                System.out.print(pentagonNum+" ");
                colIdx++;
            }
            else{
                System.out.println(pentagonNum);
                colIdx = 1;
            }
        }
    }

    public static int getPentagonalNumber(int n){
        int num = (int)(n*(3*n-1)/2);
        return num;
    }
}