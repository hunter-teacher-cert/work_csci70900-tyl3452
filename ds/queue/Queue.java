/**
 * Eric Liu
 */

import java.io.*;
import java.util.*;

/**
 * FIFO Queue
 */
public class Queue extends Llist{
    private Node front, end;

    public Queue() {
        this.front = null;
        end = null;
    }//default constructor

    public void enqueue(String value) {
        Node newNode = new Node(value);
        newNode.setNext(null);
        if (end != null) {
            front = newNode;
            end.setNext(newNode);
        }
        end = newNode;
    }//end enqueue()

    public String dequeue() {
        String item = get(0);
        remove(0);
        return item;
    }//end dequeue()

    //Return value at front of list
    public String front() {
        return get(0);
    }//end front()

    public int size() {
        return length();
    }

}//end class Queue
