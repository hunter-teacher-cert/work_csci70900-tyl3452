/**
 * Mancala
 * Team 5
 * Jiyoon Kim
 * Marina Moshchenko
 * Eric Liu
 **/

import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 *
 **/
public class Mancala{
  // 0's at indices 6 (user mancala) and 13(ai mancala) to represent mancala
  // index starts at 0 on bottom left user pit and goes counter-clockwise and ends at 13 top left
  public static int[] gameBoard = {4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};
  public static boolean userGo = true;

  //asks user which pit to take from
  public static void userTurn(){
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.print("User, Which pit to move from?: ");
    int pit = myObj.nextInt();  // Read user input

    // check valid move, loop if user input is invalid
    if (!noUserMove()) {
      while(pit > 5 ||
            pit < 0 ||
            gameBoard[pit] == 0) {
        System.out.print("\nInvalid pit. User, Which pit to move from?: ");
        pit = myObj.nextInt();  // Read user input
      }//end while

      distributeStones(pit);
    }



  }//end userTurn

  public static boolean noUserMove(){
    int currSum = 0;
    for (int i = 0; i<6;i++){
      currSum+=gameBoard[i];
    }
    return (currSum==0);
  }

  //is a user aiTurn
  //asks user which pit to take from
  public static void aiTurn(){
    //display gameboard so player can see goes here
    //System.out.println(Arrays.toString(gameBoard));
    Random random = new Random();
    int pit = random.nextInt(6)+7;
    System.out.println("AI's turn is " + pit);

    distributeStones(pit);

  }//end aiTurn

  /**
	* distributes the stones to other pits
  * keeps track of whose turn and skips appropriate mancala
  *
  * @param pit number
  * @return None
	*/
	public static void distributeStones(int pitNumber) {
		//starting at pit, grab stones in pit and start redistributing to others
    int stonesInPit = gameBoard[pitNumber]; //grab how many stones are in the pit user picked
    //loop proceeds until stonesInPit == 0
    //increments gameboard elements
    gameBoard[pitNumber] = 0; //empties the pit user picked
    //System.out.print("Debug print:\n");
    //displayBoard(); // debug print
    pitNumber++;  //incrememnts "pit index"
    //while loop distributes the stones from the pit
    while (stonesInPit > 0) {

      // skip mancala logic
      if (userGo == true) { //user's turn
        if (pitNumber == 13) {
          pitNumber = 0;
        }
      } else if (userGo == false) {
        if (pitNumber == 6) {      // ai's turn
            pitNumber = 7;
        }
      }

      gameBoard[pitNumber]++;
      pitNumber++;
      stonesInPit--;

      // Looping the array
      if (pitNumber == 13) { // looping &ai's turn
        pitNumber = 0;
      }

    }//end while

	}//end distributeStones

	/**
	* Displays the current gameBoard
  * @return None
	*/
	public static void displayBoard() {

		//Print gameboard out in full Array without formatting
		//System.out.println(Arrays.toString(gameBoard));

		// Prints AI gameboard in two row format with mancala on the left side
		System.out.print(gameBoard[13] + " ");
		for (int i = 12; i > 6; i--) {
		   System.out.print(gameBoard[i]);
		}

		// Prints user gameboard in two row format with mancala on the right side
		System.out.print("\n  ");
		for (int i = 0; i < 6; i++) {
		   System.out.print(gameBoard[i]);
		}
		System.out.println(" " + gameBoard[6] + " ");

	}//end displayBoard


	/**
	* checkWinner
	*
	* @return int 0 user won, 1 AI won, 2 if tie, -1 if no winner
	*/
	public static int checkWinner() {
    //check if sum of the two mancalas are 48 meaning all stones dropped and a winner
    if ( (gameBoard[6] + gameBoard[13]) == 48) {
      if (gameBoard[6] > gameBoard[13]) {
        System.out.println("User player wins with " + gameBoard[6] + " stones.");
        return 0;
      } else if (gameBoard[6] < gameBoard[13]) {
        System.out.println("AI wins with " + gameBoard[13] + " stones.");
        return 1;
      } else {
        System.out.println("TIE! with 24 stones each.");
        return 2;
      }
    } else { // no winner so return -1
        return -1;
    }

	}//end checkWinner



  public static void main(String[] args){

    do {  // game loop
      displayBoard();         // current status of board
      if (userGo == true) {    // check whose goes
        userTurn();
      } else {
        aiTurn();
      }
      userGo = !userGo;           // change/invert turns

    } while (checkWinner() == -1);

  }//end main

}//end Mancala
