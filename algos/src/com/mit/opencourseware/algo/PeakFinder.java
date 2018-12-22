
package com.mit.opencourseware.algo;
/**
 * Created by Sri on 12/22/2018.
 *
*/
public class PeakFinder {

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
        int question[] = {1, 2, 3, 4, 5};
        System.out.println(findPeak(question, 0, question.length - 1));
    }
}

