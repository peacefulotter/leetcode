package com.peacefulotter.leetcode

import scala.annotation.tailrec
import scala.collection.mutable

object p6_zigzag_conversion {
	// There is a better way of doing this, without using numRows lists
	
	//	def convert(s: String, numRows: Int): String = {
	//		@tailrec
	//		def rec(idx: Int, row: Int): String = {
	//			if ( idx >= s.length ) rec(0, row + 1)
	//			else s(idx + row)
	//		}
	//
	//		rec(0, 0)
	//	}
	
	def convert(s: String, numRows: Int): String = {
		if (numRows == 1)
			return s
			
		val acc = List.fill(numRows)(mutable.ListBuffer[Char]())
	
		@tailrec
		def rec(i: Int, r: Int, dir: Int): Unit = {
			if ( i >= s.length )
				return
			else if (r < 0 && dir == -1)
				rec(i, r + 2, 1)
			else if (r >= numRows)
				rec(i, r - 2, -1)
			else {
				println(f"i: ${i}=${s(i)}, row: ${r}, dir: ${dir}")
				println(acc)
				acc(r).append(s(i))
				rec(i + 1, r + dir, dir)
			}
		}
		
		rec(0, 0, 1)
		acc.foldLeft("")( (acc, cur) => acc + cur.mkString)
	}
}
