/**
 * Eric Liu
 */

import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args) {
    	BSTree t = new BSTree();

        //seed initial tree
        t.seed();


        // Test search for 20
        try {
            System.out.println("Debug search for 5: " + t.search(5));
            System.out.println("Debug search for 20: " + t.search(20));
        } catch(NullPointerException e) {
            System.out.println("Debug search for 20: Not found");
        }

        //Test insert
        t.insert(17);
        t.insert(25);
        t.insert(3);
        t.insert(9);

        System.out.println("Debug insert/search for 17: " + t.search(17));
        System.out.println("Debug insert/search for 25: " + t.search(25));
        System.out.println("Debug insert/search for  3: " + t.search(3));
        System.out.println("Debug insert/search for  9: " + t.search(9));
        t.traverse(2);

        //Test traverse
        t.traverse(0);
        t.traverse(1);
        t.traverse(2);

        //Add a few inserts to test delete
        t.insert(2);
        t.insert(8);
        t.insert(16);
        t.insert(13);
        t.insert(14);
        t.insert(37);
        t.insert(7);
        t.insert(18);

        //test delete
        System.out.print("Before delete: ");
        t.traverse(2);

        Scanner in = new Scanner(System.in);
        System.out.print("Enter value to delete: ");
        int deleteValue = in.nextInt();
        t.delete(deleteValue);
        System.out.print("After  delete: ");
        t.traverse(2);


    }//end main()
    
}//end class Driver