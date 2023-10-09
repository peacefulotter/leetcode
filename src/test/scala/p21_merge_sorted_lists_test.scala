package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p21_merge_sorted_lists_test extends AnyFlatSpec {

    private def test(a: List[Int], b: List[Int], expected: List[Int]) = {
        val l1 = ListNode.constructNodes(a)
        val l2 = ListNode.constructNodes(b)
        val l3 = ListNode.constructNodes(expected)
        assert(p21_merge_sorted_lists.mergeTwoLists(l1, l2) === l3)
    }

    it should "[1,2,4], [1,3,4] -> [1,1,2,3,4,4]" in {
        test( List(1,2,4), List(1,3,4), List(1,1,2,3,4,4) )
    }
    
    it should "[], [] -> []" in {
        test(List(), List(), List())
    }
    
    it should "[], [0] -> [0]" in {
        test(List(), List(0), List(0))
    }
}
