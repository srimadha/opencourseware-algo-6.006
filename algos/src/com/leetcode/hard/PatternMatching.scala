package com.leetcode.hard

/**
  * https://leetcode.com/problems/regular-expression-matching/submissions/
  * Created by Sri on 3/30/2019.
  *
  * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
  * *
  * '.' Matches any single character.
  * '*' Matches zero or more of the preceding element.
  * The matching should cover the entire input string (not partial).
  * *
  * Note:
  * *
  * s could be empty and contains only lowercase letters a-z.
  * p could be empty and contains only lowercase letters a-z, and characters like . or *.
  * Example 1:
  * *
  * Input:
  * s = "aa"
  * p = "a"
  * Output: false
  * Explanation: "a" does not match the entire string "aa".
  * Example 2:
  * *
  * Input:
  * s = "aa"
  * p = "a*"
  * Output: true
  * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
  * Example 3:
  * *
  * Input:
  * s = "ab"
  * p = ".*"
  * Output: true
  * Explanation: ".*" means "zero or more (*) of any character (.)".
  * Example 4:
  * *
  * Input:
  * s = "aab"
  * p = "c*a*b"
  * Output: true
  * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
  * Example 5:
  * *
  * Input:
  * s = "mississippi"
  * p = "mis*is*p*."
  * Output: false
  */
object PatternMatching {


  def main(args: Array[String]): Unit = {
    // println( isMatch( "aa", "a*") == true)
    //println( isMatch( "aa", "a") == false)
    //println( isMatch( "ab", ".*") == true)
    // println( isMatch( "aab", "c*a*b") == true)
    //println(isMatch("mississippi", "mis*is*p*.") == false)
    println(isMatch("mississippi", "mis*is*ip*.") == true)
  }

  val map = Map.newBuilder[(Int, Int), Boolean]

  def isMatchRecur(s: String, p: String, i: Int, j: Int): Boolean = {

    if (!map.result().contains((i, j))) {
      val outcome = if (i < 0 && j < 0) true
      else if (i < 0 && j == 0 && p(j) == '*') true
      else if (i < 0 || j < 0) false
      else if (s.charAt(i) == p.charAt(j)) {
        isMatchRecur(s, p, i - 1, j - 1)
      } else if (p.charAt(j) == '*') {
        if (s.charAt(i) == p.charAt(j + 1)) {
          isMatchRecur(s, p, i - 1, j)
        } else if (p.charAt(j + 1) == '.') {
          isMatchRecur(s, p, i - 1, j)
        }

        else {
          isMatchRecur(s, p, i, j - 1)
        }
      } else if (p.charAt(j) == '.') {
        isMatchRecur(s, p, i - 1, j - 1)
      } else if (s.charAt(i) != p.charAt(j) && j > 0 && p.charAt(j - 1) == '*') {
        isMatchRecur(s, p, i, j - 2)
      } else {
        false;
      }
      map += (i, j) -> outcome
    }
    return map.result().get((i, j)).get
  }

  def isMatch(s: String, p: String): Boolean = {
    isMatchRecur(s.reverse, p.reverse, s.length - 1, p.length - 1)
  }
}
