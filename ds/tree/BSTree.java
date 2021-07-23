/**
 * Eric Liu
 */

import java.io.*;
import java.util.*;


public BSTree {
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

}//end class TreeNode
