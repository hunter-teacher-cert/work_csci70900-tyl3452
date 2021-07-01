/** skeleton file for
 class twoDimArray

  ...practice working with 2D arrays
*/

/**
 * Team
 * Michele P.
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
        return 0;
    }


    //return sum of all items in 2D integer array a
    // using helper fxn sumRow
    public static int sum2( int [][] m ) {
        return 0;
    }


    //return sum of all items on row r of 2D integer array a
    // using a FOR loop
    public static int sumRow( int r, int[][] a ) {
        return 0;
    }


    //return sum of all items on row r of 2D integer array a
    // using a FOREACH loop
    public static int sumRow2( int r, int[][] m ) {
        return 0;

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
                /* ~~~v~~~~~slide~me~down~as~you~test~~~~~~~~~~~~~~~v~~~

        System.out.print("testing sum1...\n");
        System.out.println("sum m1 : " + sum1(m1));
        System.out.println("sum m2 : " + sum1(m2));
        System.out.println("sum m3 : " + sum1(m3));
        System.out.print("testing sum2...\n");
        System.out.println("sum m1 : " + sum2(m1));
        System.out.println("sum m2 : " + sum2(m2));
        System.out.println("sum m3 : " + sum2(m3));
        ~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~*/
    }//end main()

}//end class TwoDimArray
