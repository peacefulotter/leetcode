package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class listnode_test extends AnyFlatSpec {
	private def test(a: List[Int], b: List[Int], expected: Boolean) = {
		assert( (ListNode.constructNodes(a) equals ListNode.constructNodes(b)) === expected )
	}
	
	it should "[1, 2, 3], [1, 2] => false" in {
		test(List(1, 2, 3), List(1, 2), false)
	}
	
	it should "[1, 2, 3], [1, 2, 3] => true" in {
		test(List(1, 2, 3), List(1, 2, 3), true)
	}
	
	it should "[1], [] => false" in {
		test(List(1), List(), false)
	}
	
	it should "[], [1] => false" in {
		test(List(), List(1), false)
	}
	
	it should "[0, 1], [1, 0] => false" in {
		test(List(0, 1), List(1, 0), false)
	}
}
