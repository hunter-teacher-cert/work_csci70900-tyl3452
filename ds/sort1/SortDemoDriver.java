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
        System.out.println("\nsd: " + sd);
        System.out.println("sd2: " + sd2);
        System.out.println("sd linearSearch for 15: " + sd.linearSearch(15));
        System.out.println("sd linearSearch for  3: " + sd.linearSearch(3));
        System.out.println("sd2 linearSearch for 20: " + sd2.linearSearch(20));

        System.out.println("\nsd: " + sd);
        System.out.println("sd2: " + sd2);
        System.out.println("sd binarySearch for 0: " + sd.binarySearch(0));
        System.out.println("sd binarySearch for 15: " + sd.binarySearch(15));
        System.out.println("sd binarySearch for  3: " + sd.binarySearch(3));
        System.out.println("sd2 binarySearch for 19: " + sd2.binarySearch(19));
        System.out.println("sd2 binarySearch for 20: " + sd2.binarySearch(20));


        SortDemo sd3 = new SortDemo();
        sd.testMerge();

    }//end main

}