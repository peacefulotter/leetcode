package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p8_string_to_int_atoi {
    private def toInt(c: Char): Option[Int] = {
        val i = c.toInt - 48
        if (i >= 0 && i <= 9)
            Some(i)
        else
            None
    }
    
    def myAtoi(s: String): Int = {
        if (s == "")
            return 0
        
        @tailrec
        def rec(i: Int, processing: Boolean, mult: Int, acc: Double, signed: Boolean): Double = {
            if (i < 0) return acc
            // println(f"${i} => ${s(i)}, x=${toInt(s(i))}, acc=${acc}")
            (toInt(s(i)), s(i), processing, signed) match {
                case (Some(x), _, _, true) => rec(i - 1, true, 1, x, false)
                case (Some(x), _, true, false) => rec(i - 1, true, mult + 1, acc + (x * Math.pow(10, mult)), signed)
                case (Some(x), _, false, false) => rec(i - 1, true, 1, x, signed)
                case (None, ' ', _, _) => rec(i - 1, false, 0, acc, signed )
                case (None, '-', true, true) => rec(i - 1, false, 0, 0, false )
                case (None, '-', true, false) => rec(i - 1, processing, 0, -acc, true )
                case (None, '+', true, true) => rec(i - 1, false, 0, 0, false )
                case (None, '+', true, false) => rec(i - 1, processing, 0, acc, true )
                case (None, _, _, _) => rec(i - 1, false, 0, 0, false)
            }
        }
    
        val res = rec(s.length - 1, processing = false, 0, 0, false)
        math.max(Integer.MIN_VALUE, math.min(res.toInt, Integer.MAX_VALUE))
    }
}