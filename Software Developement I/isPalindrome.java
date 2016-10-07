import java.util.Scanner; 

public class isPalindrome{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a three-digit integer:");
		int p = input.nextInt();
		if(p<0) p*=-1;
		String possPali = " "+ p;
		boolean isPalidrom=false;
		if(possPali.charAt(1)==possPali.charAt(3)) isPalidrom=true;
		if(isPalidrom){
			System.out.println(p+" is a Palindrome");
		}else{ 
			System.out.println(p+" is not a Palindrome");
		}
			
	}
}