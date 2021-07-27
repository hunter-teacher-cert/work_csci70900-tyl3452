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

    /**
     * 
     * @param current TreeNode starting node to start search
     * @return TreeNode rightmost node
     */
    public TreeNode findMax(TreeNode current) {
        TreeNode max = current;

        while(max != null) {
            //go right
            if (max.getRight() == null) {
                System.out.println("Found max: " + max.getData());
                return max;
            } else {
                max = max.getRight();
            }
        }//end while
        return null;

    }//end findMax()


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

    /**
     * @param current   TreeNode current node
     * @param mode      int 0-preorder,1-postorder,2-inorder
     */
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

    
    public void delete(int key) {
        //find node you want to delete
        //and the node above it

        //if tree is empty, nothing to delete
        if (root == null) {
            return;
        }

        //start it off
        TreeNode front = root;
        TreeNode trailer = root;

        //find the node you want to delete
        while (front != null && front.getData() != key) {
            if (key < front.getData()) {
                trailer = front;
                front = front.getLeft();
            } else {
                trailer = front;
                front = front.getRight();
            }
        }//end while


        // if we get here, front points to node we want to delete
        // and trailer pts to one above it
        if (front.getLeft() == null && front.getRight() == null) {

            if (trailer.getLeft() == front) {
                trailer.setLeft(null);
            } else {
                trailer.setRight(null);
            }
        } else if (front.getLeft() != null && front.getRight() == null) {

            TreeNode max = findMax(front.getLeft());
            
            if (trailer.getLeft() == front) {
                trailer.setLeft(max);
                
            } else {
                trailer.setRight(max);
            }
            
            max.setLeft(front.getLeft());
            max.setRight(null);
            
            front.setLeft(null);    //may not be necessary

        } else if (front.getLeft() == null && front.getRight() != null) {
            trailer.setRight(front.getRight());

            front.setRight(null);   //may not be necessary
        }
        else {
            //front has two children
            //find the node with largest value on fronts left
            //and replace front with it
            TreeNode max = findMax(front.getLeft());

            //if max has any left child, reposition
            if (max.getLeft() != null) {
                delete(max.getData());
            }
            // max should have no right child
            // reposition max by setting the right to front's right child
            // set left to front's left
            // c
            max.setRight(front.getRight());
            max.setLeft(front.getLeft());
            front = max;
        }

    }// end delete()




}//end class TreeNode
