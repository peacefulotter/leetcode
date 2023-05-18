package com.peacefulotter.leetcode

import scala.collection.mutable

object p15_3sum {
    def threeSum(nums: Array[Int]): List[List[Int]] = {
        val sorted = nums.sorted
        val len = nums.length
        val res = mutable.Set[List[Int]]()
        for (i <- 0 until len)
            for (j <- i + 1 until len)
                for (k <- j + 1 until len) {
                    val (a, b, c) = (sorted(i), sorted(j), sorted(k))
                    println(i, j, k, a, b, c, a + b + c)
                    if (a > 0 || a + c > 0 || a + b + c > 0)
                        return res.toList
                    else if (a + b + c == 0)
                        res.add( List(a, b, c).sorted )
                }
        res.toList
    }
}