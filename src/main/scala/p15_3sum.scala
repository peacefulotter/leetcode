package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p15_3sum {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val sorted = nums.sorted

    @tailrec
    def search(low: Int,
               high: Int,
               origLow: Int,
               origHigh: Int): Option[Int] = {
      if (low >= high) return None
      val mid = low + (high - low) / 2
      if (mid == low || mid == high) return None

      sorted(origLow) + sorted(mid) + sorted(origHigh) match {
        case x if x == 0 => Some(mid)
        case x if x < 0  => search(mid, high, origLow, origHigh)
        case _           => search(low, mid, origLow, origHigh)
      }
    }

    def rec(low: Int, high: Int, allowed: Boolean): Set[List[Int]] = {
      if ((high - low < 2) ||
          (sorted(high) < 0) ||
          (sorted(low) + sorted(high) < sorted(low))) Set()
      else {
        val elt = search(low, high, low, high)
        val restLow = rec(low + 1, high, false)
        val restHigh = if (allowed) then rec (low, high - 1, true) else Nil
        val rest = restLow ++ restHigh
        elt match {
          case Some(mid) => rest + List(sorted(low), sorted(mid), sorted(high))
          case None      => rest
        }
      }
    }

    rec(0, sorted.length - 1, true).toList
  }
}
