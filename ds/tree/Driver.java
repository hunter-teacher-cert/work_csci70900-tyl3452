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


        //Test traverse
        t.traverse();

    }//end main()
    
}//end class Driver