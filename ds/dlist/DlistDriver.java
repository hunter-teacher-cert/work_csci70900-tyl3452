/**
 * Team 1
 * Victoria B.
 * Brian M.
 * Eric Liu
 */

import java.io.*;
import java.util.*;

public class DlistDriver{
    public static void main(String[] args) {
        
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");

        Dlist n = new Dlist();
        n.addFront(b);
        n.addFront(a);
        n.addBack(c);
        System.out.println(n);  // expected output is a b c
        //Remove b
        n.remove(1);
        System.out.println(n);  // expected output is a c


    }//end main()
}//end Driver class
