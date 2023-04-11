package com.peacefulotter.leetcode

import merge_k_lists_23.ListNode

import org.scalatest.flatspec.AnyFlatSpec

class merge_k_lists_23_test extends AnyFlatSpec {

    private def test(l1: List[List[Int]],  expected: List[Int]) = {
        val ll1 = l1.map( constructNodes ).toArray
        val ll2 = constructNodes(expected)
        assert(merge_k_lists_23.mergeKLists(ll1).toString === ll2.toString)
    }

    private def constructNodes(arr: List[Int]): ListNode = arr match {
        case x :: xs => new ListNode(x, constructNodes(xs))
        case _ => null
    }

    it should "[[1,4,5],[1,3,4],[2,6]] -> [1,1,2,3,4,4,5,6]" in {
        test(
            List(List(1,4,5), List(1,3,4), List(2,6)),
            List(1,1,2,3,4,4,5,6)
        )
    }
}
