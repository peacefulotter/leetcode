package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class median_4_test extends AnyFlatSpec {
    private def test(l1: Array[Int], l2: Array[Int], expected: Double) = {
        assert(median_4.findMedianSortedArrays(l1, l2) === expected)
    }

    it should "[1,3] + [2] = 2.0" in {
        test(Array(1,3), Array(2), 2)
    }

    it should "[1,2] + [3,4] = 2.5" in {
        test(Array(1,2), Array(3,4), 2.5)
    }
}
