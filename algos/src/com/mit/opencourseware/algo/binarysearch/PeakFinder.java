
package com.mit.opencourseware.algo.binarysearch;
/**
 * Created by Sri on 12/22/2018.
 *
*/
public class PeakFinder {

    /**
     * Finding peak using binary search, handling the edge cases in the beginning there should be a better way to do this.
     * @param question
     * @return
     */


    public static int findPeakNonRecursive( int[] question ){
        for( int i =0; i < question.length; i ++ ){
            if( i == 0 ) {
                if( question[i] >= question[i+1] )
                    return i;
            }else if ( i == question.length - 1 ){
                if( question[i] >= question[i-1])
                    return i;
            }else{
                if( question[i] >= question[i+1] && question[i] >= question[i-1] )
                    return i;
            }
        }
        return -1;
    }

    /**
     *
     *
     * @param question
     * @param i
     * @param j
     * @return
     */
    public static int findPeak(int[] question, int i, int j) {

        if (i > j) {
            return -1;
        }

        int mid = (i + j) / 2;

        if( mid == question.length - 1){
            if( question[mid] >= question[mid - 1]){
                return mid;
            }else{
                return -1;
            }
        } if( mid == 0){
            if( question[mid] >=question[mid+1]){
                return mid;
            }else{
                return -1;
            }
        }

        if (question[mid] >= question[mid - 1] && question[mid] >= question[mid + 1]) {
            return mid;
        } else {
            if (question[mid] <= question[mid - 1]) {
                return findPeak(question, i, mid - 1);
            } else {
                return findPeak(question, mid + 1, j);
            }
        }
    }

    public static void main(String[] args) {
        int question[] = {7, 6, 5, 4, 5, 6, 7};
        System.out.println(findPeak(question, 0, question.length - 1));
        System.out.println(findPeakNonRecursive(question));
    }
}

