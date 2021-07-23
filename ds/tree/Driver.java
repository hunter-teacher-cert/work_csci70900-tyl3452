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

        int value = t.search(5);
        System.out.println("Debug search for 5: " + value);
        
        // Test search for 20
        try {
            System.out.print("\nDebug search for 20: " + t.search(20));
        } catch(NullPointerException e) {
            System.out.println("Debug search for 20: Not found");
        }



    }//end main()
    
}//end class Driver