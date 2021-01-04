package com.leetcode.hard;

/**
 * Created by Sri on 1/4/2021.
 * https://leetcode.com/problems/find-in-mountain-array/
 *
 * You may recall that an array A is a mountain array if and only if:

 A.length >= 3
 There exists some i with 0 < i < A.length - 1 such that:
 A[0] < A[1] < ... A[i-1] < A[i]
 A[i] > A[i+1] > ... > A[A.length - 1]
 Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  If such an index doesn't exist, return -1.

 You can't access the mountain array directly.  You may only access the array using a MountainArray interface:

 MountainArray.get(k) returns the element of the array at index k (0-indexed).
 MountainArray.length() returns the length of the array.
 Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.



 Example 1:

 Input: array = [1,2,3,4,5,3,1], target = 3
 Output: 2
 Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 Example 2:

 Input: array = [0,1,2,4,2,1], target = 3
 Output: -1
 Explanation: 3 does not exist in the array, so we return -1.


 Constraints:

 3 <= mountain_arr.length() <= 10000
 0 <= target <= 10^9
 0 <= mountain_arr.get(index) <= 10^9

 */
public class FindInMountainArray {
    class MountainArray{
        int length() {
            return 1;
        }
        int get(int index){
            return 1;
        }
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int index = findPeak( mountainArr );

        int sIndex = binarySearch( target, 0, index - 1, mountainArr, true);
        if( sIndex == -1 ){
            sIndex = binarySearch( target, index, mountainArr.length() - 1, mountainArr, false);
        }
        return sIndex;
    }

    private int binarySearch( int target, int start, int end, MountainArray mArr, boolean asc ){

        if( start <= end ){
            int mid = ( start + end ) / 2;
            int midVal = mArr.get(mid);
            if( midVal == target )
                return mid;
            else if(   midVal >= target ){
                if( asc ){
                    return binarySearch( target, start, mid - 1, mArr, true);
                } else {
                    return  binarySearch( target, mid+1, end, mArr, false);
                }
            } else if( midVal <= target ) {
                if( asc ){
                    return  binarySearch( target, mid+1, end, mArr, true);
                } else {
                    return binarySearch( target, start, mid - 1, mArr, false);
                }
            }
        }

        return -1;
    }
    public int findPeak( MountainArray mountainArr ){
        int e = mountainArr.length() - 1;
        int s = 0;

        while( s <= e ){
            int mid = ( s + e )/2;

            int midVal = mountainArr.get( mid );
            if( mid > 0 && mid < e){
                int midMinusOne = mountainArr.get( mid - 1 );
                int midPlusOne = mountainArr.get( mid + 1 );
                if( midVal >= midMinusOne && midVal >= midPlusOne ){
                    return mid;
                } else if( midVal >= midMinusOne && midVal <= midPlusOne ){
                    s = mid;
                } else if(midVal <= midMinusOne && midVal >= midPlusOne ){
                    e = mid;
                }
            } else {
                break;
            }


        }
        return -1;

    }
}
