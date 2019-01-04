package com.mit.opencourseware.algo.sort

/**
  * Created by Sri on 1/4/2019npm
  */
object MergeSort {

  def merge[T]( left : List[T], right: List[T],func: ( T, T) => Boolean ): List[T] = {
    (left, right) match {
      case ( Nil, Nil) => Nil
      case ( Nil, right) => right
      case ( left, Nil) => left
      case(leftHead :: leftTail, rightHead :: rightTail) =>
          if (func(leftHead , rightHead)) leftHead::merge(leftTail, right, func)
          else rightHead :: merge(left, rightTail, func)
    }
  }

  def mergeSort[T]( array : List[T], func: (T, T) => Boolean ): List[T] = {
    if( array.size == 0 || array.size == 1) return array
    else{
      val mid = array.length / 2
      val ( left, right) = array.splitAt( mid )
      merge( mergeSort(left,func), mergeSort(right, func), func )
    }
  }

  def func( a : Int, b: Int) : Boolean = {
    a > b
  }

  def main( args : Array[String]): Unit = {
    val random = scala.util.Random
    val arr : List[Int] = random.shuffle( 1 to 80) toList
    val solved: List[Int] = mergeSort(arr, (a: Int, b :Int) => a<b )
    for( i <- 0 to arr.length - 1){
      print( arr(i) + ",");
    }
    println()
    for( i <- 0 to arr.length - 1){
      print( solved(i) + ",");
    }
  }
}
