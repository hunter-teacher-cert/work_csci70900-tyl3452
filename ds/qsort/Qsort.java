/**
 * Eric Liu
 */
import java.io.*;
import java.util.*;

public class Qsort {
    private ArrayList<Integer> data;
    
    public Qsort() {
        data = new ArrayList<Integer>();
        Random r = new Random();
        for(int i=0; i<10; i++){
            data.add(r.nextInt(10));
        }
    }//end default constructor

    public Qsort(int size) {
        data = new ArrayList<Integer>();
        Random r = new Random();
        for(int i=0; i<size; i++){
            data.add(r.nextInt(10));
        }
    }//end constructor

    // size and bounds
    public Qsort(int size, int bound) {
        data = new ArrayList<Integer>();
        Random r = new Random();
        for(int i=0; i<size; i++){
            data.add(r.nextInt(bound));
        }
    }//end constructor

    // size and bounds
    public static ArrayList<Integer> fillArray(int size, int bound) {
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        Random r = new Random();
        for(int i=0; i<size; i++){
            newArray.add(r.nextInt(bound));
        }
        return newArray;
    }//end fillArray()

    public String toString(){
	    return "" + data;
    }//end toString()

    public static ArrayList<Integer> quickSort(ArrayList<Integer> inputList) {

        ArrayList<Integer> newArray = new ArrayList<Integer>();

        //if data is 0 or 1, just return
        if(inputList.size() < 2) {
            return inputList;
        }
        //take first element as pivot for now
        int pivot = inputList.get(0);
        // System.out.println("Debug chose pivot: " + pivot);

        //split up into LHS and RHS
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for(int i=1; i<inputList.size(); i++) {
            if(inputList.get(i) <= pivot) {
                left.add(inputList.get(i));
            } else {
                right.add(inputList.get(i));
            }
        }
        // System.out.println("Debug  left: " + left);
        // System.out.println("Debug right: " + right);

        // Scanner in = new Scanner(System.in);
        // String userInput = in.nextLine();

        newArray.addAll(quickSort(left));
        newArray.add(pivot);
        newArray.addAll(quickSort(right));
        //System.out.println("Debug newArray: " + newArray);

        return newArray;

    }//end quickSort()

}//end class Qsort
