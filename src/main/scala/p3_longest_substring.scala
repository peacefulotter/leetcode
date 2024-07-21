package com.peacefulotter.leetcode

import scala.annotation.tailrec
import scala.collection.mutable

object p3_longest_substring {
  def lengthOfLongestSubstring(s: String): Int = {
    def rec(
        s: String,
        cur: Vector[Char] = Vector(),
        best: Int = 0
    ): Int = {
      println(s, cur, best)
      // small optimization to break the recursion sooner
      if (s.isEmpty || s.length + cur.size < best) Math.max(best, cur.size)
      else
        (s.head, s.tail, cur.indexOf(s.head)) match {
          case (c: Char, t: String, i: Int) if i >= 0 =>
            rec(
              t,
              (cur.zipWithIndex collect { case (x, j) if j > i => x }) :+ c,
              Math.max(best, cur.size)
            )
          case _ => rec(s.tail, cur :+ s.head, best)
        }
    }
    rec(s)

//    @tailrec
//    def append(t: Vector[Char], c: Char): Vector[Char] =
//      if (t.contains(c)) append(t.tail, c) else t :+ c
//
//    def rec(acc: Vector[Char], i: Int): Int = {
//      if (i == s.length)
//        acc.length
//      else {
//        val c = s(i)
//        Math.max(
//          if (acc.contains(c)) acc.length else rec(acc :+ c, i + 1),
//          rec(append(acc, c), i + 1)
//        )
//      }
//    }
//
//    rec(Vector[Char](), 0)
  }
//    def lengthOfLongestSubstring(s: String): Int = {
//        def append(t: ListBuffer[Char], c: Char): ListBuffer[Char] = {
//            var t_ = t
//            while (t_.contains(c))
//                t_ = t_.tail
//            t_ :+ c
//        }
//
//        def rec(acc: ListBuffer[Char], i: Int): Int = {
//            // println(s + " " + acc + " " + i + " " + s(i) + " " + acc.contains(s(i)))
//            if (i == s.length)
//                acc.size
//            else
//                Math.max(
//                    if (acc.contains(s(i))) acc.size else rec(acc :+ s(i), i + 1),
//                    rec(append(acc.clone(), s(i)), i + 1)
//                )
//        }
//
//        rec(ListBuffer[Char](), 0)
//    }
}
