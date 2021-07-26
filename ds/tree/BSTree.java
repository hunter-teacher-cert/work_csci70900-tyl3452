/**
 * Eric Liu
 */

import java.io.*;
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree() {
        root = null;
    }//default constructor
    
    public void seed() {
        TreeNode t;
        t = new TreeNode(10);
        root = t;
        t = new TreeNode(5);
        root.setLeft(t);
        t = new TreeNode(20);
        root.setRight(t);

    }//end seed()

    public int search(int key) {
        TreeNode current = root;

        while(current != null){
            int currentValue = current.getData();
            if(key == currentValue) {
                return key;
            } else if(key < currentValue) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        throw new NullPointerException();

        //return -1;  // if not found
    }//end search()


    public void insert(int key) {
        TreeNode newNode = new TreeNode(key);
        
        //if empty tree
        if(root == null) {
            root = newNode;
            return;
        }

        TreeNode front = root;
        TreeNode trailer = root;

        while(front != null) {
            int frontValue = front.getData();
            if (key == frontValue) {
                return;
            } else if (key < frontValue) {
                trailer = front;
                front = front.getLeft();
            } else {
                trailer = front;
                front = front.getRight();
            }
        }//end while

        //do the insert
        if (key > trailer.getData()) {
            //insert on right
            trailer.setRight(newNode);
        } else {
            trailer.setLeft(newNode);
        }

    }//end insert()


    private void traverse(Node *current) {
        if (current == null)
            return;

        System.out.print(current.getData() + " ");

        traverse(current.getLeft());
        traverse.getRight();

    }//end private traverse()


    public void traverse() {
        Node current = root;



    }//end traverse()


}//end class TreeNode
