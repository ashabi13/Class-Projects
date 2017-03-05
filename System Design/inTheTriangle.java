import java.util.Scanner; 

public class inTheTriangle{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Point one of triangle
		double p1x = 0;
		double p1y = 0;
		//Point two of triangle
		double p2x = 200;
		double p2y = 0;
		//Point three of triangle
		double p3x = 0;
		double p3y = 100;
		System.out.println("Enter a point's x- and y- cordinates");
		//separate x cord from y cord
		double userPointX = input.nextDouble();
		double userPointY = input.nextDouble();
		//check to see if x and y cords point to a point that 
		//slope is m
		double m = ((p2y-p3y)/(p2x-p3x));
		//y-intercept is b
		double b = 100+m*p3x;
		//hypotenuse is y
		double y = m * userPointX + b;

		if(userPointY>y) 
			System.out.println("The point is not in the triangle.");
		else if(userPointY<=y) 
			System.out.println("The point is in the triangle.");


	}
}