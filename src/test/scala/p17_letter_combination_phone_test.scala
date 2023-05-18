package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p17_letter_combination_phone_test extends AnyFlatSpec {
    private def test(digits: String, expected: List[String]) = {
        assert(p17_letter_combination_phone.letterCombinations(digits) === expected)
    }
    
    it should "23 => [\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]" in {
        test("23", List("ad","ae","af","bd","be","bf","cd","ce","cf"))
    }
    
    it should "'' => []" in {
        test("", List())
    }
    
    it should "2 => [\"a\",\"b\",\"c\"]" in {
        test("2", List("a", "b", "c"))
    }
}
