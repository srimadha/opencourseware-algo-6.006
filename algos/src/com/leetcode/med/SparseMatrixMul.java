package com.leetcode.med;

import java.util.HashSet;

/**
 * Created by Sri on 1/23/2021.
 *
 * https://leetcode.com/problems/sparse-matrix-multiplication/
 *
 * Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 Input:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]

 Output:

 |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 | 0 0 1 |


 Constraints:

 1 <= A.length, B.length <= 100
 1 <= A[i].length, B[i].length <= 100
 -100 <= A[i][j], B[i][j] <= 100
 */
public class SparseMatrixMul {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B[0].length;

        int col = A[0].length;
        int C[][] = new int[m][n];

        HashSet<Integer> colWithZeroes = new HashSet();
        HashSet<Integer> rowWithZeroes = new HashSet();

        for( int j = 0; j < n; j ++ ){
            boolean colZero = true;
            for( int i = 0; i < col; i++){
                if( B[i][j] != 0 ){
                    colZero = false;
                    break;
                }
            }
            if(colZero == true){
                colWithZeroes.add( j );
            }
        }

        for( int i = 0; i < m; i ++ ){
            boolean rowZero = true;
            for( int j = 0; j < col; j++){
                if( A[i][j] != 0 ){
                    rowZero = false;
                    break;
                }
            }
            if(rowZero == true){
                rowWithZeroes.add( i );
            }
        }

        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                int sum = 0;
                if( rowWithZeroes.contains(i) || colWithZeroes.contains(j)){

                } else {
                    for( int k = 0; k < col; k++ ){
                        sum += A[i][k]*B[k][j];
                    }
                }
                C[i][j] = sum;

            }
        }
        return C;
    }
}
