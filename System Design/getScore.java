import java.io.*;
import java.util.*;
import java.lang.*;

public class getScore{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter number of students:");
        int stdnts = scan.nextInt();
        System.out.print("Enter "+stdnts+"scores: ");
        int[] scores = new int[stdnts];
        int best = 0; // The best score
        char grade; // The grade
       for (int i = 0; i < scores.length; i++) {
       int scoreString = scan.nextInt();
          scores[i] = scoreString;
         if (scores[i] > best)
         best = scores[i];
        }

    // Declare and initialize output string
    String output = ""; 
    
    // Assign and display grades
    for (int i = 0; i < scores.length; i++) {
      if (scores[i] >= best - 10)
        grade = 'A';
      else if (scores[i] >= best - 20)
        grade = 'B';
      else if (scores[i] >= best - 30)
        grade = 'C';
      else if (scores[i] >= best - 40)
        grade = 'D';
      else
        grade = 'F';

      output += "Student " + i + " score is " + 
        scores[i] + " and grade is " + grade + "\n";
    }

    System.out.println(output);
}
}