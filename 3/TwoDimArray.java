/** skeleton file for
 class twoDimArray

  ...practice working with 2D arrays
*/

/**
 * Team
 * Michele Persaud
 * Eric Liu
 **/

public class TwoDimArray
{

    //print each row of 2D integer array a on its own line,
    // using a FOR loop
    public static void print1( int[][] a ) { //
        for(int j = 0; j < a.length; j++) {   // loop for outer rows
            for(int k = 0; k < a[j].length; k++) {    // loop for each row, to access each column
                System.out.print(a[j][k] + " ");
            }
            System.out.print("\n");
        }
    }


    //print each row of 2D integer array a on its own line,
    // using a FOREACH loop
    public static void print2( int[][] a ) {
        for( int[] j : a ) { //print a row from array a
            for( int k : j ) { //
                System.out.print(k + " ");
            }
            System.out.print("\n");
        }
    }

    //return sum of all items in 2D integer array a
    public static int sum1( int[][] a ) {
        int total = 0;
        for(int j = 0; j < a.length; j++) {   // j for rows; loop for outer rows
            for(int k = 0; k < a[j].length; k++) {    // k for columns-loop for each row, to access each column
                total = total + a[j][k];//sum for 0+5 = 5;  5+5 = 10 +5 = 15 + 0
            }//end for k
        }//end for j

        return total;
    }
    // [5,5,5]
    // [2,9,8]
    // [7,9,2]

    //return sum of all items in 2D integer array a
    // using helper fxn sumRow
    public static int sum2( int [][] m ) {
        int total = 0;
        for(int j = 0; j < m.length; j++) {   // j for rows; loop for outer rows
            total = total + sumRow(j, m);
        }//end for j
        return total;
    }


    //return sum of all items on row r of 2D integer array a
    // using a FOR loop
    public static int sumRow( int r, int[][] a ) {
        for(int k = 0; k < a[r].length; k++) {    // k for columns-loop for each row, to access each column
            total = total + a[r][k];
        }//end for k

        return total;
    }


    //return sum of all items on row r of 2D integer array a
    // using a FOREACH loop
    public static int sumRow2( int r, int[][] m ) {
        for(int item : m[r]) {
            total = total + item;
        }//end for k

        return total;

    }


    public static void main( String [] args )
    {

        int [][] m1 = new int[4][2];
        int [][] m2 = { {2,4,6}, {3,5,7} };
        int [][] m3 = { {2}, {4,6}, {1,3,5} };
        print1(m1);
        print1(m2);
        print1(m3);
        print2(m1);
        print2(m2);
        print2(m3);
        System.out.print("testing sum1...\n");
        System.out.println("sum m1 : " + sum1(m1));
        System.out.println("sum m2 : " + sum1(m2));
        System.out.println("sum m3 : " + sum1(m3));

        System.out.print("testing sum2...\n");
        System.out.println("sum m1 : " + sum2(m1));
        System.out.println("sum m2 : " + sum2(m2));
        System.out.println("sum m3 : " + sum2(m3));
        /* ~~~v~~~~~slide~me~down~as~you~test~~~~~~~~~~~~~~~v~~~

        ~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~*/
    }//end main()

}//end class TwoDimArray
