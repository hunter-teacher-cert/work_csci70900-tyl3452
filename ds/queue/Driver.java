/**
 * 
 * Eric Liu
 */

import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
        System.out.println("Testing Queue");
        Queue q = new Queue();

        //Test load q
        q.enqueue("a");
        System.out.println("Add a: " + q);
        System.out.println("\tTest size: " + q.size());
        q.enqueue("b");
        System.out.println("Add b: " + q);
        System.out.println("\tTest front: " + q.front());
        q.enqueue("c");
        System.out.println("Add c: " + q);  //Expected a->b->c->null
        System.out.println("\tTest isEmpty: " + q.isEmpty());
        System.out.println("\tTest front: " + q.front());


        //Test dequeue
        q.dequeue();
        System.out.println("dequeue 1: " + q);  // b->c->null
        System.out.println("\tTest front: " + q.front());
        q.dequeue();
        System.out.println("dequeue 2: " + q);  // c-> null
        System.out.println("\tTest size: " + q.size());
        q.dequeue();
        System.out.println("dequeue 3: " + q);  // null
        System.out.println("\tTest isEmpty: " + q.isEmpty());
        System.out.println("\tTest front: " + q.front());
        System.out.println("\tTest size: " + q.size());






    }//end main()

}//end Driver class
