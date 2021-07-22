/**
 * 
 */

import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {

        ArrayList<Integer> qs1 = new ArrayList<Integer>();
        qs1 = Qsort.fillArray(15,30);
        System.out.println("Before sort List: " + qs1);
        qs1 = Qsort.quickSort(qs1);
        System.out.println(" After sort List: " + qs1);


    }//end main()

}//end class Qsort
