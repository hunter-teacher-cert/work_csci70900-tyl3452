/**
 * Team 4
 * Dwayne Levene
 * Eduardo Leite
 * Eric Liu
 *
 * MERGESORT Team 1
 * Peter Tsun
 * Eric Liu
 *
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


    //looks to be selection sort
    public void sort(){
        int i;
        int smallIndex;
        int tempInt;
        for (i=0;i < data.size()-1; i++){
            // find the smallet index from i to end
            // your code here
            smallIndex = findSmallestIndex(i);

            // swap the item at that index and i
            // your code here
            tempInt = data.get(smallIndex);
            data.set(smallIndex, data.get(i));
            data.set(i, tempInt);

        }
      }



    /* If you finish the lab early you can get started on this */
    /**
     *
     * @param value int index first found element equal to value
     * @return -1 if not found, index of target
     */
    public int linearSearch(int value){
        // loop through the ArrayList data
        // and if the value you're searchign for is in the ArrayList, return it.
        // return -1 if it isn't there.
        for(int i=0; i<data.size(); i++) {
          if (data.get(i) == value) {
            return i;
          }
        }//end for

        return -1; // replace this return
    }//end linearSearch()

    /* If you finish the lab early you can get started on this */
    /**
     * @param value int of target in search
     * @return -1 if not found, int of index of first target found
     */
    public int binarySearch(int value){
        boolean isFound=false;
        int lowerIndex = 0;
        int upperIndex = data.size()-1;
        int middleIndex = data.size()/2;

        /* if upper crosses lower it's not there and the lop should exit the loop
        and if the item is at middle you should exit the loop

            you have to replace the "replacethiswithrealexpression" boolean
            with a correct expression based on lowerIndex and upperIndex
        */
        while (lowerIndex <= upperIndex)
        {
            // update lower and upper.
            // remember if value is less than data.get(middleIndex) you want to search next time
            // from lower to the middle and otherwise from the middle to the upper.
            //
            // then update middleIndex based on new lowerIndex and upperIndex.
            System.out.println("Lower: " + lowerIndex + ", Middle: " + middleIndex + ", Upper: " + upperIndex);
            if (value == data.get(middleIndex)) {
                return middleIndex;
            } else if (value > data.get(middleIndex)) {
                lowerIndex = middleIndex + 1;
            } else if (value < data.get(middleIndex)) {
                upperIndex = middleIndex - 1;
            }

            //update middle index
            middleIndex = (lowerIndex + upperIndex) / 2;

        }//end while

        /* replace this return to either return the value if it was found and -1
        if upperIndex and lowerIndex crossed
        */
        return -1;

    }//end binarySearch()


    public String toString() {
	    return ""+data;
    }

    public int get(int index) {
        return data.get(index);
    }

  /*------------------------- MERGESORT STUFF -----------------*/


    // Preconditions: a and b are ArrayLists of Integers and
    //                both are in increasing order
    // Return: a new ArrayList of Integers that is the result
    //         of merging a and b. The new ArrayList
    //         should be in increasing order
    private ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
        int iA = 0;
        int iB = 0;
        int lenA = a.size();
        int lenB = b. size();
        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        while(iA < lenA || iB < lenB){  //loop until exhaust both arraylists
          if (iA < lenA && iB < lenB){
            if (a.get(iA) < b.get(iB)){
              newArrayList.add(a.get(iA));
              iA++;
            } else {
              newArrayList.add(b.get(iB));
              iB++;
            }
        } else if (iA < lenA &&  iB >= lenB) {  //b exhausted first
              newArrayList.add(a.get(iA));
              iA++;
          } else if (iA >= lenA && iB < lenB){  //a is exhausted first
              newArrayList.add(b.get(iB));
              iB++;
          }
        }

        return newArrayList;
    }//end merge


    public ArrayList<Integer> mergeSort(ArrayList<Integer> inputList){
      int lenList = inputList.size();
      if (lenList == 1 || lenList == 1){    // base case
        return inputList; // since a one-item array is sorted
      } else {
        ArrayList<Integer> leftList = new ArrayList(inputList.subList(0, lenList/2));
        ArrayList<Integer> rightList = new ArrayList(inputList.subList(lenList/2+1, lenList));
        //mergeSort( merge(inputList.subList(0,lenList/2), inputList.subList((lenList/2) + 1, lenList)) );
        return merge(mergeSort(leftList), mergeSort(rightList) );
      }
  }//end mergeSort


    private ArrayList<Integer> fillForMerge(int size){
	      ArrayList<Integer> a = new ArrayList<Integer>();
	      int lastVal = r.nextInt(10);
	      for (int i = 0 ; i < size ; i=i+1){
	          a.add(lastVal);
	          lastVal = lastVal + r.nextInt(10);
  	    }
	      return a;

    }//end fillForMerge


    public void testMerge(){

        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();
        ArrayList<Integer> d = new ArrayList<Integer>();

        //Test merge
        a = fillForMerge(20);
        b = fillForMerge(15);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        c = merge(a,b);
        System.out.println("c=merge(a,b): " + c);

        //Test mergeSort
        System.out.println("Testing mergeSort");
        //d = {1,3,8,7,8,0};
        d.add(1);
        d.add(3);
        d.add(8);
        d.add(7);
        d.add(8);
        d.add(4);
        d.add(0);
        System.out.println("d: " + d);
        System.out.println("mergeSort(d): " + mergeSort(d));


    }//end testMerge




}
