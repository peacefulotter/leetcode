package com.peacefulotter.leetcode

import scala.annotation.tailrec

class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
	
	// println(node.mkString("", "\n", ";"))
	override def toString: String = x + (next match {
		case (node: ListNode) => " -> " + node.toString;
		case _ => ""
	})
	
	@tailrec
	private def recEquals(a: ListNode, b: ListNode): Boolean = (a, b) match {
		case (null, null) => true
		case (a, null) if a != null => false
		case (null, b) if b != null => false
		case (a: ListNode, b: ListNode) => a.x == b.x && recEquals(a.next, b.next)
	}
	
	override def equals(that: Any): Boolean = that match {
		case that: ListNode => recEquals(this, that)
		case _ => false
	}
}

object ListNode {
	def constructNodes(arr: List[Int]): ListNode = arr match {
		case x :: xs => new ListNode(x, constructNodes(xs))
		case _ => null
	}
}
