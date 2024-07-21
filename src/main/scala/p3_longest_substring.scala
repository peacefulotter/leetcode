package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p3_longest_substring {
  def lengthOfLongestSubstring(s: String): Int = {
    @tailrec
    def rec(
        s: String,
        cur: Vector[Char] = Vector(),
        best: Int = 0
    ): Int = {
      // small optimization to break the recursion sooner
      if (s.isEmpty || s.length + cur.size < best) Math.max(best, cur.size)
      else
        (s.head, s.tail, cur.indexOf(s.head)) match {
          case (c: Char, t: String, i: Int) if i >= 0 => {
            val newCur =
              (cur.zipWithIndex collect { case (x, j) if j > i => x }) :+ c
            rec(t, newCur, Math.max(best, cur.size))
          }
          case _ => rec(s.tail, cur :+ s.head, best)
        }
    }

    rec(s)
  }
}
