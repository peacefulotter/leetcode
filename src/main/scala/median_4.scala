package com.peacefulotter.leetcode

import scala.annotation.tailrec

object median_4 {
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        def computeMean(acc: List[Int]): Double = acc.size % 2 match {
            case 1 => acc(acc.size / 2)
            case 0 => (acc(acc.size / 2 - 1) + acc(acc.size / 2)) / 2d
        }

        @tailrec
        def rec(a1: List[Int], a2: List[Int], acc: List[Int], earlyStop: Int): Double = {
            if (earlyStop == 0)
                return computeMean(acc)
            (a1, a2) match {
                case (x :: xs, y :: ys) if x < y  => rec(xs, a2, x :: acc, earlyStop - 1)
                case (x :: xs, y :: ys) if y <= x => rec(a1, ys, y :: acc, earlyStop - 1)
                case (x :: xs, Nil) => rec(xs, Nil, x :: acc, earlyStop - 1)
                case (Nil, y :: ys) => rec(Nil, ys, y :: acc, earlyStop - 1)
                case _ => computeMean(acc)
            }
        }

        val earlyStop = (nums1.length + nums2.length) / 2 + 2
        rec(nums1.toList, nums2.toList, List(), earlyStop)
    }
}
