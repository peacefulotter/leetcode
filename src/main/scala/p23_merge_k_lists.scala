package com.peacefulotter.leetcode

import scala.collection.mutable.ListBuffer

object p23_merge_k_lists {
//    def mergeKLists(lists: Array[ListNode]): ListNode = {
//        var rest: ArrayBuffer[(ListNode, Int)] = null
//        @tailrec
//        def rec(arr: ArrayBuffer[(ListNode, Int)], first: ListNode, last: ListNode): ListNode = {
//            rest = arr.filter(_._1 != null)
//            if (rest.isEmpty)
//                return first
//            val m = rest.minBy(_._1.x)
//            arr(m._2) = (m._1.next, m._2)
//            val node = new ListNode(m._1.x, null)
//            if (last != null)
//                last.next = node
//            rec(arr, if (first == null) node else first, node)
//        }
//        rec(ArrayBuffer(lists.zipWithIndex: _*), null, null)
//    }
    def mergeKLists(lists: Array[ListNode]): ListNode = {
        def collect(acc: ListBuffer[Int], arr: Array[ListNode]): Unit = {
            for (node <- arr) {
                var n = node
                while (n != null) {
                    acc.append(n.x)
                    n = n.next
                }
            }
        }
        def toLinkedList(buf: ListBuffer[Int]): ListNode = {
            val parent = new ListNode(0, null)
            var last = parent
            for (i <- buf)
            {
                last.next = new ListNode(i, null)
                last = last.next
            }
            parent
        }

        val buf = ListBuffer[Int]()
        collect(buf, lists)
        val sBuf = buf.sorted
        toLinkedList(sBuf).next
    }
}
