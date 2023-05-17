package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p14_longest_common_prefix_test extends AnyFlatSpec {
    private def test(strs: Array[String], expected: String) = {
        assert(p14_longest_common_prefix.longestCommonPrefix(strs) === expected)
    }
    
    it should "[\"flower\",\"flow\",\"flight\"] => 'fl'" in {
        test(Array("flower","flow","flight"), "fl")
    }
    
    it should "[\"dog\",\"racecar\",\"car\"] => ''" in {
        test(Array("dog","racecar","car"), "")
    }
}
