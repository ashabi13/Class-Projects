import java.util.*; 
import java.io.*; 
public class CountItAll{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cI = 0;
        int pos = 0, neg = 0;
        double total = 0.0, average = 0.0;
        //try{
            while((cI=input.nextInt())!=0){
                //System.out.println(cI);
                if(cI<0) neg++;
                else if(cI>0) pos++;
                total+=cI;                
            }
        //}
        /*catch(IOException e){
            System.out.println("Something went wrong.");
        }*/
        
        System.out.println("The number of positives is "+ pos);
        System.out.println("The number of negetives is "+ neg);    
        System.out.println("The total is "+ total);  
        System.out.println("The average is "+ total/(pos+neg));      
    }
}    