package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p33_rotated_array {
    def search(arr: Array[Int], target: Int): Int = {
        println("\n\n")

        def fix(i: Int): Int = if (i < 0) arr.length + i else i

        @tailrec
        def pivot(low: Int = 0, high: Int = arr.length - 1, first: Int): Int = {
            if (low > high) return 0
            val middle = low + (high - low) / 2
            println(low + " " + high + " -> middle: " + middle)
            val m = arr(middle)
            if (m < arr(fix(middle - 1))) middle
            else if (m < first) pivot(low, middle - 1, first)
            else if (m == first) 0
            else pivot(middle + 1, high, first)
        }

        @tailrec
        def search(low: Int, high: Int, p: Int): Int = {
            println("2) " + low + " " + high)
            if (low > high)
                return -1
            val middle = (low + (high - low) / 2)
            val idx = (middle + p) % arr.length
            val m = arr(idx)
            println("2) -> middle: " + middle)
            if (m == target)
                idx
            else if (m > target)
                search(low, middle - 1, p)
            else
                search(middle + 1, high, p)
        }

        val p = pivot(0, arr.length - 1, arr(0))
        println("PIVOT: " + p)
        val idx = search(0, arr.length, p)
        idx
    }
}
