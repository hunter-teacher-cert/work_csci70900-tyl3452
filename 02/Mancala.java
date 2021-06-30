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
//check if there are stones in any pit
//player picks some pit on their side 0-5
//empty chosen pit
//distribute stones from pit
//ai picks some pit 7-12
//empty chosen pit
//distribute stones from pit
//keep going until you run out of stones in the pit

/**
 *
 **/
public class Mancala{
  //0's at indices 6 and 13 to represent mancala
  public static int[] gameBoard = {4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};

  //is a user userTurn
  //asks user which pit to take from
  public static void userTurn(){
    //display gameboard so player can see goes here
    //System.out.println(Arrays.toString(gameBoard));
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.print("User, Which pit to move from?: ");
    int pit = myObj.nextInt();  // Read user input

    // check valid move, loop if user input is invalid
    while(pit > 5 ||
          pit < 0 ||
          gameBoard[pit] == 0) {
      System.out.print("\nInvalid pit. User, Which pit to move from?: ");
      pit = myObj.nextInt();  // Read user input
    }//end while


    int stonesInPit = gameBoard[pit];//grab how many stones are in the pit user picked
    //loop proceeds until stonesInPit == 0
    //increments gameboard elements
    gameBoard[pit] = 0; //empties the pit user picked
    pit++;//incrememnts "pit index"
    //while loop distributes the stones from the pit
    while (stonesInPit>0) {
      if (pit==13) { //makes sure not to drop in opponent's mancala
        pit=0; //loops to my pit
      }
      gameBoard[pit] = gameBoard[pit]+1;
      pit++;
      stonesInPit--;
    }
    //System.out.println(Arrays.toString(gameBoard));
  }

  //is a user aiTurn
  //asks user which pit to take from
  public static void aiTurn(){
    //display gameboard so player can see goes here
    //System.out.println(Arrays.toString(gameBoard));
    Random random = new Random();
    int pit = random.nextInt(5)+7;
    System.out.println("AI's turn is "+pit);



    int stonesInPit = gameBoard[pit];//grab how many stones are in the pit user picked
    //loop proceeds until stonesInPit == 0
    //increments gameboard elements
    gameBoard[pit]=0; //empties the pit user picked
    pit++;//incrememnts "pit index"
    //while loop distributes the stones from the pit
    while (stonesInPit>0){
      if (pit==6){ //makes sure not to drop in opponent's mancala
        pit=7; //loops to ai pit start
      }
      gameBoard[pit]=gameBoard[pit]+1;
      if (pit==13){ //checks if at end of array
        pit=0; //loops back to first pit on opponents side
      }else{ //if not at the end
        pit++; //move on to next pit
      }
      stonesInPit--;
    }
  }//end aiTurn



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
    //check if sum of the two mancalas are 48 meaning all stones dropped
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

    boolean turn = false; //false for user, true for ai

    do {  // game loop
      displayBoard();         // current status of board
      if (turn == false) {    // choose who goes
        userTurn();
      } else {
        aiTurn();
      }
      turn = !turn;           // change/invert turns

    } while (checkWinner() == -1);

    // while(true) {
    //   //setup gameBoard/display it
    //   displayBoard();
    //   userTurn();
    //
    //   // Check if there is a winner
    //   if ( checkWinner() != -1 ) {
    //     break;
    //   }
    //
    //   //display board
    //   displayBoard();
    //   aiTurn();
    //
    //   // Check if there is a winner
    //   if ( checkWinner() != -1 ) {
    //     break;
    //   }
    //
    // }//end while gameloop

  }

}//end Mancala
