public class Methods{
	
	
	public static void main(String[] args) {
		System.out.println("Eric Liu pre05");
		//test isDivisible
		System.out.println(isDivisible(10,2));
		System.out.println(isDivisible(9,2));
		//test isTriangle
		System.out.println(isTriangle(3,4,5));
		System.out.println(isTriangle(3,4,6));
		System.out.println(isTriangle(3,4,8));
		System.out.println(isTriangle(12,1,1));
		//test ackermann function
		System.out.println(ack(1,1));
		System.out.println(ack(1,2));
		System.out.println(ack(2,1));
		System.out.println(ack(3,2));
		System.out.println(ack(1,3));
		System.out.println(ack(3,3));
		System.out.println(ack(3,5));
		
	}//end main
		
		
	/* @desc exercise 2
	 * checks if a number is divisible by second number
	 *
	 * @param integer n to check if divisible by integer m
	 * @param integer m is the divisor
	 * @return boolean if true and n is divisible by m
	 */
	public static boolean isDivisible(int n, int m) {
		return (n%m == 0);
	}//end isDivisible
		
	/* @desc exercise 3
	 * checks if you can form a triangle given side lengths
	 *
	 * @param integer a is side 1
	 * @param integer b is side 2
	 * @param integer c is side 3
	 * @return boolean if true and n is divisible by m
	 */
	public static boolean isTriangle(int a, int b, int c) {
		if(a >= b+c) {
			return false;
		} else if(b >= a+c) {
			return false;
		} else if(c >= a+b) {
			return false;
		}
		else {
			return true;
		}
	}//end isTriangle
		

	/* @desc exercise 8
	 * ackermann function
	 *
	 * @param integer m 
	 * @param integer n
	 * @return bvalue of ackermann function
	 */
	public static int ack(int m, int n) {
		if(m == 0) {
			return (n+1);
		} else if(m > 0 && n == 0) {
			return (ack(m-1,1));
		} else if(m > 0 && n > 0) {
			return (ack(m-1, ack(m,n-1)));
		} else {
			return (-1);
		}
		
		
	}//end ack



	
}//end class