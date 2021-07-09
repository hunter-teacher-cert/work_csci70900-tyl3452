/**
 * Team 4
 * Dwayne Levene
 * Eduardo Leite
 * Eric Liu
 */

import java.io.*;
import java.util.*;

/*
Setup:
 1.Make a folder under your work repo named: ds
 2. Make another folder under that named sort1
 3. Copy this file and SortDemoDriver.java into the ds/sort1 folder
 
Lab:
Part 1:  
  1. Analyze the two constructors - try to figure out how they work.
  2. Compile and run the program (SortDemoDriver.java and SortDemo.java) and confirm
   the behavior of the constructors.
Part 2:
  1. Read the description of findSmallestIndex and complete the method.
  2. Uncomment the lines in SortDemoDriver to test.
Part 3:
  1. Complete the sort method - read comments for description
  2. Uncomment the lines in sortDemoDriver to test.
*/

public class SortDemo{

    /* Instance Variables */
    private ArrayList<Integer> data;  // to store the data
    private Random r; 

    //default constructor that creates Integer ArrayList of 15 random integers from 0 to 20
    public SortDemo(){
        data = new ArrayList<Integer>();
        r = new Random();
        for (int i=0;i<15;i++){
            data.add(r.nextInt(20));
        }
	
    }
    
    //constructor with target size, initialize ArrayList of Integers random from 0 to 20.
    public SortDemo(int size){
        data = new ArrayList<Integer>();
        r = new Random();
        for (int i=0;i<size;i++){
            data.add(r.nextInt(20));
        }
	
    }

    /*
      return the index of the ArrayList data from index start to the end
      Example, if the arraylist has:
      5,3,10,6,8
      if start was 2 (start at index 2, value 10) then it woudl return 3 which is the index of the value
      6 which is the index with the smallest value from start to end

      @param int start given an index to start looking for smallest element in array
    */
    public int findSmallestIndex(int start){
	    // start a variable at the one after start
        // your code here
        int smallIndex = start;
        
        // loop from that variable to end and update smallIndex as needed
        // your code here
        for(int i=start+1; i<data.size(); i++){
          if(data.get(i) < data.get(smallIndex)) {
            smallIndex = i;
          }
        }//end for
        
        return smallIndex;

    }


    
    public void sort(){
	int i;
	for (i=0;i < data.size()-1; i++){
	    // find the smallet index from i to end
	    // your code here

	    // swap the item at that index and i
	    // your code here
	    
	    
	}
    }



    /* If you finish the lab early you can get started on this */
    public int linearSearch(int value){
        // loop through the ArrayList data
        // and if the value you're searchign for is in the ArrayList, return it.
        // return -1 if it isn't there.
        
        
        return 0; // replace this return
    }
    
    /* If you finish the lab early you can get started on this */
    public int binarySearch(int value){
        boolean replacethiswithrealexpression=false;
        int lowerIndex = 0;
        int upperIndex = data.size();
        int middleIndex = data.size()/2;
        
        /* if upper crosses lower it's not there and the lop should exit the loop
        and if the item is at middle you should exit the loop
        
            you have to replace the "replacethiswithrealexpression" boolean 
            with a correct expression based on lowerIndex and upperIndex
        */
        while (replacethiswithrealexpression)
            {
            // update lower and upper.
            // remember if value is less than data.get(middleIndex) you want to search next time
            // from lower to the middle and otherwise from the middle to the upper.
            //
            // then update middleIndex based on new lowerIndex and upperIndex.
            
            }
        
        /* replace this return to either return the value if it was found and -1
        if upperIndex and lowerIndex crossed
        */    
        
        return 0; // replace this return
    }
    
	
    public String toString(){
	    return ""+data;
    };

}
