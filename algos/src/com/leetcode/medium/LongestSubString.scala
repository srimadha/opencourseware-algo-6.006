package com.leetcode.medium

/**
  * Created by Sri on 3/4/2019.
  */
object LongestSubString {

  val mapBuffer = Map.newBuilder[(Int, Int), Int]

  def lcs(s1: String, s2: String, i: Int, j: Int): Int = {

    if( !mapBuffer.result().contains((i,j))) {
      val count = if (s1.length <= i || s2.length <= j) 0
      else if (s1.charAt(i) == s2.charAt(j)) {
        1 + lcs(s1, s2, i + 1, j + 1)
      } else {
        Math.max(lcs(s1, s2, i, j + 1), lcs(s1, s2, i + 1, j))
      }
      mapBuffer += ((i, j) -> count)
    }

    mapBuffer.result().get((i,j)).get
  }

  def main(args: Array[String]): Unit = {
    println(lcs("abcdxyz", "xyzabcd", 0, 0))
    println()
  }
}
