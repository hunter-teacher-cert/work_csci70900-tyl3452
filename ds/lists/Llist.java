/**
 * Team 2
 * Michelle P.
 * Michelle B.
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
        newNode.setNext(front);
        // point front to the new node
        front = newNode;

    }//end addFront()

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
    }

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

    // insert an item before index.
    // only inserts if the index is within bounds
    // Hint: look at toString for hints on
    // traversal and draw out a diagram.
    // You will need a variable that refers to
    // the node BEFORE you want to do the insertion.

    // 0         1     2          3
    // apple --> b --> carrot --> null
    // ll.insert(2,"banana");
    // apple --> b --> banana --> carrot --> null

    public void insert(int index, String value){
      int i = 0;
      Node currentNode = front;
      while(currentNode != null){
        if(i == index-1){
          Node newNode = new Node(value,currentNode.getNext());
          currentNode.setNext(newNode);
          break;
        }
        i++;
        currentNode = currentNode.getNext();
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

    // removes the node at index.
    // does nothing if index out of bounds

    // 0         1     2          3
    // apple --> b --> banana --> carrot --> null
    // ll.remove(2);
    // 0         1     2
    // apple --> b --> carrot --> null
    public void remove(int index){
      int i = 0;
      Node currentNode = front;
      while(currentNode != null){
        if(i == index-1){
          currentNode.setNext(currentNode.getNext().getNext());
          break;
        }
        i++;
        currentNode = currentNode.getNext();
      }
    }

}//end class Llists
