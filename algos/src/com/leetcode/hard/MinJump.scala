package com.leetcode.hard

/**
  * Created by Sri on 1/19/2019.
  */
object MinJump {

  val map = scala.collection.mutable.Map[Int, Int]()

  def pj(index: Int, nums: Array[Int]): Int = {

    if (map.contains(index)) return map.get(index).get
    if (index == nums.length - 1) {
      return 0
    }
    if (index >= nums.length) {
      return Int.MaxValue - 1
    }
    val jumps: Int = nums(index)

    val possibleJumps = if (jumps + index > nums.length) {
      nums.length - index;
    } else {
      jumps
    }
    val mins = (1 to possibleJumps).map(x => pj(index + x, nums))
    if (mins.length == 0) return Int.MaxValue - 1;
    val min = mins.min + 1

    map += (index -> min)
    return min

  }


  def jump(nums: Array[Int]): Int = {
    if (nums.length == 0) return 0
    pj(0, nums);
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0)
    println(jump(array))
  }
}
