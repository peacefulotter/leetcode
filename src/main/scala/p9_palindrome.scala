package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p9_palindrome {
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
        
    def isPalindrome(x: Int): Boolean = {
        if (x < 0)
            return false
        
        val len = length(x)
        val half = len / 2f
        val even = (len % 2) == 0
        @tailrec
        def rec(cur: Int, acc: List[Int], i: Int): Boolean =
            if (i < 0) true
            else if (i >= math.floor(half))
                rec(cur / 10, cur % 10 :: acc, i - 1)
            else {
                val j = math.round(half - i) - 1
                if ( acc(j) == cur % 10 )
                    rec(cur / 10, acc, i - 1)
                else
                    false
            }
        rec(x, Nil, len - 1)
    }
}