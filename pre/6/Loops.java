public class Loops{
	
	
	public static void main(String[] args) {
		System.out.println("Eric Liu pre06");

		//test power
		System.out.println("Test power");
		System.out.println(power(2,16));
		System.out.println(power(98,0));
		System.out.println(power(23,1));
		
		//test factorial
		System.out.println("Test factorial");
		System.out.println(factorial(3));
		System.out.println(factorial(5));
		System.out.println(factorial(12));

		//test myexp
		System.out.println("Test myexp power 1");
		System.out.println(myexp(1,1));
		System.out.println(myexp(1,2));
		System.out.println(myexp(1,6));

		//test myexp 2
		System.out.println("Test myexp power 2");
		System.out.println(myexp(2,1));
		System.out.println(myexp(2,2));
		System.out.println(myexp(2,6));

		//test check
		System.out.println("Test check");
		double i = 0.1;
		while(i < 101) {
			check(i);
			i *= 10;
		}//end while

		//test check with negative x
		System.out.println("Test check - negative x");
		double r = -0.1;
		while(r > -101) {
			check(r);
			r *= 10;
		}//end while

	}//end main
	
	/* @desc exercise 3
	 * iterative power
	 *
	 * @param double x is the number
	 * @param integer n is the power
	 * @return double of the resulting expression
	 */
	public static double power(double x, int n) {
		//iterative power
		double total = 1;
		for(int i = 0; i < n; i++) {
			total *= x;
		}//end for
		
		return (total);
		
	}//end power
	
	/* @desc exercise 4
	 * iterative factorial
	 *
	 * @param double x is the number
	 * @param integer n is the power
	 * @return double of the resulting expression
	 */
	public static int factorial(int n) {
		int result = 1;
		for(int i = n;i > 0; i--) {
			result *= i;
		}//end for 
		return (result);
	}//end factorial
	
	
	/* @desc exercise 5
	 * myexp
	 *
	 * @param integer x is the power
	 * @param integer n is number of terms
	 * @return double of the resulting expression
	 */
	public static double myexp(double x, int n) {
		//iterative myexp
		double result = 1;
		
		for(int i = 0; i < n; i++) {
			result += power(x,i+1) / factorial(i+1); 
		}//end for

		return (result);

	}//end myexp
	
	public static void check(double x) {
		System.out.printf("%f\t%f\t%f\n", x, myexp(x,15), Math.exp(x));
		
	}//end check
	
}//end class