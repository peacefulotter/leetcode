package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p41_first_positive_test extends AnyFlatSpec {
    private def test(l1: Array[Int], expected: Int) = {
        assert(p41_first_positive.firstMissingPositive(l1) === expected)
    }

    it should "[3,4,-1,1] -> 2" in {
        test(Array(3,4,-1,1), 2)
    }

    it should "[7,8,9,11,12] -> 1" in {
        test(Array(7,8,9,11,12), 1)
    }

    it should "[1,2,0] -> 3" in {
        test(Array(1,2,0), 3)
    }

    it should "[1,2,4,3,6,7,8,9,10,12,13] -> 5" in {
        test(Array(1,2,4,3,6,7,8,9,10,12,13), 5)
    }

    it should "[11,10,9,8,7,6,5,4,3,2,1] -> 12" in {
        test(Array(11,10,9,8,7,6,5,4,3,2,1), 12)
    }
}
