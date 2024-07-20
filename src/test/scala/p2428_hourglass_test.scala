package com.peacefulotter.leetcode
import org.scalatest.flatspec.AnyFlatSpec

class p2428_hourglass_test extends AnyFlatSpec {
  private def test(arr: Array[Array[Int]], expected: Int) = {
    assert(p2428_hourglass.maxSum(arr) === expected)
  }

  it should "work" in {
    test(
      Array(
        Array(-9, -9, -9, 1, 1, 1),
        Array(0, -9, 0, 4, 3, 2),
        Array(-9, -9, -9, 1, 2, 3),
        Array(0, 0, 8, 6, 6, 0),
        Array(0, 0, 0, -2, 0, 0),
        Array(0, 0, 1, 2, 4, 0)
      ),
      28
    )
  }
}
