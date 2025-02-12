package com.peacefulotter.leetcode

object p2364_bad_pairs {
  def f(n: Long): Long = n * (n + 1) / 2

  def countBadPairs(nums: Array[Int]): Long = {
    val goodPairs = {
      nums.zipWithIndex
        .map(_ - _)
        .foldLeft(Map[Int, Int]()) { (acc, cur) =>
          acc + (cur -> (1 + acc.getOrElse(cur, 0)))
        }
        .values
        .foldLeft(0.toLong) { (acc, sum) =>
          acc + (if (sum <= 1) then 0 else f(sum - 1))
        }
    }
    f(nums.length - 1) - goodPairs
  }
}
