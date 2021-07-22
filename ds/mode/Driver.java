import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args) {
	    Mode m = new Mode();
	    System.out.println(m);

        System.out.println("The smallest value is: " + m.findSmallestValue());
        System.out.println("Frequency of 5 is: " + m.frequency(5));
        System.out.println("The largest value is: " + m.findLargestValue());
        System.out.println("The mode is " + m.calcMode());
    }//end main()
    
}//end class Driver