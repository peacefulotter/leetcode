package com.peacefulotter.leetcode

object p41_first_positive {
    // TODO: unsolved
//    def firstMissingPositive(nums: Array[Int]): Int = {
//        val p = nums.filter(n => n > 0 && n <= nums.length).toList
//        println(nums.mkString("(", ", ", ")") + " " + p)
//
//        // filter <= 0
//        @tailrec
//        def rec(arr: List[Int], min: Int): Int = {
//            println(arr + " " + min)
//            arr match {
//            case x :: xs if x > 0 => rec(xs, Math.min(min, x))
//            case x :: xs if x <= 0 => rec(xs, min)
//            case _ => min + 1
//        }
//        }
//
//        if (p.isEmpty) 1
//        else if (p.size == nums.length) p.size + 1
//        else rec(p, Integer.MAX_VALUE)
//    }
    def firstMissingPositive(nums: Array[Int]): Int = {
        val arr = nums.filter(_ > 0).distinct
        val arr2 = arr.filter(_ <= arr.length).toList

        if ( arr2.isEmpty ) return 1
        // not great
        else if (arr2.size == arr.length) return arr.length + 1

        val r = Range.inclusive(1, arr2.size + 1).map(_ => true).toBuffer
        println(arr2 + " " + r)
        for (elt <- arr2; if elt <= arr2.size + 1)
            r(elt - 1) = false
        println(r)
        r.zipWithIndex.find(_._1).get._2 + 1
    }
}