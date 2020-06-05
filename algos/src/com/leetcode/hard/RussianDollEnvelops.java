package com.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Sri on 6/4/2020.
 *
 * https://leetcode.com/problems/russian-doll-envelopes/

 You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Note:
 Rotation is not allowed.

 Example:

 Input: [[5,4],[6,4],[6,7],[2,3]]
 Output: 3
 Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

 */
public class RussianDollEnvelops {

    public static void main(String[] args) {
        int[][] envs = {{5,4},{6,4},{6,7},{2,3}};
        RussianDollEnvelops rs = new RussianDollEnvelops();
        rs.maxEnvelopes(envs);
    }
    public int maxEnvelopes(int[][] envelopes) {
        if( envelopes.length == 0 ) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int arr1[], int arr2[]){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });

        int len = envelopes.length;
        int dp[] = new int[len];

        dp[0] = 1;
        int maxAns = 1;
        for(int i = 1; i < len; i++){
            int maxVal = 0;
            for( int j=0; j<i ; j++){
                if( envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                maxVal = Math.max(dp[j], maxVal);
            }
            dp[i] = maxVal + 1;
            maxAns = Math.max(dp[i], maxAns);
        }

        return maxAns;

    }

}
