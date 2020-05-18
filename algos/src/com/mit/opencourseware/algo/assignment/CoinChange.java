package com.mit.opencourseware.algo.assignment;

import java.util.HashMap;

/**
 * 2.Write code to calculate the number of different ways we can represent n Canadian dollars using paper bills of 25,10,5 and 1 dollars.
 * There is no constraint on how many paper bills you can use.
 */
public class CoinChange {
    HashMap<String, Integer> map = new HashMap<>();

    public int numWays(int[] bills, int amount, int index) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (index < 0 && amount >= 1) return 0;

        String key = amount + "-" + index;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int count = numWays(bills, amount, index - 1) +
                numWays(bills, amount - bills[index], index);
        map.put(key, count);
        return count;

    }

    public static void main(String[] args) {
        int bills[] = { 1,2,3 };
        int amount = 4;
        int index = 2;

        CoinChange c = new CoinChange();
        int numWays = c.numWays(bills, amount, index);
        System.out.println(numWays);

    }
}
