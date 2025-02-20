package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p1980_unique_bin_string {
  private def fromBinary(s: String): Int = Integer.parseInt(s, 2)
  private def toBinary(n: Int, digits: Int): String = {
    ("0" * digits) + n.toBinaryString takeRight digits
  }

  def findDifferentBinaryString(nums: Array[String]): String = {
    val vals = nums.map(fromBinary).sorted.zipWithIndex.toList
    @tailrec
    def rec(arr: List[(Int, Int)]): Int = arr match {
      case (a, b) :: xs => if (a != b) then b else rec(xs)
      case _            => vals.length
    }
    toBinary(rec(vals), nums.head.length)
  }
}
