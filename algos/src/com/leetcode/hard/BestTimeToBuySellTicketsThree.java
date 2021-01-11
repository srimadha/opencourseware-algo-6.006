package com.leetcode.hard;

/**
 * Created by Sri on 4/28/2019.
 */
public class BestTimeToBuySellTicketsThree {
    public static int maxProfit(int[] prices) {

        if(prices.length == 0 || prices.length == 1) return 0;
        int noOfTransaction = 2;
        int dp[][] = new int[noOfTransaction+1][prices.length];

        int maxProfit = Integer.MIN_VALUE;

        for(int i=1; i<=noOfTransaction; i++){
            int tmpMax = dp[i-1][0] - prices[0];
            for(int j=1; j < prices.length; j++ ){
                dp[i][j] = Math.max( dp[i][j-1],  prices[j] + tmpMax );
                tmpMax =  Math.max( tmpMax, dp[i-1][j] - prices[j] );
                maxProfit = Math.max( maxProfit, dp[i][j] );
            }

        }

        for(int i=0; i<= noOfTransaction; i++){
            for(int j=0; j< prices.length; j++){
                System.out.print( dp[i][j] + " ");
            }
            System.out.println();
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println( maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
