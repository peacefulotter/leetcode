package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class wildcard_matching_test extends AnyFlatSpec {
	it should "aa a => false" in {
		assert(p44_wildcard_matching.isMatch("aa", "a") === false)
	}

	it should "aa * => true" in {
		assert(p44_wildcard_matching.isMatch("aa", "*") === true)
	}

	it should "cb ?a => false" in {
		assert(p44_wildcard_matching.isMatch("cb", "?a") === false)
	}

	it should "ca ?a => true" in {
		assert(p44_wildcard_matching.isMatch("aa", "a") === false)
	}

	it should "ca *a => true" in {
		assert(p44_wildcard_matching.isMatch("ca", "*a") === true)
	}

	it should "cx *a => false" in {
		assert(p44_wildcard_matching.isMatch("cx", "*a") === false)
	}

	it should "lillollil lil*lil => true" in {
		assert(p44_wildcard_matching.isMatch("lillollil", "lil*lil") === true)
	}

	it should "__center__ ??*?? => true" in {
		assert(p44_wildcard_matching.isMatch("__center__", "??*??") === true)
	}

	it should "adceb *a*b => true" in {
		assert(p44_wildcard_matching.isMatch("adceb", "*a*b") === true)
	}

	it should "aa a* => true" in {
		assert(p44_wildcard_matching.isMatch("aa", "a*") === true)
	}

	it should " ***** => true" in {
		assert(p44_wildcard_matching.isMatch("", "*****") === true)
	}

	it should "b *?*? => false" in {
		assert(p44_wildcard_matching.isMatch("b", "*?*?") === false)
	}

	it should "long seq" in {
		assert(p44_wildcard_matching.isMatch("bbaaaabaaaaabbabbabbabbababaabababaabbabaaabbaababababbabaabbabbbbbbaaaaaabaabbbbbabbbbabbabababaaaaa", "******aa*bbb*aa*a*bb*ab***bbba*a*babaab*b*aa*a****") === false)
	}
}
