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


    public void seed() {
        TreeNode t;
        t = new TreeNode(10);
        root = t;
        t = new TreeNode(5);
        root.setLeft(t);
        t = new TreeNode(20);
        root.setRight(t);

    }//end seed()

}//end class TreeNode
