package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p7_reverse_integer {
    // immutable solution using String => very inefficient
//    def reverse(x: Int): Int = {
//        val s = Math.abs(x).toString.toList
//        def rec(i: Int, zeroFlag: Boolean): String = {
//            if (i < 0) ""
//            else if (s(i) == '0' && !zeroFlag) rec(i - 1, zeroFlag)
//            else s(i) + rec(i - 1, true)
//        }
//        val res = rec(s.length - 1, false)
//        if (res.nonEmpty) {
//            try {
//                ((if (x.sign < 0) "-" else "") + res).toInt
//            } catch {
//                case _: Throwable => 0
//            }
//        } else 0
//    }
    
    // dirty but super fast
    def length(x: Double): Int =
        if (x >= 1000000000) 10
        else if (x >= 100000000) 9
        else if (x >= 10000000) 8
        else if (x >= 1000000) 7
        else if (x >= 100000) 6
        else if (x >= 10000) 5
        else if (x >= 1000) 4
        else if (x >= 100) 3
        else if (x >= 10) 2
        else 1
    
    def reverse(x: Int): Int = {
        var cur: Int = x
        var res: Double = 0
        var i: Int = length(x.toDouble.abs) - 1
        while (i >= 0)
        {
            res += (cur % 10) * math.pow(10, i)
            cur /= 10
            i -= 1
        }
        if (res < Integer.MAX_VALUE && res > Integer.MIN_VALUE) res.toInt
        else 0
    }
}