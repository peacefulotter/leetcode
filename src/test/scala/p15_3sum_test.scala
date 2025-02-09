package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable

class p15_3sum_test extends AnyFlatSpec {
  private def test(nums: Array[Int], expected: List[List[Int]]): Unit = {
    val obtained = mutable.Set(p15_3sum.threeSum(nums) *)
    println(obtained)

    for (triplet <- expected) {
      assert(obtained.contains(triplet))
      obtained.remove(triplet)
    }
    assert(obtained.isEmpty)
  }

  it should "[-1,0,1,2,-1,-4] => [[-1,0,1],[-1,-1,2]]" in {
    test(Array(-1, 0, 1, 2, -1, -4), List(List(-1, 0, 1), List(-1, -1, 2)))
  }

  it should "[0,1,1] => []" in {
    test(Array(0, 1, 1), List())
  }

  it should "[0,0,0] => [[0,0,0]]" in {
    test(Array(0, 0, 0), List(List(0, 0, 0)))
  }

  it should "[3,0,-2,-1,1,2] => [[-2,-1,3],[-2,0,2],[-1,0,1]]" in {
    test(Array(3, 0, -2, -1, 1, 2),
         List(List(-2, -1, 3), List(-2, 0, 2), List(-1, 0, 1)))
  }

  it should "[1,2,-2,-1] => []" in {
    test(Array(1, 2, -2, -1), List())
  }

  it should "[-1,0,1,2,-1,-4] => [[-1,-1,2],[-1,0,1]]" in {
    test(Array(-1, 0, 1, 2, -1, -4), List(List(-1, -1, 2), List(-1, 0, 1)))
  }

  it should "[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6] =>  " in {
    test(Array(-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6),
         List(List(-4, -2, 6),
              List(-2, -2, 4),
              List(-4, 2, 2),
              List(-4, 1, 3),
              List(-2, 0, 2),
              List(-4, 0, 4)))
  }
}
