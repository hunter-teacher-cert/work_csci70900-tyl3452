/**
 * Team 4
 * Dwayne Levene
 * Eduardo Leite
 * Eric Liu
 */

import java.io.*;
import java.util.*;

public class SortDemoDriver {
    public static void main(String[] args) {

        SortDemo sd = new SortDemo();
        System.out.println(sd);

        SortDemo sd2 = new SortDemo(20);
        System.out.println(sd2);
        
        /* part 2 test lines */
        
        int i;
        // i = sd.findSmallestIndex(0);
        // System.out.println("sd["+"] = "+sd.get(i)+" : " + sd);
        // i = sd2.findSmallestIndex(0);
        // System.out.println("sd2["+"] = "+sd2.get(i)+" : " + sd2);
        i = sd.findSmallestIndex(0);
        System.out.println("sd["+ i + "] = " + sd.get(i) + " : " + sd);
        i = sd2.findSmallestIndex(0);
        System.out.println("sd2["+ i + "] = " + sd2.get(i) + " : " + sd2);
        /*
        */
        
        /* part 3 test lines */
        
        System.out.println("sd Pre-sorted:" + sd);
        sd.sort();
        System.out.println("sd After sorted: " + sd);

        System.out.println("sd2 Pre-sorted:" + sd2);
        sd2.sort();
        System.out.println("sd2 After sorted: " + sd2);
        /*
        */
    }//end main

}