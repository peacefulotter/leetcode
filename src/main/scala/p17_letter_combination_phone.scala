package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p17_letter_combination_phone {
    implicit class Crossable(xs: List[String]) {
        def cross(ys: List[String]): List[String] = for {x <- xs; y <- ys} yield x + y
    }
    
    val dict: Map[Char, List[String]] = Map(
        '2' -> List("a", "b", "c"),
        '3' -> List("d", "e", "f"),
        '4' -> List("g", "h", "i"),
        '5' -> List("j", "k", "l"),
        '6' -> List("m", "n", "o"),
        '7' -> List("p", "q", "r", "s"),
        '8' -> List("t", "u", "v"),
        '9' -> List("w", "x", "y", "z"),
    )
    
    def letterCombinations(digits: String): List[String] = {
        @tailrec
        def rec(i: Int, acc: List[String]): List[String] = {
            if (i == digits.length) acc
            else {
                val n = dict( digits(i) )
                rec(i + 1, if (acc.isEmpty) n else acc cross n )
            }
        }
        rec(0, Nil)
    }
}