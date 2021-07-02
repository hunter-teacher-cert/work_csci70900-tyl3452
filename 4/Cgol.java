import java.io.*;
import java.util.*;
import java.util.Scanner;
/**
 * Team 5
 * Michele Persaud
 * Eric Liu
 **/

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


  //print the board to the terminal
  public static void printBoard(char[][] board) {
    for(int j = 0; j < board.length; j++) {   // loop for outer rows
      for(int k = 0; k < board[j].length; k++) {    // loop for each row, to access each column
        System.out.print(board[j][k]);
      }
      System.out.println();
    }
  }


  //set cell (r,c) to val
  public static void setCell(char[][] board, int r, int c, char val){
    board[r][c] = val;
  }


  //return number of living neigbours of board[r][c]
  public static int countNeighbours(char[][] board, int r, int c) {
    int countSurrounding = 0;
    boolean checkFirstRow = true;
    boolean checkLeftCol = true;
    boolean checkLastRow = true;
    boolean checkRightCol = true;

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




  /**
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

    // alternate version
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

    //glider test
    setCell(board, 11, 3, 'X');
    setCell(board, 12, 3, 'X');
    setCell(board, 13, 3, 'X');
    setCell(board, 13, 2, 'X');
    setCell(board, 12, 1, 'X');

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
      System.out.println("END--------------------------------------\n");

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
