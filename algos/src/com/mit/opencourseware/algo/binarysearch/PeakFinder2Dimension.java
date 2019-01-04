package com.mit.opencourseware.algo.binarysearch;

/**
 * Created by Sri on 12/22/2018.
 */
public class PeakFinder2Dimension {


    public static int[] findPeak( int [][]question, int row, int col) {
        for( int i=0; i < row; i++){
            int localPeak = PeakFinder.findPeak(question[i], 0, col );
            if( localPeak == -1 ){
                continue;
            }
            if( i == 0 && question[i][localPeak] >= question[i+1][localPeak]){
                int peak[] = { i, localPeak };
                return peak;
            }
            if( i == row-1 && question[i][localPeak] >= question[i-1][localPeak]){
                int peak[] = { i, localPeak };
                return peak;
            }
            if( question[i][localPeak] >= question[i+1][localPeak] && question[i][localPeak] >= question[i-1][localPeak] ){
                int peak[] = { i, localPeak };
                return peak;
            }

        }
        int peak[] = { -1, -1 };
        return peak;
    }
    public static void main( String args[]){

        int question[][] = {
                {1,2,3,1},
                {2,3,4,3},
                {5,3,2,4},
                {2,4,1,3}
        };

        int peak[] = findPeak( question, 4, 4 );
        System.out.println( peak[0] + "," + peak[1] );

    }
}
