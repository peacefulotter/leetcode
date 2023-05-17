package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p9_palindrome_test extends AnyFlatSpec {
    private def test(x: Int, expected: Boolean) = {
        assert(p9_palindrome.isPalindrome(x) === expected)
    }
    
    it should "123454321 => true" in {
        test(123454321, true)
    }
    
    it should "1234554321 => true" in {
        test(1234554321, true)
    }

    it should "121 => true" in {
        test(121, true)
    }
    
    it should "-121 => false" in {
        test(-121, false)
    }
    
    it should "10 => false" in {
        test(10, false)
    }
}
