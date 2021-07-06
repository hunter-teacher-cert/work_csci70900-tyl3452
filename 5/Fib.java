import java.util.*;
import java.io.*;

/**
 * Team 1
 * Peter Tsun
 * Chaouiki H.
 * Eric Liu tayou.liu@gmail.com
 **/

public class Fib {

  public static int fib(int n) {
    if(n==0 || n==1){
      return  n;
    }
    else {
      return fib(n-1) + fib(n-2);
    }


    // given a number, argument n
    // if gotten to base case, when number is 0, return 0;
    // add the number with the function with 1 less than the current number
    // and 2 less than the current number



  }//end Fib


  public static void main(String[] args) {

    //test cases
    //f1 = fib(1);
    //f2 = fib(2);

    for (int i = 0; i < 10; i++) {
      System.out.println("Fibonnaci of " + i + ": " + fib(i) );
    }//end for



  }//end main



}//end class
