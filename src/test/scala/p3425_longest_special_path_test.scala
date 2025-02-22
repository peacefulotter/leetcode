package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p3425_longest_special_path_test extends AnyFlatSpec {
  private def test(
      arr: Array[Array[Int]],
      nums: Array[Int],
      expected: Array[Int]
  ) = {
    assert(
      p3425_longest_special_path.longestSpecialPath(arr, nums) === expected
    )
  }

  it should "edges = [[0,1,2],[1,2,3],[1,3,5],[1,4,4],[2,5,6]], nums = [2,1,2,1,3,1] => [6,2]" in {
    test(
      Array(
        Array(0, 1, 2),
        Array(1, 2, 3),
        Array(1, 3, 5),
        Array(1, 4, 4),
        Array(2, 5, 6),
      ),
      Array(2, 1, 2, 1, 3, 1),
      Array(6, 2)
    )
  }

  it should "edges = [[1,0,8]], nums = [2,2] => [0,1]" in {
    test(
      Array(
        Array(1, 0, 8),
      ),
      Array(2, 2),
      Array(0, 1)
    )
  }

  it should "edges = [[1,0,3]], nums = [4,5] => [3,2]" in {
    test(
      Array(
        Array(1, 0, 3),
      ),
      Array(4, 5),
      Array(3, 2)
    )
  }

  it should "edges = [[0,1,10],[1,2,5]], nums = [2,1,5] => [15,3]" in {
    test(
      Array(
        Array(0, 1, 10),
        Array(1, 2, 5),
      ),
      Array(2, 1, 5),
      Array(15, 3)
    )
  }

  it should "edges = [[2,0,2],[1,2,10]], nums = [1,5,4] => [12, 3]" in {
    test(
      Array(
        Array(2, 0, 2),
        Array(1, 2, 10),
      ),
      Array(1, 5, 4),
      Array(12, 3)
    )
  }

  // MARKED
  it should "edges = [[1,0,1],[1,2,6]], nums = [4,3,5] => [7, 3]" in {
    test(
      Array(
        Array(1, 0, 1),
        Array(1, 2, 6),
      ),
      Array(4, 3, 5),
      Array(7, 3)
    )
  }

  it should "edges = [[1,0,4],[0,2,9]], nums = [4,3,1] => [9,2]" in {
    test(
      Array(
        Array(1, 0, 4),
        Array(0, 2, 9),
      ),
      Array(4, 3, 1),
      Array(9, 2)
    )
  }
}
