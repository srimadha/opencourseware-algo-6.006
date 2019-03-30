package com.leetcode.medium



  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

object AddTwoNumber {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var l11 = l1
    var l22 = l2
    var carry = 0
    var node : ListNode = new ListNode( 0 )
    var x = node;
    while( l11!= null && l22!=null){

      val sum = l11.x + l22.x + carry;
      carry = sum / 10
      val pos = sum % 10

      var node1 = new ListNode( pos )
      node.next = node1;
      node = node1;
      l11 = l11.next
      l22 = l22.next
    }

    while( l22 != null ){
      val sum = l22.x + carry
      carry = sum / 10
      val pos = sum % 10

      var node1 = new ListNode( pos )
      node.next = node1
      node = node1
      l22 = l22.next
    }

    while( l11 != null ){
      val sum = l11.x + carry
      carry = sum / 10
      val pos = sum % 10

      var node1 = new ListNode( pos )
      node.next = node1
      node = node1
      l11 = l11.next
    }

    if( carry > 0) {
      node.next = new ListNode( carry )
    }
    return x.next
  }

  def main( args : Array[String]): Unit = {
    val num1 = new ListNode( 5 )

    var num2 = new ListNode( 5)

    addTwoNumbers(num1, num2)

  }
}