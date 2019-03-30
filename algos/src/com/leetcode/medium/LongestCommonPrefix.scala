package com.leetcode.medium

/**
  * Created by Sri on 1/20/2019.
  */
object LongestCommonPrefix {

  def isValid( index : Int, arr : Array[String]) : Boolean = {
    if(index > arr(0).length) return false
    val char = arr(0).charAt(index)
    arr.foreach( str => {
      if(index > str.length) return false
      if (str.charAt(index) != char) return false
    })
    return true
  }
  def lcp( arr : Array[String]) : String = {
    var prefix : String = ""

    if( arr.size == 0) return prefix
    if( arr.size == 1) return arr(0)

    for( i <- 0 to arr(0).length){
      if( isValid( i, arr)){
        prefix += arr(0).charAt(i)
      }else{
        return prefix
      }
    }
    return prefix
  }
  def main( args : Array[String]): Unit ={
    val array = Array("Flower", "Flora", "Flow")
    println( lcp( array ) )
  }
}
