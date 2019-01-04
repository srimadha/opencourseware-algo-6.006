package com.mit.opencourseware.algo.dynamicprogramming

/**
  * Created by Sri on 1/4/2019.
  */
object FibonacciDynamic {

  val fibMap = Map.newBuilder[Int, Long]
  var counter = 0
  def fib( n : Int ) : Long = {
    fibMap.result().get( n ) match {
      case Some(result) => result
      case _ => {
        counter += 1
        if( n == 1 || n == 2) {
          fibMap += ( n -> n)
        }else {
          fibMap += (n -> (fib(n - 1) + fib(n - 2)))
        }
        fibMap.result().get( n ).get
      }
    }
  }

  def main( args : Array[String]): Unit = {
    println( fib ( 10 ) + ", " + counter)
  }
}
