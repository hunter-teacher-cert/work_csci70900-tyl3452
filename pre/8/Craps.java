import java.util.Random;
import java.util.Scanner;


public class Craps{
	
	/* @desc Choose random number from 1 to n
	 * 
	 * @param int n max number to choose random number
	 * @return int between 1 and the number n
	 */
	public static int roll(int n) {
		Random dice = new Random();
		return (dice.nextInt(n)+1);	
		
	}//end roll
	
	
	/* @desc Simulates rolling dice
	 * 
	 * @param int numDice number of Dice to use
	 * @param int maxValue max value of the dice
	 * @return int sum result of rolling the dice
	 */
	public static int shoot(int numDice, int maxValue) {
		int result = 0;
		for (int i = 0; i < numDice; i++) {
			result += roll(maxValue);
		}//end for
		
		return (result);
		
	}//end shoot
	
	
	/* @desc checks win or lose for each round
	 * 
	 * @return boolean if shooter wins or loses
	 */
	public static boolean round() {
		int currentRoll = shoot(2,6);
		System.out.printf("Shooter rolls : %d\n", currentRoll);
		if (currentRoll == 2 || currentRoll == 3 || currentRoll == 12) {
			return false;
		} else if (currentRoll == 7 || currentRoll == 11) {
			return true;
		} else { // point is established and must roll point to win
			int point = currentRoll;
			System.out.printf("The point is now : %d\n", point);
			while(true) {
				currentRoll = shoot(2,6);
				System.out.printf("The point is %d and the current roll is %d\n", point, currentRoll);
				if (currentRoll == point) {
					return true;
				} else if (currentRoll == 7) {
					return false;
				} else {
					System.out.println("We roll again!");
				}
			}//end while
		}//end else
			
	}//end round
	
	
	
	public static void main(String[] args) {
		System.out.println("Eric Liu pre08 - Craps");
		
		// Ask user how many rounds to play
		Scanner in = new Scanner(System.in);
		System.out.print("How many rounds? : ");
		int numRounds = in.nextInt();
		

		for (int r = 1; r <= numRounds; r++) {
			System.out.printf("********Round %d********\n", r);
			if (round())
				System.out.printf("Shooter wins round %d\n", r);
			else
				System.out.printf("Shooter loses round %d\n", r);
		}//end for
		
		
	}//end main
}//end class
