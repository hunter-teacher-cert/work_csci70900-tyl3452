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
        System.out.println(n);  // expected output is b->null
        n.addFront("a");
        System.out.println(n);  // expected output is a->b->null
        n.addBack("c");
        System.out.println(n);  // expected output is a->b->c->null
        n.addBack("x");
        System.out.println(n);  // expected output is a->b->c->x->null

        //test removes 
        n.remove(2);
        System.out.println(n);  // expected output is a->b->x->null
        n.remove(2);
        System.out.println(n);  // expected output is a->b->null
        n.remove(0);
        System.out.println(n);  // expected output is b->null
        n.remove(0);
        System.out.println(n);  // expected output is null
        n.addBack("d");
        System.out.println(n);  // expected output is d->null


    }//end main()
}//end Driver class
