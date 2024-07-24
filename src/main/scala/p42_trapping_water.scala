package com.peacefulotter.leetcode

import scala.annotation.tailrec
import scala.collection.mutable

object p42_trapping_water {

  /** *
    * WORKING SOLUTION USING FUNCTIONAL PROGRAMMING
    * throws Memory Limit Exceeded
    *
    * @tailrec
    * def rec(i: Int, candidates: Map[Int, Int], acc: Int): Int =
    * if (i >= height.length)
    * acc
    * else {
    * val h = height(i)
    * val (water, newCandidates) = candidates.foldLeft((0, Map[Int, Int]())) { case ((w, c), (k, v)) =>
    * (w + (if k <= h then v else 0), c + (k -> (v + (if k > h then 1 else 0))))
    * }
    * val newCandidatesAdd = newCandidates ++ (1 to h map (_ -> 0))
    * rec(i + 1, newCandidatesAdd, acc + water)
    * }
    *
    * rec(0, Map(), 0)
    */
  /** val candidates = mutable.Map[Int, Int]()
    *
    * @tailrec
    * def rec(i: Int, acc: Int): Int =
    * if (i >= height.length)
    * acc
    * else {
    * val h = height(i)
    * val water = candidates.foldLeft(0) { case (w, (k, v)) =>
    * val res = w + (if k <= h then v else 0)
    * if (k > h)
    * candidates.update(k, v + 1)
    * res
    * }
    * for (k <- 1 to h) candidates.update(k, 0)
    * rec(i + 1, acc + water)
    * }
    *
    * rec(0, 0)
    */
  private case class Candidate(value: Int, pos: Int)

  def trap(height: Array[Int]): Int = {
    val candidates = mutable.Map[Int, Candidate]()

    @tailrec
    def rec(i: Int, acc: Int): Int =
      if (i >= height.length)
        acc
      else {
        val h = height(i)
        if (h == 0)
          return rec(i + 1, acc)

        println(f"i ${i}, cand ${candidates}, acc ${acc}")
//        val cand = candidates.foldLeft(None)((best, (cH, c) ⇒
//        ))
        candidates.update(h, Candidate(0, i))
        val water = 0
        println(f"i ${i}, new cand ${candidates}, w ${water}")
        rec(i + 1, acc + water)
      }

    rec(0, 0)
  }
}
