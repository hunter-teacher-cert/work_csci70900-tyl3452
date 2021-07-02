import java.io.*;
import java.util.*;
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
    return (gameBoard);
  }//end createNewBoard


  //print the board to the terminal
  public static void printBoard(char[][] board) {
    for(int j = 0; j < board.length; j++) {   // loop for outer rows
      for(int k = 0; k < board[j].length; k++) {    // loop for each row, to access each column
        System.out.print(board[j][k] + " ");
      }
      System.out.print("\n");
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
    if (r == board.length) {
      checkLastRow = false;
    }
    if (c == board[0].length) {
      checkRightCol = false;
    }

    //[- X -]
    //[- 0 -]
    //[X X X]

    //Top row
    if (board[r-1][c-1] == 'X' && checkFirstRow && checkLeftCol) {
      //countSurrounding = countSurrounding + 1;
      countSurrounding += 1;
    }
    if (board[r-1][c] == 'X' && checkFirstRow) {
      countSurrounding += 1;
    }
    if (board[r-1][c+1] == 'X' && checkFirstRow && checkRightCol) {
      countSurrounding += 1;
    }
    //Middle rows
    if (board[r][c-1] == 'X' && checkLeftCol) {
      countSurrounding += 1;
    }
    if (board[r][c+1] == 'X' && checkRightCol) {
      countSurrounding += 1;
    }
    // Bottom row
    if (board[r+1][c-1] == 'X' && checkLastRow && checkLeftCol) {
      countSurrounding += 1;
    }
    if (board[r+1][c] == 'X' && checkLastRow) {
      countSurrounding += 1;
    }
    if (board[r+1][c+1] == 'X' && checkLastRow && checkRightCol) {
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


    // if cell has 2 or 3 neighbors, cell survives, set to X
    if (numNeighbors == 2 || numNeighbors == 3) {
      return 'X';
    } else if (numNeighbors < 2 || numNeighbors > 3) {  // cell dies starvation or overpopulation
      return ' ';
    }
  }//end genNextGenCell


  //generate new board representing next generation
  public static char[][] generateNextBoard(char[][] board) {
    char newBoard[][] new char[board.length][board[0].length];
    for(int j = 0; j < board.length; j++) {   // loop for outer rows
      for(int k = 0; k < board[j].length; k++) {    // loop for each row, to access each column
        System.out.print(board[j][k] + " ");
      }
      System.out.print("\n");
    }


    return (temp);
  }


  public static void main( String[] args )
  {
    char[][] board;
    board = createNewBoard(25,25);
    //breathe life into some cells:
    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, 'X');
    setCell(board, 1, 0, 'X');
    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    System.out.println("Gen X:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    int temp = countNeighbours(board,1,1);
    System.out.println("Number of neights at 1,1: " + temp);
    board = generateNextBoard(board);
    System.out.println("Gen X+1:");
    printBoard(board);
    System.out.println("--------------------------\n\n");



    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
