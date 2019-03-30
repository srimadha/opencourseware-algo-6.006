package com.mit.opencourseware.algo.stack

import scala.collection.mutable.ListBuffer

/**
  * Created by Sri on 1/6/2019.
  */
object NextGreaterElement {

  def nge( list : List[Int]) : List[Int] = {
    val result = ListBuffer[Int]()
    for( i <- 0 to list.length - 1){
      result += list.takeRight(list.size - (i+1)).find(p => p > list(i)).getOrElse(-1)
    }
    result.result()
  }

  def ngeStack( list: List[Int]): List[Int] = {
    Nil
  }

  def main( args : Array[String]){
    nge(List(4,5,2,25)).foreach( k => print(k +","))
    ngeStack(List(4,5,2,25)).foreach( k => print(k +","))
  }
}
