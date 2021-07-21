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
        
        Dlist n = new Dlist();
        n.addFront("b");
        n.addFront("a");
        n.addBack("c");
        System.out.println(n);  // expected output is a b c
        //Remove b
        n.remove(1);
        System.out.println(n);  // expected output is a c
        n.remove(0);
        System.out.println(n);  // expected output is c
        n.remove(0);
        System.out.println(n);  // expected output is ""
        //n.addBack("d");
        //System.out.println(n);  // expected output is ""


    }//end main()
}//end Driver class
