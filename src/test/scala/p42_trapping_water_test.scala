package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p42_trapping_water_test extends AnyFlatSpec {
  private def test(height: Array[Int], expected: Int) = {
    assert(p42_trapping_water.trap(height) === expected)
  }

  it should "[0,1,0,2,1,0,1,3,2,1,2,1] -> 6" in {
    test(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1), 6)
  }

  it should "[4,2,0,3,2,5] -> 9" in {
    test(Array(4, 2, 0, 3, 2, 5), 9)
  }

  it should "[3, 1, 2] -> 1" in {
    test(Array(3, 1, 2), 1)
  }

  it should "[2, 1, 3] -> 1" in {
    test(Array(2, 1, 3), 1)
  }
}
