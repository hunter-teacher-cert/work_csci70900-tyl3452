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


    private void traverse(TreeNode current, int mode) {
        if (current == null)
            return;

        //preorder traversal 
        if (mode == 0) {
            System.out.print(current.getData() + " ");
            traverse(current.getLeft(), mode);
            traverse(current.getRight(), mode);
        } else if (mode == 1) {     // postorder traversal
            traverse(current.getLeft(), mode);
            traverse(current.getRight(), mode);
            System.out.print(current.getData() + " ");
        } else if (mode == 2) {     // inorder traversal
            traverse(current.getLeft(), mode);
            System.out.print(current.getData() + " ");
            traverse(current.getRight(), mode);
        } else {
            System.out.println("Shouldn't get here.");
        }


    }//end private traverse()


    public void traverse(int mode) {
        traverse(root, mode);
        System.out.println();
    }//end traverse()


}//end class TreeNode
