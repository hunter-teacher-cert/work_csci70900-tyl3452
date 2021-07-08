/**
    Team 7
    Chris O'Brien
    Mamudu Wally
    Eric Liu tayou.liu@gmail.com
 **/

/**
   lab skeleton
   encapsulation / SuperArray
   SuperArray is a wrapper class for an array.
   Provides "pass-thru" accessibility to array capabilities:
   - get/set by index
   - get length
   Adds functionality:
   - dynamic capacity
   - auto-grow capacity if necessary
 **/

import java.io.*;
import java.util.*;

public class SuperArray
{
    //instance vars
    private int[] data;           //where the actual data is stored
    private int numberElements;   //number of "meaningful" elements


    // ~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~
    //overloaded constructor -- allows specification of initial capacity
    public SuperArray( int size )
    {
        this.data = new int[size];
        this.numberElements = 0;
    }

    //default constructor -- initializes capacity to 10
    public SuperArray()
    {
        this.data = new int[10];
        this.numberElements = 0;
    }


    // ~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~
    public void add( int value )
    {
        // test to see if we need to grow, then grow
        // SIMPLE VERSION DOES NOT AUTO-GROW CAPACITY; INSERT MORE CODE HERE LATER
        if (this.numberElements == this.data.length) {
            grow();
        }
        // add item
        this.data[numberElements] = value;

        // increment numberElements
        this.numberElements++;

    }//end add()

    //overloaded to add with value and index
    public void add( int index, int value )
    {
        // test to see if we need to grow, then grow
        // SIMPLE VERSION DOES NOT AUTO-GROW CAPACITY; INSERT MORE CODE HERE LATER
        if (this.numberElements == this.data.length) {
            grow();
        }

        //alternate algo
        //use existing shift values starting at index to the right
        //and then set data[index] = value
        //make new array with +1 for new item
        //int[] tempArray = new int[this.data.length+1]
        //move all elements at location >=index upone.
        for(int i=this.numberElements; i > index; i--) {
            this.data[i] = this.data[i-1];
        }
        //insert value at this.data[index]
        this.data[index] = value;

        //change number of elements;
        this.numberElements++;

    }//end add()

    //this is add with two params can be called an insert
    public void insert( int index, int value )
    {
        //if array is full, grow it
        if (this.numberElements == this.data.length) {
            grow();
        }

        //move the elements to the right by one
        for(int i=this.numberElements; i > index; i--) {
            this.data[i] = this.data[i-1];
        }
        //insert value at this.data[index]
        this.data[index] = value;

        //change number of elements;
        this.numberElements++;

    }//end insert()

    //remove item
    public void remove( int index )
    {
        // //move elements to the right of index over on to the left
        // for(int i=index; i < this.numberElements; i++) {
        //     if (i == this.data.length-1) {
        //         this.data[i] = 0;               //if last element, set to 0 to avoid out of bounds error
        //     } else {
        //         this.data[i] = this.data[i+1];  // copy the next element into current element
        //     }
        // }

        //alternate way to account for out of bounds
        //got to numberElements-1 and then do the last one manually.
        for(int i=index; i < this.numberElements-1; i++) {
            this.data[i] = this.data[i+1];
        }
        //for last element in array, set to 0
        this.data[this.numberElements-1] = 0;

        //decrement counter
        this.numberElements--;

    }//end remove()

    public boolean isEmpty()
    {
        return (this.numberElements==0);
    }


    public int get(int index)
    {
        return (this.data[index]);
    }


    // public String toString()
    // {
    //     String tempString = "";
    //     for(int i=0; i < this.numberElements; i++) {
    //         tempString += this.data[i] + " ";
    //     }//end for
    //     return tempString;
    // }//end toString()

    //alternate version that prints dash - for empty
    public String toString()
    {
        String tempString = "";
        for(int i=0; i < this.data.length; i++) {
            //check if past number of elements in array
            if (i >= this.numberElements) {
                tempString += "- ";
            } else {
                tempString += this.data[i] + " ";
            }
        }//end for
        return tempString;
    }//end toString()

    //helper method for debugging/development phase
    public String debug()
    {
        String s = "";
        s = "Size: " + this.data.length;
        s = s + " LastItem: " + numberElements + "  Data: ";
        for (int i = 0; i < numberElements; i++) {
        s = s + data[i] + ", ";
        }
        s = s + "\n";
        return s;
    }//end debug()


    private void grow()
    {
        // create a new array with extra space
        // Q: How did you decide how much to increase capacity by?
        // linearly by 10 each time for now
        int[] newData = new int[this.data.length + 10];
        // copy over all the elements from the old array to the new one
        for(int i=0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }//end for

        // point data to the new array
        // Q: How does this look when illustrated using encapsulation diagram?
        // data points to new array with additional empty spaces
        this.data = newData;

    }//end grow()

}//end class
