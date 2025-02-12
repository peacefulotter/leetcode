package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p2364_bad_pairs_test extends AnyFlatSpec {
	private def test(
					  input: Array[Int],
					  expected: Long,
					): Unit = {
		assert(p2364_bad_pairs.countBadPairs(input) == expected)
	}

	it should "[4,1,3,3] -> 5" in {
		test(Array(4, 1, 3, 3), 5)
	}

	it should "[1,2,3,4,5] -> 0" in {
		test(Array(1, 2, 3, 4, 5), 0)
	}

	it should "[56,30,2,73,28,81,75,75,18,63,54,10,69,85,33,89,12,78,57,60,54,65,74,63,53,77] -> 322" in {
		test(Array(56, 30, 2, 73, 28, 81, 75, 75, 18, 63, 54, 10, 69, 85, 33, 89, 12, 78, 57, 60, 54, 65, 74, 63, 53, 77), 322)
	}

}
