/**
 * Team 
 * Michell Best
 * Michelle Persaud
 * Eric Liu
 */

import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args) {
		boolean solved;
	
		// Maze m = new Maze("maze.dat");//create new instance/object of Maze
		// //Maze n = new Maze("maze.dat");
		// System.out.println(m);
		// solved = m.solve(3,3);
		
		//Start randomly on the user accessible board
		//test random start
		int boardSize = 5;
		Random rand = new Random();



		//Test knights tour
		Knights k = new Knights(boardSize);
		solved = k.solve(2+2,2+2,1);		// Start knight at (3,3)
		//solved = k.solve(rand.nextInt(boardSize)+2,rand.nextInt(boardSize)+2,1);


		
    }//end main()
}