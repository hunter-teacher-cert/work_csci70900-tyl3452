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
        System.out.println(q);
        q.enqueue("b");
        System.out.println(q);
        q.enqueue("c");
        System.out.println(q);  //Expected a->b->c->null
        

        //Test dequeue
        q.dequeue();
        System.out.println(q);  // b->c->null
        //Test dequeue
        q.dequeue();
        System.out.println(q);  // c-> null
        //Test dequeue
        q.dequeue();
        System.out.println(q);  // null




    }//end main()

}//end Driver class
