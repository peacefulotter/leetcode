package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class rotated_array_33_test extends AnyFlatSpec {
    private def test(nums: Array[Int], target: Int, expected: Int) = {
        assert(p33_rotated_array.search(nums, target) === expected)
    }

    it should "[4,5,6,7,0,1,2], 0 -> 4" in {
        test(Array(4,5,6,7,0,1,2), 0, 4)
    }

    it should "[4,5,6,7,0,1,2], 3 -> -1" in {
        test(Array(4,5,6,7,0,1,2), 3, -1)
    }

    it should "[1], 0 -> -1" in {
        test(Array(1), 0, -1)
    }

    it should "[1], 1 -> 0" in {
        test(Array(1), 1, 0)
    }

    it should "[1, 3], 1 -> 0" in {
        test(Array(1, 3), 1, 0)
    }

    it should "[1,3,5], 0 -> -1" in {
        test(Array(1,3,5), 0, -1)
    }

    it should "[5,1,2,3,4], 1 -> 1" in {
        test(Array(5,1,2,3,4), 1, 1)
    }

}
