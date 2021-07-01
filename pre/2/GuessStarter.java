import java.util.Random;
import java.util.Scanner;

public class GuessStarter{
	
	public static void main(String[] args) {
		System.out.println("Eric Liu pre02 3.12");
		
		//Game chooses random number
		Random random = new Random();
		int number = random.nextInt(100) + 1;
		
		Scanner in = new Scanner(System.in);
		int guess;
		
		//Guess my number game
		System.out.println("I've chosen a number between 1 and 100 (inclusive)");
		System.out.print("Guess my number: ");
		guess = in.nextInt();
		
		System.out.printf("Confirming your guess is: %d\n", guess);
		System.out.printf("The number I was thinking of is %d\n", number);
		System.out.printf("You were off by %d\n", Math.abs(number-guess));
		
		
	}//end main
}//end class