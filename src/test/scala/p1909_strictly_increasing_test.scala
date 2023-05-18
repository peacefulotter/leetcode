package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p1909_strictly_increasing_test extends AnyFlatSpec {
	private def test(arr: Array[Int], expected: Boolean) =
		assert(p1909_strictly_increasing.canBeIncreasing(arr) === expected)

	it should "[2,3,1,2] => false" in {
		test(Array(2,3,1,2), false)
	}

	it should "[1,2,10,5,7] => true" in {
		test(Array(1,2,10,5,7), true)
	}

	it should "[1, 1, 1] => false" in {
		test(Array(1, 1, 1), false)
	}

	it should "[1, 1, 1, 1] => false" in {
		test(Array(1, 1, 1, 1), false)
	}

	it should "[100,21,100] => true" in {
		test(Array(100,21,100), true)
	}
	
	it should "[5,7,4,6] => false" in {
		test(Array(5,7,4,6), false)
	}
	
	it should "[541,783,433,744] => false" in {
		test(Array(541,783,433,744), false)
	}
}
