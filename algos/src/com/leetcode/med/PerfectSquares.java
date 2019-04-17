package com.leetcode.med;

import java.util.Arrays;

/**
 * Created by Sri on 4/14/2019.
 */
public class PerfectSquares {
    public static int numSquares(int n) {
        if( n <= 0) return 0;
        int arr[] = new int[n+1];
        Arrays.fill( arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for(int i=1; i<= n; i++){
            for(int j=1; j*j <= i ;j++){
                arr[i] = Math.min(arr[i], arr[i -j*j] + 1);
            }
        }
        return arr[n];
    }
    public static void main(String args[]){
        System.out.println( numSquares(10));
    }
}
