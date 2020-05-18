package com.mit.opencourseware.algo.assignment;

/**
 * 1.Input: Two 1-D arrays A and B.
 * Both input arrays are sorted.
 * Write a method to merge B into A in sorted order. A is big enough to hold all elements in A and B.
 */
public class MergeSorted {
    int[] merge( int []a, int []b, int alength, int blength ) {
        int aIndex = alength - 1;
        int bIndex = blength - 1;

        int index = alength + blength - 1;

        while( aIndex >= 0 && bIndex >= 0 ){
            if( a[aIndex] > b[bIndex ]){
                a[index] = a[aIndex];
                aIndex--;
            } else {
                a[index] = b[bIndex];
                bIndex--;
            }
            index--;
        }
        while( aIndex >= 0 ){
            a[index] = a[aIndex];
            aIndex--;
            index--;
        }
        while( bIndex >= 0 ){
            a[index] = b[bIndex];
            bIndex--;
            index--;
        }
        return a;
    }

    public static void main(String[] args) {
        MergeSorted ms = new MergeSorted();
        int[] a = {1,4,6,9,0,0,0,0,0};
        int[] b = {2,3,5,10,12};
        int[] c = ms.merge(a, b, 4, 5);
        for(int i=0; i<c.length; i++){
            System.out.print(c[i] + ", ");
        }
    }
}
