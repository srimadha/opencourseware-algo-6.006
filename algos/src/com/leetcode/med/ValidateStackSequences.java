package com.leetcode.med;

/**
 * Created by Sri on 1/2/2021.
 */

import java.util.Stack;

/**
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.



 Example 1:

 Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 Output: true
 Explanation: We might do the following sequence:
 push(1), push(2), push(3), push(4), pop() -> 4,
 push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 Example 2:

 Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 Output: false
 Explanation: 1 cannot be popped before 2.


 Constraints:

 0 <= pushed.length == popped.length <= 1000
 0 <= pushed[i], popped[i] < 1000
 pushed is a permutation of popped.
 pushed and popped have distinct values.
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int j = 0;

        while( i < pushed.length || j < popped.length ){
            if( j < pushed.length && stack.size() > 0 && popped[j] == stack.peek() ){
                stack.pop();
                j++;
            } else {
                if( i < pushed.length ) {
                    stack.push( pushed[i] );
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
