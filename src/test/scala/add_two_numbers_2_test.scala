package com.peacefulotter.leetcode

import add_two_numbers_2.ListNode

import org.scalatest.flatspec.AnyFlatSpec

class add_two_numbers_2_test extends AnyFlatSpec {
    private def test(l1: List[Int], l2: List[Int], expected: List[Int]) = {
        val ll1 = constructNodes(l1)
        val ll2 = constructNodes(l2)
        val ll3 = constructNodes(expected)
        assert(add_two_numbers_2.addTwoNumbers(ll1, ll2).toString === ll3.toString)
    }

    private def constructNodes(arr: List[Int]): ListNode = arr match {
        case x :: xs => new ListNode(x, constructNodes(xs))
        case _ => null
    }

    it should "[2,4,3] + [5,6,4] = [8,0,7]" in {
        test(List(2, 4, 3), List(5, 6, 4), List(7, 0, 8))
    }

    it should "[2,4,9] + [5,6,4,9] = [7,0,4,0,1]" in {
        test(List(2,4,9), List(5,6,4,9), List(7,0,4,0,1))
    }
}
