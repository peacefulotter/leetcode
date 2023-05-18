package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p23_merge_k_lists_test extends AnyFlatSpec {

    private def test(l1: List[List[Int]],  expected: List[Int]) = {
        val ll1 = l1.map( ListNode.constructNodes ).toArray
        val ll2 = ListNode.constructNodes(expected)
        assert(p23_merge_k_lists.mergeKLists(ll1).toString === ll2.toString)
    }

    it should "[[1,4,5],[1,3,4],[2,6]] -> [1,1,2,3,4,4,5,6]" in {
        test(
            List(List(1,4,5), List(1,3,4), List(2,6)),
            List(1,1,2,3,4,4,5,6)
        )
    }
}
