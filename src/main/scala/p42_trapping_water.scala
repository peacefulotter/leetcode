package com.peacefulotter.leetcode

import scala.annotation.tailrec
import scala.collection.mutable

object p42_trapping_water {

	/**
	 * *
	 * WORKING SOLUTION USING FUNCTIONAL PROGRAMMING
	 * throws Memory Limit Exceed
	 *
	 * @tailrec
	 * def rec(i: Int, candidates: Map[Int, Int], acc: Int): Int =
	 * 		if (i >= height.length)
	 * 			acc
	 * 		else {
	 * 			val h = height(i)
	 * 			val (water, newCandidates) = candidates.foldLeft((0, Map[Int, Int]())) { case ((w, c), (k, v)) =>
	 * 				(w + (if k <= h then v else 0), c + (k -> (v + (if k > h then 1 else 0))))
	 * 			}
	 * 			val newCandidatesAdd = newCandidates ++ (1 to h map (_ -> 0))
	 * 			rec(i + 1, newCandidatesAdd, acc + water)
	 * 		}
	 * 		rec(0, Map(), 0)
	 */

	private type Height = Int
	private type Pos = Int
	private case class Candidate(pos: Pos, height: Height)

	def trap(height: Array[Int]): Int = {
		@tailrec
		def rec(i: Int, candidates: List[Candidate], acc: Int): Int =
			if (i >= height.length)
				acc
			else {
				val h = height(i)
				if (h == 0)
					return rec(i + 1, candidates, acc)

				val (maxHeight, water, _) =
					candidates.foldLeft((0, 0, 0)) {
						case ((maxHeight, water, removedLevel), cand) =>
							val level = Math.min(cand.height, h)
							val candWater = (level - removedLevel) * (i - cand.pos - 1)
							val highest = Math.max(maxHeight, cand.height)
							(highest, water + candWater, level)
					}

				val selectedCandidates =
					if (h >= maxHeight) Nil
					else
						candidates filter { cand =>
							cand.height > h
						}
				val newCandidates = Candidate(i, h) :: selectedCandidates

				rec(i + 1, newCandidates, acc + water)
			}

		rec(0, Nil, 0)
	}
}
