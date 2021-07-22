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

        //if data is 0 or 1, just return
        if(inputList.size() < 2) {
            return;
        }
        //take first element as pivot
        int pivot = inputList.get(0);

        //split up into LHS and RHS
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> left = new ArrayList<Integer>();
        for(int i=1; i<inputList.size(); i++) {
            if(inputList.get(i) < pivot) {
                left.add(inputList.get(i));
            } else {
                right.add(inputList.get(i));
            }
        }

        return quickSort(left).addALL(quicksort(right));

    }//end quickSort()

    public static void main(String[] args) {
        

    }//end main()


}//end class Qsort
