package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p2342_max_sum_pairs_test extends AnyFlatSpec {
  private def test(
      input: Array[Int],
      expected: Long,
  ): Unit = {
    assert(p2342_max_sum_pairs.maximumSum(input) == expected)
  }

  it should "[18,43,36,13,7] -> 54" in {
    test(Array(18, 43, 36, 13, 7), 54)
  }

  it should "[10,12,19,14] -> -1" in {
    test(Array(10, 12, 19, 14), -1)
  }
}
