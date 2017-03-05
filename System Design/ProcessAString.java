import java.util.*; 


public class ProcessAString{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string:");
		String s = input.nextLine();
		System.out.println("The string is of length " + s.length() + " and the first character is " + s.charAt(0));
	}
}