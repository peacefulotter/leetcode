package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p19_remove_nth_node {
    @tailrec
    private def length(n: ListNode, acc: Int = 0): Int = n match {
        case null => acc
        case _ => length(n.next, acc + 1)
    }
    
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        val target = length(head) - n
        def rec(cur: ListNode, i: Int = 0): ListNode =
            if (cur == null) null
            else if (i < target) new ListNode(cur.x, rec(cur.next, i + 1))
            else if (cur.next != null) new ListNode(cur.next.x, cur.next.next)
            else null
        rec(head)
    }
}
