package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p2_add_two_numbers {
    class ListNode(_x: Int = 0, _next: ListNode = null) {
        var next: ListNode = _next
        var x: Int = _x
        override def toString: String = x + "" + (next match {
            case n if n != null => ", " + n.toString
            case _ => ""
        })
    }

    private def revert(l: ListNode): ListNode = {
        @tailrec
        def rec(prev: ListNode, cur: ListNode): ListNode = cur.next match {
            case null => new ListNode(cur.x, prev)
            case next => rec(new ListNode(cur.x, prev), next )
        }
        rec(null, l)
    }

    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        def addNode(n1: ListNode, n2: ListNode, acc: ListNode, carry: Int): ListNode = {
            val sum = n1.x + n2.x + carry
            val rem = sum % 10
            val div = sum / 10
            val node = new ListNode(rem, acc)
            rec(n1.next, n2.next, node, div)
        }

        def rec(l1: ListNode, l2: ListNode, acc: ListNode, carry: Int): ListNode = (l1, l2) match {
            case (null, null) =>
                if (carry > 0)
                    new ListNode(carry, acc)
                else
                    acc
            case (n1, null) => addNode(n1, new ListNode(0, null), acc, carry)
            case (null, n2) => addNode(new ListNode(0, null), n2, acc, carry)
            case (n1, n2)   => addNode(n1, n2, acc, carry)
        }

        revert(rec(l1, l2, null, 0))
    }
}