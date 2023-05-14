package com.peacefulotter.leetcode

import p2_add_two_numbers.ListNode

import org.scalatest.flatspec.AnyFlatSpec

class p6_zigzag_conversion_test extends AnyFlatSpec {
    private def test(s: String, r: Int, res: String) = {
        assert(p6_zigzag_conversion.convert(s, r) === res)
    }

    it should "PAYPALISHIRING, 3 => PAHNAPLSIIGYIR" in {
        test("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR")
    }

    it should "PAYPALISHIRING, 4 => PINALSIGYAHRPI" in {
        test("PAYPALISHIRING", 4, "PINALSIGYAHRPI")
    }
}
