package com.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Sri on 1/27/2021.
 *
 * https://leetcode.com/problems/k-similar-strings/
 *
 * Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.

 Given two anagrams A and B, return the smallest K for which A and B are K-similar.

 Example 1:

 Input: A = "ab", B = "ba"
 Output: 1
 Example 2:

 Input: A = "abc", B = "bca"
 Output: 2
 Example 3:

 Input: A = "abac", B = "baca"
 Output: 2
 Example 4:

 Input: A = "aabc", B = "abca"
 Output: 2
 Note:

 1 <= A.length == B.length <= 20
 A and B contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}
 */
public class KSimilarity {
    public int kSimilarity(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) return -1;

        if (A.equals(B)) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int cnt = 0;
        q.offer(A);
        visited.add(A);

        while (q.size() > 0) {
            int size = q.size();
            cnt++;

            for (int i = 0 ; i < size; i++) {
                String curr = q.poll();
                int index = 0;
                while (curr.charAt(index) == B.charAt(index)) index++;

                for (int j = index + 1; j < curr.length(); j++) {
                    if (curr.charAt(j) == B.charAt(index) && curr.charAt(j) != B.charAt(j)) {
                        String next = swap(curr, j, index);
                        if (visited.contains(next)) continue;

                        if (next.equals(B)) return cnt;

                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    public String swap (String s, int i, int j) {
        char[]arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        // wrong return arr.toString();
        // correct return String.valueOf(arr);
        return new String(arr);
    }
}
