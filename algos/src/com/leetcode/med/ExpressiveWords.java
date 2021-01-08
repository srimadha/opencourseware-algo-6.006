package com.leetcode.med;

/**
 * Created by Sri on 1/6/2021.
 *
 * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

 For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

 For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

 Given a list of query words, return the number of words that are stretchy.



 Example:
 Input:
 S = "heeellooo"
 words = ["hello", "hi", "helo"]
 Output: 1
 Explanation:
 We can extend "e" and "o" in the word "hello" to get "heeellooo".
 We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.

 https://leetcode.com/problems/expressive-words/

 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        if( S == null || words == null ) return 0;
        int count = 0;

        for( String word :  words ){
            if( isExpressive( S, word )){
                count++;
            }
        }

        return count;
    }

    private boolean isExpressive( String expr, String word){

        if( word == null ) return false;

        int i = 0;
        int j = 0;

        while( i < expr.length() && j < word.length() ){

            if( expr.charAt(i) == word.charAt(j) ) {
                int len1 = getCount( expr, i );
                int len2 = getCount( word, j );

                if( len1 == len2 ){
                    // we are good
                } else if( len2 == 1 && len1 >=3 ){
                    // we are good
                } else if( len1 == len2 || ( len1 >= 3 && len1 - len2 >= 0 )){
                    // we are good
                } else{
                    return false;
                }
                i += len1;
                j += len2;

            } else {
                return false;
            }


        }

        return i == expr.length() && j == word.length();
    }

    private int getCount( String word, int i ){
        int count = 1;
        while( i + count < word.length() && word.charAt(i) == word.charAt(i + count )) count++;
        return count;
    }
}
