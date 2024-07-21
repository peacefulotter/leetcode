package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p34_first_last_pos_arr_test extends AnyFlatSpec {
  private def test(arr: Array[Int], target: Int, expected: Array[Int]) = {
    assert(p34_first_last_pos_arr.searchRange(arr, target) === expected)
  }

  it should "[5,7,7,8,8,10], 8 => [3, 4]" in {
    test(Array(5, 7, 7, 8, 8, 10), 8, Array(3, 4))
  }

  it should "[5,7,7,8,8,10], 6 => [-1, -1]" in {
    test(Array(5, 7, 7, 8, 8, 10), 6, Array(-1, -1))
  }

  it should "[], 0 => [-1, -1]" in {
    test(Array(), 0, Array(-1, -1))
  }

  it should "[1], 1 => [0, 0]" in {
    test(Array(1), 1, Array(0, 0))
  }

  it should "[2, 2], 2 => [0, 1]" in {
    test(Array(2, 2), 2, Array(0, 1))
  }

  it should "[1, 4], 4 => [1, 1]" in {
    test(Array(1, 4), 4, Array(1, 1))
  }

  it should "[1, 2, 3], 3 => [2, 2]" in {
    test(Array(1, 2, 3), 3, Array(2, 2))
  }

  it should "[0,0,0,0,1,2,3,3,4,5,6,6,7,8,8,8,9,9,10,10,11,11], 0 => [0, 3]" in {
    test(Array(0,0,0,0,1,2,3,3,4,5,6,6,7,8,8,8,9,9,10,10,11,11), 0, Array(0, 3))
  }
}
