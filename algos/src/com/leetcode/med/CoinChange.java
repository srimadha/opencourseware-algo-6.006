package com.leetcode.med;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Sri on 4/24/2019.

 https://leetcode.com/problems/coin-change/

 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:

 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 Note:
 You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    class Solution {
        HashMap<Integer, Integer> map = new HashMap<>();
        public int coinChange(int[] coins, int amount) {
            if( amount < 0 ) return -1;
            if( amount == 0 ) return 0;
            if(! map.containsKey( amount ) ){
                int min = Integer.MAX_VALUE;
                for( int coin : coins ){
                    int res = coinChange(coins, amount - coin );
                    if( res >= 0 && res < min ) {
                        min = 1 + res;
                    }
                }
                if( min == Integer.MAX_VALUE ) min = -1;
                map.put( amount, min);
            }
            return map.get(amount);
        }

        public int coinChange2(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
