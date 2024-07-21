package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p34_first_last_pos_arr {
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    if (nums.length == 0)
      return Array(-1, -1)

    def rec(low: Int, high: Int): Array[Int] = {
      if (low >= high)
        return Array(low, high)
      else if (high - low == 1)
        return Array(
          if (nums(low) == target) low else -1,
          if (nums(high) == target) high else -1
        )
      val window = (high - low) / 2
      val v = nums(low + window)
      println(low, high, "win", window, "idx", low + window, "v", v)
      if (v > target)
        rec(low, high - window)
      else if (v < target)
        rec(low + window, high)
      else {
        val low_rec = rec(low, low + window)
        val high_rec = rec(low + window, high)
        val recs = (low_rec ++ high_rec).filter(_ != -1)
        println(low, high, low_rec.toList, high_rec.toList)
        println(recs)
        if (recs.length == 1)
          Array(recs(0), recs(0))
        else
          recs
      }
    }
    rec(0, nums.length - 1)

//    def binsearch(
//        i: Int,
//        size: Int,
//        left: Boolean = true,
//        furthest: Option[Int] = None
//    ): Int = {
//      println(nums.toList, target, "i", i, "size", size, left, furthest)
//      if (i < 0 || i > nums.length - 1)
//        return furthest.getOrElse(-1)
//
//      val v = nums(i)
//      println(i, v, v == target)
//      if (size == 0) {
//        if (v != target)
//          furthest.getOrElse(-1)
//        else i
//      } else if (v == target)
//        if (left)
//          binsearch(i - Math.max(size / 2, 1), size / 2, left, Some(i))
//        else
//          binsearch(i + Math.max(size / 2, 1), size / 2, left, Some(i))
//      else if (v > target)
//        binsearch(i - Math.max(size / 2, 1), size / 2, left, furthest)
//      else // if (v < target)
//        binsearch(i + Math.max(size / 2, 1), size / 2, left, furthest)
//    }
//
//    println("========")
//    val mid =
//      Math.max(Math.floor(nums.length / 2).toInt + (nums.length % 2 - 1), 0)
//    val size = Math.max(Math.ceil(nums.length / 2).toInt, 1)
//    val first = binsearch(mid, size)
//    println("SKIP", nums.toList, mid, size, first)
//
//    val last =
//      if (first == nums.length - 1 || nums(first + 1) != target) first
//      else binsearch(mid + 1, size, left = false)
//    Array(
//      first,
//      last
//    )
  }
}
