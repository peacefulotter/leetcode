package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p14_longest_common_prefix {
    def longestCommonPrefix(strs: Array[String]): String = {
        // @tailrec
        def rec(i: Int, acc: String): String = {
            if ( i >= strs(0).length )
                return acc
            val c = strs(0)(i)
            for {
                elt <- strs;
                if i >= elt.length || elt(i) != c
            } return acc
            rec(i + 1, acc + c)
        }
        rec(0, "")
    }
}