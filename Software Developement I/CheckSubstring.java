import java.util.*; 


public class CheckSubstring{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string:");
		String s1 = input.nextLine();
		System.out.println("Enter another string:");
		String s2 = input.nextLine();
		boolean isASubstring = false;
		for(int i=0; i<s1.length()-s2.length(); i++){
			String tempString = s1.substring(i,i+(s2.length()));
			if(s2.equals(tempString)) isASubstring = true; 
		}
		if(isASubstring)
			System.out.println(s2 + "is a substring of " + s1);
		else
			System.out.println(s2 + "is not a substring of " + s1);
	}
}