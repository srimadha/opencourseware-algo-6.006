package com.mit.opencourseware.algo.tree

/**
  * Created by Sri on 1/7/2019.
  */
object IsBinaryTreeHeap {
    case class BinaryTree( data :  Int, left: Option[BinaryTree] = None, right : Option[BinaryTree] = None)


  def isHeapData( data : Int, left: Option[Int], right: Option[Int]) : Boolean =  {
    (left, right) match {
      case ( None, None ) => true;
      case ( None, Some(r) ) =>  data <= r
      case ( Some(l), Some(r) ) => data <= r && data <= l
      case ( Some(l), None ) => data <= l
    }
  }
    def isHeap( node : Option[BinaryTree] ) : Boolean = {

      node match {
        case Some(n) => {
          val data = n.data
          val left = getData(n.left)
          val right = getData(n.right)

          if( isHeapData(data, left, right) ){
            isHeap( n.left) && isHeap( n.right )
          }else {
             false
          }
        }
        case _ =>{
          true
        }
      }

    }

  def main( args : Array[String] ): Unit = {
    val root = BinaryTree( 5 ,  Some( BinaryTree(10, Some( BinaryTree(12))) ), Some( BinaryTree(10)));


    println( isHeap( Some(root) ))
  }

  private def getData(n: Option[BinaryTree]) : Option[Int] = {
    n match {
      case Some(l) => Some(l.data)
      case _ => None
    }
  }
}
