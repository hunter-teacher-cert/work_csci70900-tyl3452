/**
 * Eric Liu
 */

import java.io.*;
import java.util.*;


public TreeNode {
    private int data;
    private TreeNode left, right;

    public TreeNode() {
        this(0);
        left = null;
        right = null;
    }//default constructor
    
    public TreeNode(int data) {
        this.data = 0;
        left = null;
        right = null;
    }//default constructor

    public void setData(int data) {
        this.data = data;
    }//end setRight

    public void setLeft(TreeNode left) {
        this.left = left;
    }//end setRight

    public void setRight(TreeNode right) {
        this.right = right;
    }//end setRight

    public void getData() {
        return data;
    }//end setRight

    public void getLeft() {
        return left;
    }//end getRight

    public void getRight() {
        return right;
    }//end getRight

}//end class TreeNode
