/**
 * Team 2
 * Michelle Best
 * Michelle Persaud
 * Eric Liu
 * 
 * Team 2
 * Victoria B.
 * Brian M.
 * Eric Liu
 */

import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
        Node n;
        n = new Node();
        n.setData("Eduardo");


        Node n2 = new Node("Brian");
        n.setNext(n2);

        System.out.println(n);

        System.out.println(n2);

        System.out.println(n.getNext());
        n.getNext().setNext(new Node("Steph"));
        System.out.println(n2.getNext());
        System.out.println(n.getNext().getNext());

        Node L;
        // 1.Create a new  list that looks like:
        //   L->"a"->"b"->"c"->"d"
        // 2. Write the code to insert an "x"
        //    between the b and the c
        // 3. Write the code to delete the c

        Node a = new Node ("a");
        Node b = new Node ("b");
        Node c = new Node ("c");
        Node d = new Node ("d");
        Node x = new Node ("x");

        //current object and next object;  a points to b
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        // 2. Write the code to insert an "x"
        //    between the b and the c
        x.setNext(c); //point x to c
        b.setNext(x); //point b to x

        // 3. Write the code to delete the c
        x.setNext(d); //end result:  a, b, x, d;  c is still in memory. Lines 36-38, 46)

        System.out.println (a); //prints a
        System.out.println (a.getNext()); //prints b
        System.out.println (a.getNext().getNext()); //prints x
        System.out.println (a.getNext().getNext().getNext()); //prints d

        System.out.println("\n");
	      System.out.println("Llist");
        System.out.println("-----------");

        Llist ll = new Llist();
        System.out.print("LL instantiated: ");
        System.out.println(ll);
        ll.addFront("x");
        ll.addFront("y");
        ll.addFront("z");
        System.out.print("LL added xyz: ");
        System.out.println(ll); // expected output is z y x
        
        // isEmpty
        System.out.println("ll.isEmpty(): " + ll.isEmpty());

        // length
        System.out.println("ll.length(): " + ll.length());

        // get
        System.out.println("ll.get(0): " + ll.get(0)); // a
        System.out.println("ll.get(2): " + ll.get(2)); // c
        System.out.println("ll.get(5): " + ll.get(5)); // null

        // set
        ll.set(0,"apple");
        System.out.println("ll.get(0): " + ll.get(0)); // apple
        ll.set(2,"carrot");
        System.out.println("ll.get(2): " + ll.get(2)); // carrot
        ll.set(5,"pear"); // shouldn't work
        System.out.println("ll.get(5): " + ll.get(5)); // null
        System.out.println(ll);

        // insert
        ll.insert(2,"banana");
        System.out.println(ll); // apple --> b --> banana --> carrot --> null

        // search
        System.out.println("ll.search('carrot'): " + ll.search("carrot")); // 3
        System.out.println("ll.search('tomato'): " + ll.search("tomato")); // -1

        // remove
        ll.remove(2);
        System.out.println(ll); // apple --> b --> carrot --> null


    }//end main()
}//end Driver class
