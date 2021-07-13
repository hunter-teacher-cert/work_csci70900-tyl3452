/**
 * Team 
 * 
 * 
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
		
		
		Knights k = new Knights(5);
		solved = k.solve(1,1,1);
		
    }//end main()
}