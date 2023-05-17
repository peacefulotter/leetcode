package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p12_int_to_roman {
    private val dict: Map[Int, Tuple2[String, String]] = Map(
        0 -> ("I", "V"),
        1 -> ("X", "L"),
        2 -> ("C", "D"),
        3 -> ("M", "M"),
    )
    
    def intToRoman(num: Int): String = {
        @tailrec
        def rec(cur: Int, i: Int, acc: String): String =
            if (cur == 0) acc
            else {
                val tail = cur % 10
                val opts = dict(i)
                val sup: String =
                    if (tail == 4) opts._1 + opts._2
                    else if (tail == 9) opts._1 + dict(i + 1)._1
                    else if (tail >= 5) (opts._2 + opts._1 * (tail - 5))
                    else (opts._1 * tail)
                rec( cur / 10, i + 1, sup + acc)
            }
        rec(num, 0, "")
    }
}