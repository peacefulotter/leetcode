package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p2342_max_sum_pairs {

  private def sumOfDigits(n: Int): Int =
    if (n == 0) 1 else n % 10 + sumOfDigits(n / 10)

  @tailrec
  private def twoMax(arr: List[Int], a: Int = -1, b: Int = -1): Int =
    arr match {
      case x :: xs =>
        if (x > a || x > b) twoMax(xs, x, Math.max(b, a))
        else twoMax(xs, a, b)
      case _ => a + b
    }

  def maximumSum(nums: Array[Int]): Int = {
    val digitsMap = nums.foldLeft(Map[Int, List[Int]]())((acc, n) => {
      val digits = sumOfDigits(n)
      acc + (digits -> (n :: acc.getOrElse(digits, Nil)))
    })

    if (digitsMap.isEmpty)
      return -1

    digitsMap.values.foldLeft(-1)((acc, cur) =>
      if (cur.length < 2) acc else Math.max(acc, twoMax(cur)))
  }
}
