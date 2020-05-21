package com.leetcode.med;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sri on 5/12/2019.
 *
 * O(1) insert, remove, getRandom
 */
public class RandomizedSet {


    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    java.util.Random rand = new java.util.Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            map.put(val, list.size() - 1);
        }
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) return false;
        int loc = map.get(val);
        if (loc < list.size() - 1) {
            int lastone = list.get(list.size() - 1);
            list.set(loc, lastone);
            map.put(lastone, loc);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

