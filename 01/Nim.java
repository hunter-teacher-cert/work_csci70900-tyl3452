import java.util.Random;
import java.util.Scanner;


public class Nim{
	
	public static int stones = 12;


	/**
	 * @desc check if current stones are 0
	 * no error checking or neg number checking
	 * 
	 * @param int numberOfStones
	 * @return boolean game is over if stones is 0
	 */
	public static boolean isGameOver(int numberOfStones) {
		return (numberOfStones == 0);	
	}//end isGameOver
	
	/**
	 * @desc check if current stones are 0
	 * no error checking or neg number checking
	 * 
	 * @param int numberOfStones
	 * @return boolean game is over if stones is 0
	 */
	public static boolean validNumOfStones(int numToRemove) {
		return (numToRemove != 0 && numToRemove < 4 && numToRemove <= stones);	
	}//end isGameOver



	public static void main(String[] args) {
		System.out.println("Eric Liu - Nim");
		
		int stonesToRemove;
		int randomStones;
		
		
		
		while(!isGameOver(stones)) {			
			//State how many stones they currently are
			System.out.println("There are currently " + stones + " stones.");
			
			//ask user amt of stones to remove
			Scanner in = new Scanner(System.in);

			//Keep asking to enter valid number of stones to remove
			while(true) {
				System.out.print("Enter 1-3 stones to remove:");
				stonesToRemove = in.nextInt();
				if (validNumOfStones(stonesToRemove)) {
					stones -= stonesToRemove;
					break;
				}
			}
			
			//print out current number of stones
			System.out.printf("After user turn, There are %d stones.\n", stones);
			
			//check if you win
			if (isGameOver(stones)) {
				System.out.println("User is the winner!");
				break;
			}

			//aiTurn
			//ai randomly selects number of stones to remove
			Random rand = new Random();
			randomStones = rand.nextInt(3)+1;
			System.out.printf("AI try to remove %d stones to remove.\n", randomStones);
			stones -= randomStones;
		
				
			//print out curent number of stones
			System.out.printf("After AI Turn There are %d stones.\n", stones);
			
			//check if ai wins
			if (isGameOver(stones)) {
				System.out.println("User is the winner!");
				break;
			}
			

		}//end while
		
		
		
	}//end main
}//end class
