/**
    Team
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

    //remove item
    public void remove( int index )
    {
        //move elements to the right of index over on to the left
        for(int i=index; i < this.numberElements; i++) {
            this.data[i] = this.data[i+1];
        }
        //set last element to 0 to reset it
        this.data[this.numberElements-1] = 0;
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
