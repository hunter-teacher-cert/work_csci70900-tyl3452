/**
    Team
    Chris O'Brien
    Mamadu Wally
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
        // add item
        this.data[numberElements] = value;

        // increment numberElements
        this.numberElements++;

    }//end add()

    //remove item
    public void remove( int index )
    {

    }//end remove()

    public boolean isEmpty()
    {
        return (this.numberElements==0);
    }


    public int get(int index)
    {
        return (this.data[index]);
    }


    public String toString()
    {
        String tempString = "";
        for(int i=0; i < this.numberElements; i++) {
            tempString = this.data[i] + " ";
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
