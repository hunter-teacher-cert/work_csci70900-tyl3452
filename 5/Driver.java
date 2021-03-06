import java.io.*;
import java.util.*;

/**
 * Team 1
 * Peter Tsun
 * Chaouiki H.
 * Eric Liu tayou.liu@gmail.com
 **/

public class Driver {

  public static void main(String[] args) {

    //declare a var of appropriate type to assign an instance of Time to
    Time t1;

    //assign var the address of a newly-apportioned Time object
    t1 = new Time();
    System.out.print("t1 = " + t1);

    Time t2 = null;
    try {
      System.out.print("t2 = " + t2);
    } catch (Exception e) {
      System.out.println("Caught exception, skip");
    }

    Time t3 = t1;
    Time.displayTime(t3);
    System.out.print("t3 using tostring = " + t3);

    Time t4 = new Time(1,42,0.0);
    System.out.print("t4 = " + t4);
    System.out.print("Is t4 equals to t1?: ");
    System.out.println(t4.equals(t1));

    Time t5 = new Time(1,42,0.0);
    System.out.print("Is t5 equal to t4?: ");
    System.out.println(t5.equals(t4));

    System.out.print("Adding two times t4 + t5: ");
    System.out.print(t4.toString() + " + ");
    System.out.print(t5.toString() + " = ");
    System.out.print(t4.add(t5) + "\n");

    Time t6 = new Time(14,56,54.0);
    System.out.print("t6 : " + t6);
    Time t7 = t4.add(t6);
    System.out.print("t7 = t4+t6 = " + t7);

    //test 24 hour overflow
    Time t8 = new Time(23,27,27.0);
    System.out.print("t8: " + t8);
    Time t9 = t8.add(t7);
    System.out.print("t9 = t8+t7: " + t9);


  }//end main()

}//end class
