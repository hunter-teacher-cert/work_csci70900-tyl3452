/**
 * Eric Liu
 */

import java.io.*;
import java.util.*;

/**
 * FIFO Queue
 */
public class Queue {
    private Llist myList;

    public Queue() {
        myList = new Llist();
    }//default constructor

    public void enqueue(String value) {
        myList.addBack(value);
    }//end enqueue()

    public String dequeue() {
        String item = myList.get(0);
        myList.remove(0);
        return item;
    }//end dequeue()

    //Return value at front of list
    public String front() {
        return myList.get(0);
    }//end front()

    public int size() {
        return myList.length();
    }//end size()

    public boolean isEmpty() {
        return myList.isEmpty();
    }//end end isEmpty()

    public String toString() {
        return myList.toString();
    }//end toString override

}//end class Queue
