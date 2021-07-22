/**
 * 
 * Eric Liu
 */

import java.io.*;
import java.util.*;


public class Llist{
    private Node front; // the front of the list

    public  Llist(){
        front = null;
    }//default constructor

    public void addFront(String data){
        // make the new node
        Node newNode = new Node(data);
        // point it to what front points to
        newNode.setNext(front);
        // point front to the new node
        front = newNode;

    }//end addFront()

    public void addBack(String data){
        Node currentNode = front;
        Node newNode = new Node(data);

        // find the last node
        while(currentNode != null && currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        //System.out.println("debug addBack - currentNode: " + currentNode);

        // point last node to new node
        if(currentNode == null) { //empty list
            front = newNode;
            //System.out.println("debug front - front: " + front);
        } else {
            currentNode.setNext(newNode);
            //System.out.println("debug next - next: " + currentNode.getNext());
        }

    }//end addBack()

    public String toString(){
        Node currentNode;
        currentNode = front;
        String result = "";

        while (currentNode != null){
            result = result + currentNode;
            result += "->";
            // this is like i=i+1 is for arrays
            // but for linked lists
            currentNode = currentNode.getNext();
        }
        result = result + "null";
        return result;

    }//end toString()

    // returns True if there is nothing in the list
    // False otherwise
    public boolean isEmpty(){
      if(front == null) {
        return true;
      }
      return false;
    }

    // returns the number of items in the list
    // Hint: look at the toString
    // to remind you how to traverse down the list
    public int length(){
      int counter = 0;
      Node currentNode = front;
      while(currentNode != null){
        counter++;
        currentNode = currentNode.getNext();
      }
      return counter;
    }

    // returns the item at location index;
    // returns null if there aren't enough
    // items. Starts with index 0
    public String get(int index){
      int i = 0;
      Node currentNode = front;
      while(currentNode != null){
        if(i == index){
          return currentNode.getData();
        }
        i++;
        currentNode = currentNode.getNext();
      }
      return null;
    }//end get()

    // sets the item at location index (starting
    // with 0) to value.
    // only sets if the index is within range
    public void set(int index, String value){
        int i = 0;
        Node currentNode = front;
        while(currentNode != null){
            if(i == index){
                currentNode.setData(value);
                break;
            }
                i++;
                currentNode = currentNode.getNext();
        }
    }

 
    public void insert(int index, String value){

        Node prev=null;
        Node current=front;
        int count = 0;
    
        // This piggybacks the pointers - prev follows
        // current 
        while (current != null && count != index){
            prev = current;
            current = current.getNext();
            count = count + 1;
        }
    
        // at this point, current points to the insertion location (or
        // null) and prev to the node ahead of it (or null in case
        // insertion isat the beginning.
    
        
        // we can only insert if index is in range
        if (current==null){
            return;
        }
    
        // create the new node and set it's next to the current node
        // (where we're inserting.
        Node newNode=new Node(value);
        newNode.setNext(current);
        
        // this handles the special case.
        // if prev isn't null we're at some interior node so we
        // can just insert it.
        if(prev!=null){
            prev.setNext(newNode);
        } else{
            // if prev was null we're inserting at the front
            // which is a special case and we have to make front
            // point to (refer to) the new node.
            front = newNode;
        }
    }

    // returns the index of the first item with
    // data value key. Returns -1 if not found
    public int search(String key){
        int i = 0;
        Node currentNode = front;
        while(currentNode != null){
            if(currentNode.getData() == key){
                return i;
            }
            i++;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

   
    public void remove(int index){
        //find the current node
        Node currentNode = front;
        Node prev = null;
        int i = 0;
        while(currentNode != null && i != index) {
            i++;
            prev = currentNode;
            currentNode = currentNode.getNext();
        }//end while

        //System.out.println("Debug in remove - current node: " + currentNode);

        //if index out of range, nothing to remove
        if(currentNode != null) {
            if(prev != null){  // when not first element
                prev.setNext(currentNode.getNext());
            } else {                            // when first element, set front to next node
                front = currentNode.getNext();
            }            
        }

     }//end remove()

}//end class Queue
