/**
 * Team 1
 * Peter Tsun
 * Chaouiki H.
 * Eric Liu tayou.liu@gmail.com
 **/

import java.io.*;
import java.util.*;

public class Time {

  // your implementation of class Time here
  // private int hour;
  // private int minute;
  // private double second;
  int hour;
  int minute;
  double second;

  //default constructor
  public Time() {
    this.hour = 0;
    this.minute = 0;
    this.second = 0.0;
  }

  //constructor if only specified hour
  public Time(int hour) {
    this.hour = hour;
    this.minute = 0;
    this.second = 0.0;
  }

  //constructor if only specified hour and min
  public Time(int hour, int minute) {
    this.hour = hour;
    this.minute = minute;
    this.second = 0.0;
  }

  //constructor, if all three are specified
  public Time(int hour, int minute, double second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  // Print out time
  public static void displayTime(Time t) {
    System.out.printf("Time is %d : %d : %f \n", t.hour, t.minute, t.second);

  }//end displayTime


}//end class
