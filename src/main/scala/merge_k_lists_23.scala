package com.peacefulotter.leetcode

import scala.collection.mutable.ListBuffer

object merge_k_lists_23 {
     class ListNode(_x: Int = 0, _next: ListNode = null) {
         var next: ListNode = _next
         var x: Int = _x
         // println(node.mkString("", "\n", ";"))
         override def toString: String = x + (next match {
             case (node: ListNode) => " -> " + node.toString;
             case _ => ""
         } )
     }


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
