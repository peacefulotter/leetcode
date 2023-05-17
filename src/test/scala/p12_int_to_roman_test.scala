package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p12_int_to_roman_test extends AnyFlatSpec {
    private def test(num: Int, expected: String) = {
        assert(p12_int_to_roman.intToRoman(num) === expected)
    }
    
    it should "3 => III" in {
        test(3, "III")
    }
    
    it should "58 => LVIII" in {
        test(58, "LVIII")
    }
    
    it should "1994 => MCMXCIV" in {
        test(1994, "MCMXCIV")
    }
}
