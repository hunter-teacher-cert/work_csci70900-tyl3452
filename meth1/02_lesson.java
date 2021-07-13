import java.io.*;
import java.util.*;
import java.util.Scanner;
/**
 * Conway's Game of Life
 * 
 **/

/**
 * Eric Liu Teacher notes for 02_lesson.java
 * Assuming we've gone over CGOL rules and algorithm and students already done a short activity
 * on pen/paper to generate a few generations, have the rules of life below in the code
 * for them to implement. They will go over some default patterns and answers to compare with
 * when they code to make sure it is correct.
 * setCell, printBoard, countNeighbors, getNextGenCell,generateNextBoard will be code stubs
 * for students to complete main will also have some predefined test cases but will ask
 * students to load in the test cases they did by hand.
 * Future teacher notes given with preceding //*** 
 */

/**
   The Rules of Life:
   Survivals:
   * A cell with 2 or 3 living neighbours will survive for the next generation.
   Death:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Birth:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
*/

public class Cgol
{

  //initialize empty board (all cells dead)
  public static char[][] createNewBoard(int rows, int cols) {
    char[][] gameBoard = new char[rows][cols];
    for(int j = 0; j < rows; j++) {   // loop for outer rows
      for(int k = 0; k < cols; k++) {    // loop for each row, to access each column
        gameBoard[j][k] = '-';
      }
    }
    return (gameBoard);
  }//end createNewBoard

  //*** Students will complete this method - generateNextBoard
  //*** Prior knowledge of loops/nested loops needed here
  //*** do not write code stub. Students may look at createNewBoard as template for nexted loops
  //print the board to the terminal
  public static void printBoard(char[][] board) {
    for(int j = 0; j < board.length; j++) {   // loop for outer rows
      for(int k = 0; k < board[j].length; k++) {    // loop for each row, to access each column
        System.out.print(board[j][k]);
      }
      System.out.println();
    }
  }

  //*** Students will complete this method - setCell
  //set cell (r,c) to val
  public static void setCell(char[][] board, int r, int c, char val){
    board[r][c] = val;
  }

  //*** Students will complete this method - countNeighbors
  //return number of living neigbours of board[r][c]
  public static int countNeighbours(char[][] board, int r, int c) {
    int countSurrounding = 0;
    boolean checkFirstRow = true;
    boolean checkLeftCol = true;
    boolean checkLastRow = true;
    boolean checkRightCol = true;

    //*** Skip these flags and write the conditionals the the countneighbor logic below
    //*** Once the logic with pseudocode flags in there so can come back to here to finish
    //*** up the flags
    // check flags on which cell to check to avoid out of range errors
    if (r == 0) {
      checkFirstRow = false;
    }
    if (c == 0) {
      checkLeftCol = false;
    }
    if (r == board.length-1) {
      checkLastRow = false;
    }
    if (c == board[0].length-1) {
      checkRightCol = false;
    }
    // System.out.println("board width: " + board[0].length);
    // System.out.println("checkRightCol: " + checkRightCol);
    // System.out.println("c: " + c);

    //[- X -]
    //[- 0 -]
    //[X X X]

    //*** Write the code stubs for the first one or two and have students finish the rest
    //*** Check edge cases, run into issue of out of bounds error
    //*** Compile and run after writing conditional.
    //*** Copy and paste pseudocode to check countNeighbors so students see implementation
    //*** from pseudo -> actual code and decisions being made in real-time
    //*** pseudocode is one large block, then broken down when live-coding.
    //*** check three cells in top row if cell is alive
    //*** check middle left, then middle right is alive
    //*** check bottom three cells if alive
    //*** write all initial conditionals just with board[][] == alive first
    //*** 
    //*** Efficiency/optimization questions, if current cell is in top row, what prediction
    //*** would you make for the output? How do we account for that out of bounds error?
    //*** Similarly, if cell is in left column or right column, how do you check?
    //*** Afterword add pseudocode like flags in the conditional statements, then add the 
    //*** flags I had above these teacher notes.


    //Top row
    if (checkFirstRow && checkLeftCol && board[r-1][c-1] == 'X') {
      //countSurrounding = countSurrounding + 1;
      countSurrounding += 1;
    }
    if (checkFirstRow && board[r-1][c] == 'X')  {
      countSurrounding += 1;
    }
    if (checkFirstRow && checkRightCol && board[r-1][c+1] == 'X') {
      countSurrounding += 1;
    }
    //Middle rows
    if (checkLeftCol && board[r][c-1] == 'X') {
      countSurrounding += 1;
    }
    if (checkRightCol && board[r][c+1] == 'X') {
      countSurrounding += 1;
    }
    // Bottom row
    if (checkLastRow && checkLeftCol && board[r+1][c-1] == 'X') {
      countSurrounding += 1;
    }
    if (checkLastRow && board[r+1][c] == 'X' ) {
      countSurrounding += 1;
    }
    if (checkLastRow && checkRightCol && board[r+1][c+1] == 'X') {
      countSurrounding += 1;
    }
    return countSurrounding;
  }



