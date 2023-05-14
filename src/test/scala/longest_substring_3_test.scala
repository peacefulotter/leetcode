package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class longest_substring_3_test extends AnyFlatSpec {
    private def test(s: String, i: Int) = {
        assert(p3_longest_substring.lengthOfLongestSubstring(s) === i)
    }

    it should "abcabcbb = 3" in {
        test("abcabcbb", 3)
    }

    it should "bbbbb = 1" in {
        test("bbbbb", 1)
    }

    it should "pwwkew = 3" in {
        test("pwwkew", 3)
    }

    it should "qrsvbspk = 5" in {
        test("qrsvbspk", 5)
    }

    it should "xsmxvvwxhdylaeva = 9" in {
        test("xsmxvvwxhdylaeva", 9)
    }

    it should "taxliekzrzmqkxhffoilxebcb = 9" in {
        test("taxliekzrzmqkxhffoilxebcb", 9)
    }

    it should "awtmojhtslcnfdpffakysphq = 12" in {
        test("awtmojhtslcnfdpffakysphq", 12)
    }

    it should "astabfulijqqxvzpxbbpisfmox = 10" in {
        test("astabfulijqqxvzpxbbpisfmox", 10)
    }

}
