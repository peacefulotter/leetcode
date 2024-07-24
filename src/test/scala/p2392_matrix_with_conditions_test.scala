package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class p2392_matrix_with_conditions_test extends AnyFlatSpec {
  private def test(
      k: Int,
      rowConditions: Array[Array[Int]],
      colConditions: Array[Array[Int]],
      impossible: Boolean = false
  ): Unit = {
    val mat =
      p2392_matrix_with_conditions.buildMatrix(k, rowConditions, colConditions)

    if (impossible) {
      assert(mat === Array[Array[Array[Int]]]())
      return
    }

    var count = 0
    val positions = ArrayBuffer.fill(k)((0, 0))
    for (i <- 0 until k; j <- 0 until k) {
      val v = mat(i)(j)
      if (v != 0) {
        count += 1
        positions.update(v - 1, (i, j))
      }
    }
    assert(count == k)

    for (cond <- rowConditions)
      cond match {
        case Array(above, below) =>
          assert(positions(above - 1)._1 < positions(below - 1)._1)
      }

    for (cond <- colConditions)
      cond match {
        case Array(left, right) =>
          assert(positions(left - 1)._2 < positions(right - 1)._2)
      }
  }

  it should "3, [[1,2],[3,2]], [[2,1],[3,2]]" in {
    test(3, Array(Array(1, 2), Array(3, 2)), Array(Array(2, 1), Array(3, 2)))
  }

  it should "3, [[1,2],[2,3],[3,1],[2,3]], [[2,1]]" in {
    test(
      3,
      Array(Array(1, 2), Array(2, 3), Array(3, 1), Array(2, 3)),
      Array(Array(2, 1)),
      impossible = true
    )
  }

}
