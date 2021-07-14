/**
 * Team
 * Eric Liu
 */

import java.io.*;
import java.util.*;


public class Llist{
    private Node front; // the front of the list

    public  Llist(){
	    front = null;
    }//default constructor

    // Add a new node containing data
    // at the front of the list
    public void addFront(String data){
        // make the new node
        Node newNode = new Node(data);
        // point it to what front points to
        newNode.setNext = front.getNext();
        // point front to the new node
        front.setNext(newNode);

    }//end addFront()

    public String toString(){
        Node currentNode;
        currentNode = front;
        String result = "";
        
        while (currentNode != null){
            result = result + currentNode;
            // this is like i=i+1 is for arrays
            // but for linked lists 
            currentNode = currentNode.getNext();
        }
        result = result + "null";
        return result;

    }//end toString()
    
}//end class Llists