package com.mit.opencourseware.algo.stack


/**
  * Created by Sri on 1/6/2019.
  */
object ReverseList {

  def reverseList( list : List[Int]): List[Int] = {

    if( list.isEmpty )
      return Nil

    return List( list.last ) ++ reverseList( list.take( list.size - 1) )

  }

  def main( args: Array[String]): Unit = {
    reverseList(List(1,2,3,4,5)).foreach( x => print(x  + ","))
  }
}
