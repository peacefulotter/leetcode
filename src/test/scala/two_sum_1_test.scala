package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class two_sum_1_test extends AnyFlatSpec {
    private def test(l: Array[Int], t: Int, expected: Array[Int]) = {
        assert(p1_two_sum.twoSum(l, t) === expected)
    }

    it should "[2,7,11,15] = 9 => [0,1]" in {
        test(Array(2,7,11,15), 9, Array(0,1))
    }

    it should "[3,2,4] = 6 => [1,2]" in {
        test(Array(3,2,4), 6, Array(1,2))
    }

    it should "[0,4,3,0] = 0 => [0, 3]" in {
        test(Array(0,4,3,0), 0, Array(0,3))
    }

    it should "[-3,4,3,90] = 0 => [0, 2]" in {
        test(Array(-3,4,3,90), 0, Array(0,2))
    }
}
