package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p13_roman_to_int {
    private val values: Map[Char, Int] = Map(
        '0' -> 0,
        'I' -> 1,
        'V' -> 5,
        'X' -> 10,
        'L' -> 50,
        'C' -> 100,
        'D' -> 500,
        'M' -> 1000,
    )
    
    def romanToInt(s: String): Int = {
        @tailrec
        def rec(i: Int, acc: Int): Int = {
            if ( i == s.length ) return acc
            val next = if (i == s.length - 1) '0' else s(i + 1)
            (s(i), next) match {
                case (l, h) if values(l) < values(h) => rec(i + 2, acc + values(h) - values(l))
                case (l, h) => rec(i + 1, acc + values(l))
            }
        }
        rec(0, 0)
    }
}