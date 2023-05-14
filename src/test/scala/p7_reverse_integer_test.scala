package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p7_reverse_integer_test extends AnyFlatSpec {
    private def test(x: Int, expected: Int) = {
        assert(p7_reverse_integer.reverse(x) === expected)
    }

    it should "123 => 321" in {
        test(123, 321)
    }
    
    it should "-123 => -321" in {
        test(-123, -321)
    }
    
    it should "120 => 21" in {
        test(120, 21)
    }
    
    it should "1200 => 21" in {
        test(1200, 21)
    }
    
    it should "1534236469 => 0" in {
        test(1534236469, 0)
    }
    
    it should "-2147483648 => 0" in {
        test(-2147483648, 0)
    }
}
