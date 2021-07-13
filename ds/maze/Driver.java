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
		int boardSize = 5;
		Random rand = new Random();

		Knights k = new Knights(boardSize);
		solved = k.solve(rand.nextInt(boardSize)+2,rand.nextInt(boardSize)+2,1);
		

		
    }//end main()
}