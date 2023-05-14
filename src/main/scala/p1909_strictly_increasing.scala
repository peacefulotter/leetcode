package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p1909_strictly_increasing {
	def canBeIncreasing(nums: Array[Int]): Boolean = {
		def rec(arr: List[Int], prev: Int, flagged: Boolean): Boolean = arr match {
			case x :: y :: xs if y > x => rec(y :: xs, x, flagged)
			case x :: y :: xs if y <= x && !flagged => (
				(y > prev && rec(y :: xs, y, true)) ||
				(prev > 0 && rec(x :: xs, 0, true))
			)
			case x :: y :: xs if y <= x && flagged => false
			case _ => true
		}
		rec(nums.toList, 0, false)
	}
}