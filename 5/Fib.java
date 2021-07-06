import java.util.*;
import java.io.*;

/**
 * Team 1
 * Peter Tsun
 * Chaouiki H.
 * Eric Liu
 **/

public class Fib {

  public int fib(int n) {
    // given a number, argument n
    // if gotten to base case, when number is 0, return 0;
    // add the number with the function with 1 less than the current number
    // and 2 less than the current number



    return fib(n-1) + fib(n-2);

  }//end Fib


  public static void main(String[] args) {

    //test cases
    //f1 = fib(1);
    //f2 = fib(2);

    for (int i = 1; i < 10; i++) {
      System.out.println("Fibonnaci of " + i + ": " + fib(i) );
    }//end for

    }

  }//end main



}//end class