  //*** Students will complete this method - getNextGenCell
  /**
   * 
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell(char[][] board,int r, int c) {
    int numNeighbors = countNeighbours(board,r,c);
    /**
       The Rules of Life:
       Survivals:
       * A cell with 2 or 3 living neighbours will survive for the next generation.
       Death:
       * Each cell with >3 neighbours will die from overpopulation.
       * Every cell with <2 neighbours will die from isolation.
       Birth:
       * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
       NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
    */
    // current board
    //[- X -]
    //[- X -]
    //[- X -]
    // next gen board
    //[- - -]
    //[X X X]
    //[- - -]

    //*** Students will complete from here on down with the rules of life algo.
    //*** Have students copy and paste the rules in comments in this function so they can
    //*** Try as challenge with a hint: Does the numNeighbors depend on if cell is alive/dead?
    //*** This version below optimizes the fact that neighbors not reliant on aive or dead
    //*** Code the alternate version (below) first
    //*** so they can follow along
    // if cell has 2 or 3 neighbors, cell survives, set to X
    if (numNeighbors == 2) {    // maybe could leave out and let else handle it
      return board[r][c];
    } else if (numNeighbors == 3) {
      return 'X';
    } else if (numNeighbors < 2 || numNeighbors > 3) {  // cell dies starvation or overpopulation
      return '-';
    } else {
      return board[r][c];
    }

    //*** Code this alternate version first
    //*** alternate version that most students will have
    //*** Following the rules of life as comments, leave pseudocode in
    //*** check if dead, then leave stubs for numNeighbors conditionals
    //*** check if alive, then leave stubs for numNeighbors conditionals

    // if (board[r][c] == ' ') { // if dead
    //   if (numNeighbors == 3){ //check if exactly 3 neighbors to birth
    //     return 'X';         // birth
    //   } else {
    //     return ' ';         // dead cell stays dead
    //   }
    // } else if (board[r][c] == 'X') {  // if alive
    //   if (numNeighbors < 2 || numNeighbors > 3) { // cell dies
    //     return ' ';       // dies
    //   } else {
    //     return 'X';       // alive cell stays alive
    //   }
    // } else {
    //   return ' ';         // catchall if not dead or alive, set to dead
    // }

  }//end genNextGenCell


  //*** Students will complete this method - generateNextBoard
  //*** Prior knowledge of loops/nested loops needed here
  //*** write for loop code stubs
  //generate new board representing next generation
  public static char[][] generateNextBoard(char[][] board) {
    char newBoard[][] = new char[board.length][board[0].length];
    for(int j = 0; j < newBoard.length; j++) {   // loop for outer rows
      for(int k = 0; k < newBoard[0].length; k++) {    // loop for each row, to access each column
        newBoard[j][k] = getNextGenCell(board, j, k);
      }
    }
    return (newBoard);
  }

  //*** Students will complete parts of this method - main
  //*** Have some default test cases and have section for student to type in the test cases
  //*** done manually by hand in previous activity

  public static void main( String[] args )
  {
    char[][] board;
    board = createNewBoard(25,25);
    //breathe life into some cells:
    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, 'X');
    setCell(board, 1, 0, 'X');

    //blinker test
    setCell(board, 4, 7, 'X');
    setCell(board, 5, 7, 'X');
    setCell(board, 6, 7, 'X');

    //tub
    setCell(board, 20, 15, 'X');
    setCell(board, 21, 14, 'X');
    setCell(board, 21, 16, 'X');
    setCell(board, 22, 15, 'X');

    // //glider test
    // setCell(board, 11, 3, 'X');
    // setCell(board, 12, 3, 'X');
    // setCell(board, 13, 3, 'X');
    // setCell(board, 13, 2, 'X');
    // setCell(board, 12, 1, 'X');

    //*** Students will enter in their own test case here done in previous activity
    //*** Students will model their code from the above examples
    //*** Example if student entered a glider to test
    setCell(board, 11, 3, 'X');
    setCell(board, 12, 3, 'X');
    setCell(board, 13, 3, 'X');
    setCell(board, 13, 2, 'X');
    setCell(board, 12, 1, 'X');



    //*** Below main game loop will be provided to students
    //*** Students will not need to edit below
    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    boolean nextRound = true;
    int roundNumber = 0;
    while(nextRound) {
      //Print out the game board
      System.out.print("[0;0H\n\n\n");
      //System.out.println("\033[H\033[2J\n\n");

      try {
        Thread.sleep(500);  // delay animation frame
      } catch(InterruptedException ex) {
        System.out.println("Exception caught");
        Thread.currentThread().interrupt();
      }
      System.out.println("Gen :" + roundNumber);
      System.out.println("BEGIN--------------------------------------\n");
      printBoard(board);
      System.out.println("END----------------------------------------\n");

      board = generateNextBoard(board);
      roundNumber++;

      //Next round game loop
      //if animated, take out user confirm to go to next round
      // Scanner myObj = new Scanner(System.in);
      // System.out.print("Go to next round? (Type Y or N): ");
      // String userInput = myObj.nextLine();
      // if (userInput.equals("y") || userInput.equals("Y") || userInput.equals("Yes") || userInput.equals("YES")) {
      //   board = generateNextBoard(board);
      //   roundNumber++;
      // } else {
      //   System.out.println("Thx for playing Conway's Game of Life");
      //   nextRound = false;
      // }
    }//end while

  }//end main()

}//end class
