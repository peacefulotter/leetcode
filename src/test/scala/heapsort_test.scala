package com.peacefulotter.leetcode
import scala.collection.mutable.ListBuffer
import org.scalatest.flatspec.AnyFlatSpec

class heapsort_test extends AnyFlatSpec {
    private def test(arr: ListBuffer[Int]) = {
        assert(heapsort.sort(arr) === arr.sorted)
    }

    it should "[4, 1, 0, 2, 3]" in {
        test(ListBuffer(4, 1, 0, 2, 3))
    }

    it should "[5, 8, 4, 7, 3, 9, 6, 0, 2, 10, 1]" in {
        test(ListBuffer(5, 8, 4, 7, 3, 9, 6, 0, 2, 10, 1))
    }
}
