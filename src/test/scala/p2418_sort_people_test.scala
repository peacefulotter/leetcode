package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable.ArrayBuffer

class p2418_sort_people_test extends AnyFlatSpec {
  private def test(
      names: Array[String],
      heights: Array[Int],
      expected: Array[String],
  ): Unit = {
    assert(p2418_sort_people.sortPeople(names, heights) === expected)
  }

  it should "[Mary,John,Emma], [180,165,170] => [Mary,Emma,John]" in {
    test(Array("Mary", "John", "Emma"), Array(180, 165, 170), Array("Mary", "Emma", "John"))
  }
}
