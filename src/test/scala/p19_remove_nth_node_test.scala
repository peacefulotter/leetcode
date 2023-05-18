package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p19_remove_nth_node_test extends AnyFlatSpec {

    private def test(head: List[Int], n: Int, expected: List[Int]) = {
        val l1 = ListNode.constructNodes(head)
        val l2 = ListNode.constructNodes(expected)
        assert(p19_remove_nth_node.removeNthFromEnd(l1, n) === l2)
    }

    it should "[1,2,3,4,5], 2 -> [1,2,3,5]" in {
        test( List(1,2,3,4,5), 2, List(1,2,3,5) )
    }
    
    it should "[1], 1 -> []" in {
        test(List(1), 1, List())
    }
    
    it should "[1,2], 1 -> [1]" in {
        test(List(1, 2), 1, List(1))
    }
}
