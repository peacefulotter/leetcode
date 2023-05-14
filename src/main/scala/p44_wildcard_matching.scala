package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p44_wildcard_matching {
	// TODO: unsolved
	def isMatch(s: String, p: String): Boolean = {
		def reduceStars(p: List[Char]): List[Char] = p match {
			case '*' :: '*' :: xs => reduceStars('*' :: xs)
			case x :: xs => x :: reduceStars(xs)
			case Nil => Nil
		}
		@tailrec
		def wildcard(xs: List[Char], ys: List[Char]): Boolean = xs match {
			case _ :: t => rec(xs, ys) || wildcard(t, ys)
			case Nil => false
		}
		def rec(s: List[Char], p: List[Char]): Boolean = (s, p) match {
			case (x :: xs, y :: ys) =>
			  	(((x == y) || (y == '?')) && rec(xs, ys)) || // normal case
			  	((y == '*') && (ys.isEmpty || wildcard(s, ys))) // wildcard case
			case (Nil, y :: ys) => y == '*' && rec(Nil, ys)
			case (Nil, Nil) => true
			case _ => false
		}
		val sList = s.toList
		val reducedP = reduceStars(p.toList)
		rec(sList, reducedP)
	}
}