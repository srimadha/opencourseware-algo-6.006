package com.leetcode.med;

/**
 * Created by Sri on 1/2/2021.
 */

import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/longest-absolute-file-path/
 *
 *
 * Input: input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 Output: 32
 Explanation: We have two files:
 "dir/subdir1/file1.ext" of length 21
 "dir/subdir2/subsubdir2/file2.ext" of length 32.
 We return 32 since it is the longest absolute path to a file.
 */
public class AbsoluteMaxFilePath {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            while(lev+1<stack.size())
                stack.pop(); // find parent
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
        }
        return maxLen;

    }
}
