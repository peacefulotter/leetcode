package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p1980_unique_bin_string_test extends AnyFlatSpec {
	private def test(arr: Array[String], expected: String) =
		assert(p1980_unique_bin_string.findDifferentBinaryString(arr) === expected)

	it should "[01, 10] => 00 | 11" in {
		test(Array("01", "10"), "00" )
	}

	it should "[00, 01] => 10 | 11" in {
		test(Array("00", "01"), "10")
	}
}
