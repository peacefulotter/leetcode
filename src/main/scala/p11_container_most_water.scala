package com.peacefulotter.leetcode

object p11_container_most_water {
    /**
     *  Brute Force Approach
     *  Testing all possibilities => inefficient
     */
//    def maxArea(height: Array[Int]): Int = {
//        if (height.length < 2)
//            return 0
//
//        def rec(low: Int, high: Int): Int = {
//            if (low == high) return 0
//            val area = (high - low) * math.min(height(low), height(high))
//            math.max(area, math.max(rec(low + 1, high), rec(low, high - 1)))
//        }
//
//        rec(0, height.length - 1)
//    }
    
        def maxArea(height: Array[Int]): Int = {
            if (height.length < 2)
                return 0

            def rec(low: Int, high: Int): Int = {
                if (low == high) return 0
                val l = height(low)
                val h = height(high)
                val area = (high - low) * math.min(l, h)
                if (l > h)
                    math.max(area, rec(low, high - 1))
                else
                    math.max(area, rec(low + 1, high))
            }

            rec(0, height.length - 1)
        }
}