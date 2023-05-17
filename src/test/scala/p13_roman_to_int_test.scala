package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p13_roman_to_int_test extends AnyFlatSpec {
    private def test(s: String, expected: Int) = {
        assert(p13_roman_to_int.romanToInt(s) === expected)
    }
    
    it should "III => 3" in {
        test("III", 3)
    }
    
    it should "IV => 4" in {
        test("IV", 4)
    }
    
    it should "LVIII => 58" in {
        test("LVIII", 58)
    }
    
    it should "MCMXCIV => 1994" in {
        test("MCMXCIV", 1994)
    }
}
