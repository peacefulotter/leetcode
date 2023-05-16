package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p8_string_to_int_atoi_test extends AnyFlatSpec {
    private def test(x: String, expected: Int) = {
        assert(p8_string_to_int_atoi.myAtoi(x) === expected)
    }

    it should "'42' => 42" in {
        test("42", 42)
    }
    
    it should "'   -42' => -42" in {
        test("   -42", -42)
    }
    
    it should "'4193 with words' => 4193" in {
        test("4193 with words", 4193)
    }
    
    it should "'words and 987' => 0" in {
        test("words and 987", 0)
    }
    
    it should "'-91283472332' => -2147483648" in {
        test("-91283472332", -2147483648)
    }
    
    it should "'   +0 123' => 0" in {
        test("   +0 123", 0)
    }
    
    it should "'-13+8' => -13" in {
        test("-13+8", -13)
    }
}
