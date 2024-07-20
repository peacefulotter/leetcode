package com.peacefulotter.leetcode

object p2428_hourglass {

  def maxSum(grid: Array[Array[Int]]): Int = {
    def h = grid.length
    def w = grid.head.length

    def rec(i: Int, j: Int, acc: Option[Int]): Option[Int] = {
      if (i > h - 3)
        return acc
      if (j > w - 3)
        return rec(i + 1, 0, acc)

      val hourglass: Int = Range(0, 9)
        .foldLeft(0) { (acc, cur) =>
          if (cur == 3 || cur == 5) acc
          else acc + grid(i + cur / 3)(j + cur % 3)
        }

      rec(
        i,
        j + 1,
        Some(if (acc.isDefined) Math.max(acc.get, hourglass) else hourglass)
      )
    }

    rec(0, 0, None).get
  }
}
