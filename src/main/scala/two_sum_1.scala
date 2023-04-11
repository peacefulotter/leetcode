package com.peacefulotter.leetcode

import scala.annotation.tailrec

object two_sum_1 {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        // .filter(_._1 <= target)
        val arr = nums.zipWithIndex.sortBy(_._1)
        @tailrec
        def rec(low: Int, high: Int): Array[Int] = {
            val l = arr(low)
            val r = arr(high)
            println(low + " " + high + " -> " + l + " " + r)
            (l._1 + r._1) match {
                case t if t == target => Array(l._2, r._2)
                case t if t > target => rec(low, Math.max(high - 1, 0))
                case t if t < target => rec(low + 1, Math.min(high + 1, arr.length - 1))
            }
        }
        rec(0, arr.length - 1)
    }
}