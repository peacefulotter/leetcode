package com.peacefulotter.leetcode

import scala.util.boundary
import scala.util.boundary.break

object p41_first_positive {
  def firstMissingPositive(nums: Array[Int]): Int = {
    // Replace too low / high values with len+1
    for (i <- nums.indices;
         n = nums(i)
         if n <= 0 || n > nums.length) {
      nums.update(i, nums.length + 1)
    }

    // Mark values using its negative
    for (i <- nums.indices;
         n = Math.abs(nums(i))
         if n <= nums.length) {
      nums.update(n - 1, -Math.abs(nums(n - 1)))
    }

    // First non-negative is the one missing
    boundary:
      for (i <- nums.indices; n = nums(i); if n > 0)
        break(i + 1)
      nums.length + 1
  }
}
