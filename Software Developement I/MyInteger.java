import java.lang.*;
import java.io.*;
import java.util.*;

public class MyInteger {
    int value;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //kick starter
        boolean returned = false;
        MyInteger obj0 = new MyInteger(0);
        MyInteger obj1 = new MyInteger(0);
        MyInteger obj2 = new MyInteger(0);
        MyInteger obj3 = new MyInteger(0);
        MyInteger obj4 = new MyInteger(0);
        MyInteger obj5 = new MyInteger(0);
        int cInt = 0;
        while(returned == false){
            if(scan.next().charAt(0) == '\n') 
                returned = true;
            System.out.print("Enter a positive integer to create a MyInteger object or <enter> to move to the next part of the program: ");
            obj0 = new MyInteger(scan.nextInt());
            System.out.printf("obj0.getValue() = %d\n",obj0.getValue());
            System.out.printf("obj0.isEven() = %b\n",obj0.isEven());
            System.out.printf("obj0.isOdd() = %b\n",obj0.isOdd());
            System.out.printf("obj0.isPrime() = %b\n",obj0.isPrime());
        
        }
        returned = false;
        while(returned == false){
            if(scan.next().charAt(0) == '\n') 
                returned = true;
            System.out.print("Enter a positive integer to test static isXXX(int) methods or <enter> to move on to next part of the program: ");
            //obj0 = new MyInteger(scan.nextInt());
            cInt = scan.nextInt();
            System.out.printf("isOdd(obj1) = %b",isOdd(cInt));
            System.out.printf("isPrime(obj1) = %b",isPrime(cInt));
        }
        returned = false;
        while(returned == false){
            if(scan.next().charAt(0) == '\n') 
                returned = true;
            System.out.print("Enter a positive integer to test static isXXX(MyInteger) methods or <enter> to move on to next part of the program: ");
            obj1 = new MyInteger(scan.nextInt());
            System.out.printf("MyInteger.isOdd(obj1) = %b", isOdd(obj1));
            System.out.printf("MyInteger.isPrime(obj1) = %b", isPrime(obj1) );
        }
        returned = false;
        while(returned == false){
            if(scan.next().charAt(0) == '\n') 
                returned = true;
            System.out.print("Enter a the first of two positive integers to test obj2.equals(int) or <enter> to move on to next part of the program: ");
            obj2 = new MyInteger();
            cInt = scan.nextInt();
            System.out.printf("obj2.equals(obj2) = %b",obj2.equals(cInt));
        }
        returned = false;
        while(returned == false){
            if(scan.next().charAt(0) == '\n') 
                returned = true;
            System.out.print("Enter a the first of two positive integers to create obj2 and test obj2.equals(MyInteger obj3) or <enter> to move on to next part of the program: ");
            obj2 = new MyInteger(scan.nextInt());
            obj3 = new MyInteger(scan.nextInt());
            System.out.printf("obj2.equals(obj3) = %b",obj2.equals(obj3));
        }
        returned = false;
        while(returned == false){
            if(scan.next().charAt(0) == '\n') 
                returned = true;
            System.out.print("Enter a the second of two positive integers to create obj3 and test obj2.equals(MyInteger obj3) or <enter> to move on to next part of the program: ");
            obj2 = new MyInteger(scan.nextInt());
            obj3 = new MyInteger(scan.nextInt());
            System.out.printf("obj3.equals(obj2) = %b",obj3.equals(obj2));
        }
        returned = false;
        char[] parsee = new char[25];
        char cChar = ' ';
        while(returned == false){
            if(scan.next().charAt(0) == '\n') 
                returned = true;
            System.out.print("Enter a positive integer that will be placed into a char[] array to demonstrate the MyInteger.parseInt(char[]): ");
            parsee = new char[25];
            for(int i = 0; i<parsee.length; i++){
                cChar=scan.next().charAt(i);
                if(cChar!='\n'){
                    parsee[i] = cChar;
                    System.out.print(cChar);
                }
                else
                    break;
            }
        }
        String Parsee = "";
        while(returned == false){
            if(scan.next().charAt(0) == '\n') 
                returned = true;
            System.out.print("Enter a positive integer that will be placed into a charg[] array to demonstrate the MyInteger.parseInt(String): ");
            Parsee = scan.nextLine();
            for(int i = 0; i<Parsee.length(); i++){
                cChar = Parsee.charAt(i);
                System.out.print(cChar);
            }
        }
        
        
        
        /*
        System.out.println();
        parsee[0]='4';
        parsee[1]='0';
        parsee[2]='6';
        parsee[3]='3';
        System.out.println(parseInt(parsee));
        System.out.println(parseInt("4063"));*/
        
        /*char[] parsee = new char[4];
        parsee[0]='4';
        parsee[1]='0';
        parsee[2]='6';
        parsee[3]='3';
        System.out.println(parseInt(parsee));
        System.out.println(parseInt("4063"));*/
    }

    MyInteger(){
    
    }

    MyInteger(int val){
        value=val;
    }

    int getValue(){
        return value;
    }
    
    boolean isEven(){
        if((value%2)==0)
            return true; 
        return false;
    }

    boolean isOdd(){
        if((value%2)==1)
            return true;  
        return false;      
    }

    boolean isPrime(){
        if (value == 0 || value == 1 || value == 2) 
            return true;
        if (isEven()) return false;
        for (int i = 3; i * i <= value; i += 2)
            if (value % i == 0) return false;
        return true;
    }

    static boolean isEven(int v){
        if((v%2)==0)
            return true; 
        return false;
    }

    static boolean isOdd(int v){
        if((v%2)==1)
            return true;  
        return false;    
    }

    static boolean isPrime(int v){
        if (v == 0 || v == 1 || v == 2) 
            return true;
        if (isEven(v)) return false;
        for (int i = 3; i * i <= v; i += 2)
            if (v % i == 0) return false;
        return true;
    } 

    static boolean isEven(MyInteger v){
        if((v.value%2)==0)
            return true; 
        return false;
    }

    static boolean isOdd(MyInteger v){
        if((v.value%2)==1)
            return true;  
        return false;    
    }

    static boolean isPrime(MyInteger v){
        if (v.value == 0 || v.value == 1 || v.value == 2) 
            return true;
        if (isEven(v.value)) return false;
        for (int i = 3; i * i <= v.value; i += 2)
            if (v.value % i == 0) return false;
        return true;
    }

    boolean equals(int n){
        if(n==value)
            return true;
        else
            return false;
    }

    boolean equals(MyInteger n){
        if(n.value==value)
            return true;
        else
            return false;
    }   

    static int parseInt(char[] c){
        int number = 0;
        int NTH_PLACE = 10;
        int cNum = 0;
        for(int i=0; i<c.length; i++){
            cNum = Character.getNumericValue(c[i]);
            cNum *= Math.pow(NTH_PLACE,(c.length-i-1));
            number+=cNum;
        }
        return number;
        
    }

    static int parseInt(String s){
        int number = 0;
        int NTH_PLACE = 10;
        int cNum = 0;
        for(int i=0; i<s.length(); i++){
            cNum = Character.getNumericValue(s.charAt(i));
            cNum *= Math.pow(NTH_PLACE,(s.length()-i-1));
            number+=cNum;
        }
        return number;
        
    }




























}